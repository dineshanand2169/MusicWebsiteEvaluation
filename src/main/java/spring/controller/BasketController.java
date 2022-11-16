package spring.controller;

import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spring.model.*;
import spring.pdfHandler.InvoiceGenerator;
import spring.service.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/basket")
public class BasketController {
    @Autowired
    SongService songService;
    @Autowired
    BasketService basketService;
    @Autowired
    ContentService contentService;
    @Autowired
    PurchaseDetailsService purchaseDetailsService;
    @Autowired
    UserService userService;
    @Autowired
    AddressService addressService;
    @Autowired
    LibraryService libraryService;

    @GetMapping("/basketContent/{songId}/{basketId}")
    public ModelAndView addToBasket(@PathVariable int songId, @PathVariable int basketId) throws SQLException {
        Content content = new Content();
        content.setSongId(songId);
        content.setBasket(basketService.getBasketById(basketId));
        contentService.insertContent(content);
        Basket basket = basketService.getBasketById(basketId);
        ModelAndView modelAndView = new ModelAndView("addedToBasket");
        modelAndView.addObject("userId",basket.getUserId());
        return modelAndView;
    }
    @GetMapping("/basketStatus/{userId}")
    public ModelAndView myBasket(@PathVariable int userId) throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        if((basketService.getBasketByUserId(userId,"Pending")==null)&&(basketService.getBasketByUserId(userId,"Approved")==null)){
            modelAndView.setViewName("nullBasket");
        }else if(basketService.getBasketByUserId(userId,"Pending")==null){
            if(basketService.getBasketByUserId(userId,"Approved")!=null){
                Basket basket = basketService.getBasketByUserId(userId,"Approved");
                basketHandling(userId, modelAndView, basket);
                modelAndView.setViewName("approvedBasket");
            }
        }else if((basketService.getBasketByUserId(userId,"Pending")!=null)&&(basketService.getBasketByUserId(userId,"Approved")==null)){
            Basket basket = basketService.getBasketByUserId(userId,"Pending");
            basketHandling(userId,modelAndView,basket);
            modelAndView.setViewName("pendingBasket");
        }else if((basketService.getBasketByUserId(userId,"Pending")!=null)&&(basketService.getBasketByUserId(userId,"Approved")!=null)){
            Basket  pendingBasket = basketService.getBasketByUserId(userId,"Pending");
            Basket approvedBasket = basketService.getBasketByUserId(userId,"Approved");
            List<Content> pendingBasketContent=  pendingBasket.getContentList();
            List<Song> pendingBasketSongs=new ArrayList<>();
            List<Content> approvedBasketContent=approvedBasket.getContentList();
            List<Song> approvedBasketSongs=new ArrayList<>();
            for(Content content : pendingBasketContent){
                pendingBasketSongs.add(songService.getSongById(content.getSongId()));
            }
            modelAndView.addObject("pendingSongList",pendingBasketSongs);
            modelAndView.addObject("song",new Song());
            modelAndView.addObject("userId", userId);
            for(Content content : approvedBasketContent){
                approvedBasketSongs.add(songService.getSongById(content.getSongId()));
            }
            modelAndView.addObject("approvedSongList",approvedBasketSongs);
            modelAndView.addObject("basketId",approvedBasket.getBasketId());
            modelAndView.setViewName("twoBaskets");
        }return modelAndView;
    }

    private void basketHandling(int userId, ModelAndView modelAndView, Basket basket) throws SQLException {
        List<Content> contentList = basket.getContentList();
        List<Song> songList = new ArrayList<>();
        for(Content content : contentList){
            songList.add(songService.getSongById(content.getSongId()));
        }
        modelAndView.addObject("songList",songList);
        modelAndView.addObject("song",new Song());
        modelAndView.addObject("userId", userId);
        modelAndView.addObject("basketId",basket.getBasketId());
    }
    @GetMapping("/checkOut/{userId}/{basketId}")
    public ModelAndView checkOutProcess(@PathVariable int userId,@PathVariable int basketId) throws SQLException {
        Basket basket = basketService.getBasketById(basketId);
        List<Content> contentList = basket.getContentList();
        List<Song> songList = new ArrayList<>();
        long price = 0;
        for(Content content : contentList){
            songList.add(songService.getSongById(content.getSongId()));
        }
        for(Song song : songList){
            price = song.getPrice()+price;
        }
        PurchaseDetails purchaseDetails = new PurchaseDetails();
        purchaseDetails.setBillAmount(price);
        purchaseDetails.setBasketId(basket.getBasketId());
        ModelAndView modelAndView = new ModelAndView("payment");
        modelAndView.addObject("purchaseDetails",purchaseDetails);
        List<Address>addressList= addressService.getByUserId(userId);
        modelAndView.addObject("addressList",addressList);
        modelAndView.addObject("address",new Address());
        return modelAndView;
    }
    @PostMapping(value = "/savePurchase")
    public ModelAndView savePurchase(@ModelAttribute("purchaseDetails")PurchaseDetails purchaseDetails) throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        purchaseDetails.setPurchaseDate(date);
        purchaseDetails.setPurchaseStatus("Purchased");
        Basket basket = basketService.getBasketById(purchaseDetails.getBasketId());
