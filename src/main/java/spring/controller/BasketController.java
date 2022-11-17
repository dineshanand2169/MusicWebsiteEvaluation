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
    @Autowired
    ValidationService validationService;
    private static final String ACTION_1 = "purchaseDetails";
    private static final String ACTION_2 = "Purchased";

    @GetMapping("/basketContent/{songId}/{basketId}")
    public ModelAndView addToBasket(@PathVariable int songId, @PathVariable int basketId) throws SQLException {
        Content content = new Content();
        Basket basket = basketService.getBasketById(basketId);
        content.setSongId(songId);
        content.setBasket(basketService.getBasketById(basketId));
        contentService.insertContent(content);
        ModelAndView modelAndView = new ModelAndView("addedToBasket");
        modelAndView.addObject("userId", basket.getUserId());
        return modelAndView;
    }

    @GetMapping("/basketStatus/{userId}")
    public ModelAndView myBasket(@PathVariable int userId) throws SQLException {
        return validationService.basketStatusValidation(userId);
    }

    @GetMapping("/checkOut/{userId}/{basketId}")
    public ModelAndView checkOutProcess(@PathVariable int userId, @PathVariable int basketId) throws SQLException {
        Basket basket = basketService.getBasketById(basketId);
        PurchaseDetails purchaseDetails = new PurchaseDetails();
        List<Content> contentList = basket.getContentList();
        List<Song> songList = new ArrayList<>();
        ModelAndView modelAndView = new ModelAndView("payment");
        List<Address> addressList = addressService.getByUserId(userId);
        long price = 0;
        for (Content content : contentList) {
            songList.add(songService.getSongById(content.getSongId()));
        }
        for (Song song : songList) {
            price = song.getPrice() + price;
        }
        purchaseDetails.setBillAmount(price);
        purchaseDetails.setBasketId(basket.getBasketId());
        modelAndView.addObject(ACTION_1, purchaseDetails);
        modelAndView.addObject("addressList", addressList);
        modelAndView.addObject("address", new Address());
        return modelAndView;
    }

    @PostMapping(value = "/savePurchase")
    public ModelAndView savePurchase(@ModelAttribute("purchaseDetails") PurchaseDetails purchaseDetails) throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        Basket basket = basketService.getBasketById(purchaseDetails.getBasketId());
        purchaseDetails.setPurchaseDate(date);
        purchaseDetails.setPurchaseStatus(ACTION_2);
        if (Boolean.TRUE.equals(purchaseDetailsService.paymentValidation(purchaseDetails.getPaymentMode()))) {
            if ((addressService.getAddressById(purchaseDetails.getBillingAddressId()) == null) || (addressService.getAddressById(purchaseDetails.getBillingAddressId()).getUserId() != basket.getUserId())) {
                modelAndView.setViewName("errorPage");
            } else {
                basket.setBasketStatus(ACTION_2);
                List<Library> libraryList = new ArrayList<>();
                List<Content> contentList = basket.getContentList();
                List<Song> songList = new ArrayList<>();
                for (Content content : contentList) {
                    Library library = new Library();
                    library.setSongId(content.getSongId());
                    library.setUserId(content.getBasket().getUserId());
                    libraryList.add(library);
                    Song song = songService.getSongById(content.getSongId());
                    song.setDownloadCount(song.getDownloadCount() + 1);
                    songList.add(song);
                    songService.updateSong(song);
                }
                basketService.updateBasket(basket);
                libraryService.insertLibrary(libraryList);
                purchaseDetailsService.insertPurchase(purchaseDetails);
                modelAndView.setViewName("purchaseSuccess");
                modelAndView.addObject(ACTION_1, purchaseDetails);
                modelAndView.addObject("songList", songList);
                modelAndView.addObject("song", new Song());
            }
        } else {
            modelAndView.setViewName("errorPage");
        }
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
    public ModelAndView purchaseHistory(@PathVariable int userId) {
        List<Basket> purchasedBasketList = basketService.getAllBasketByUserId(userId, ACTION_2);
        List<PurchaseDetails> purchaseDetailsList = new ArrayList<>();
        for (Basket basket : purchasedBasketList) {
            PurchaseDetails purchaseDetails = purchaseDetailsService.getPurchaseByBasketId(basket.getBasketId());
            purchaseDetailsList.add(purchaseDetails);
        }
        ModelAndView modelAndView = new ModelAndView("purchaseHistory");
        modelAndView.addObject("purchaseDetailsList", purchaseDetailsList);
        modelAndView.addObject(ACTION_1, new PurchaseDetails());
        return modelAndView;
    }
}