if (Boolean.TRUE.equals(purchaseDetailsService.paymentValidation(purchaseDetails.getPaymentMode()))){
        if((addressService.getAddressById(purchaseDetails.getBillingAddressId())==null)||(addressService.getAddressById(purchaseDetails.getBillingAddressId()).getUserId()!=basket.getUserId())){
            modelAndView.setViewName("errorPage");
        }
        else {
            basket.setBasketStatus("Purchased");
            List<Library>libraryList = new ArrayList<>();
            List<Content>contentList= basket.getContentList();
            List<Song> songList = new ArrayList<>();
            for(Content content:contentList){
                Library library = new Library();
                library.setSongId(content.getSongId());
                library.setUserId(content.getBasket().getUserId());
                libraryList.add(library);
                Song song = songService.getSongById(content.getSongId());
                song.setDownloadCount(song.getDownloadCount()+1);
                songList.add(song);
                songService.updateSong(song);

            }
            basketService.updateBasket(basket);
            libraryService.insertLibrary(libraryList);
            purchaseDetailsService.insertPurchase(purchaseDetails);
            modelAndView.setViewName("purchaseSuccess");
            modelAndView.addObject("purchaseDetails", purchaseDetails);
            modelAndView.addObject("songList",songList);
            modelAndView.addObject("song",new Song());
        }}
        else {modelAndView.setViewName("errorPage");}
        return modelAndView;
    }
    @GetMapping(value = "/export/pdf/{purchaseId}")
    public void exportToPDF(@PathVariable final int purchaseId, HttpServletResponse response) throws DocumentException, IOException, SQLException {
        PurchaseDetails purchaseDetails = purchaseDetailsService.getPurchaseById(purchaseId);
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=EveMusic.com_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        List<PurchaseDetails> purchaseDetailsList = new ArrayList<>();
        purchaseDetailsList.add(purchaseDetails);

        InvoiceGenerator exporter = new InvoiceGenerator(purchaseDetailsList);
        exporter.export(response);
    }
    @GetMapping(value = "/purchaseHistory/{userId}")
    public ModelAndView purchaseHistory(@PathVariable int userId){
        List<Basket>purchasedBasketList= basketService.getAllBasketByUserId(userId,"Purchased");
        List<PurchaseDetails> purchaseDetailsList = new ArrayList<>();
        for(Basket basket : purchasedBasketList){
            PurchaseDetails purchaseDetails = purchaseDetailsService.getPurchaseByBasketId(basket.getBasketId());
           purchaseDetailsList.add(purchaseDetails);
        }
        ModelAndView modelAndView = new ModelAndView("purchaseHistory");
        modelAndView.addObject("purchaseDetailsList",purchaseDetailsList);
        modelAndView.addObject("purchaseDetails",new PurchaseDetails());
        return modelAndView;
    }
}
