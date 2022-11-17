package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import spring.model.*;
import spring.poi.ExcelHelper;
import spring.poi.ResponseMessage;
import spring.service.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    AddressService addressService;
    @Autowired
    BasketService basketService;
    @Autowired
    SongService songService;
    private static final String ACTION_1 = "requestManagementSuccessful";

    @GetMapping(value = "/getAllUser")
    public ModelAndView getAllUser() {
        List<Role> userRole = roleService.getUserByRole("ROLE_USER");
        List<User> userList = new ArrayList<>();
        userClassification(userRole, userList);
        userList.removeIf(user -> Objects.equals(user.getStatus(), "Rejected"));
        userList.removeIf(user -> Objects.equals(user.getStatus(), "Blocked"));
        ModelAndView modelAndView = new ModelAndView("userList");
        modelAndView.addObject("userList", userList);
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    private void userClassification(List<Role> userRole, List<User> userList) {
        for (Role role : userRole) {
            User user = userService.getUserByUserName(role.getUserName());
            userList.add(user);
        }
    }

    @GetMapping(value = "/addressDetails/{userId}")
    public ModelAndView addressDetails(@PathVariable int userId) {
        List<Address> addressDetailsList = addressService.getByUserId(userId);
        ModelAndView modelAndView = new ModelAndView("addressList");
        modelAndView.addObject("addressDetailsList", addressDetailsList);
        modelAndView.addObject("addressDetails", new Address());
        return modelAndView;
    }

    @GetMapping(value = "/viewPurchaseRequest")
    public ModelAndView viewPurchaseRequest() {
        ModelAndView modelAndView = new ModelAndView("purchaseRequestManagement");
        List<Basket> basketList = basketService.getAllBasketByStatus("Pending");
        List<Basket> approvedBasket = basketService.getAllBasketByStatus("Approved");
        for (Basket basket : approvedBasket) {
            basketList.removeIf(pendingBasket -> basket.getUserId() == pendingBasket.getUserId());
        }
        modelAndView.addObject("basket", new Basket());
        modelAndView.addObject("basketList", basketList);
        return modelAndView;
    }

    @GetMapping(value = "/viewContent/{basketId}")
    public ModelAndView viewBasketContent(@PathVariable int basketId) throws SQLException {
        ModelAndView modelAndView = new ModelAndView("pendingBasketContent");
        List<Content> contentList = basketService.getBasketById(basketId).getContentList();
        List<Song> songList = new ArrayList<>();
        for (Content content : contentList) {
            Song song = songService.getSongById(content.getSongId());
            songList.add(song);
        }
        modelAndView.addObject("basketId", basketId);
        modelAndView.addObject("songList", songList);
        modelAndView.addObject("song", new Song());
        return modelAndView;
    }

    @GetMapping(value = "/approveRequest/{basketId}")
    public ModelAndView approveBasketRequest(@PathVariable int basketId) throws SQLException {
        Basket basket = basketService.getBasketById(basketId);
        basket.setBasketStatus("Approved");
        basketService.updateBasket(basket);
        return new ModelAndView("approveRejectRequest");
    }

    @GetMapping(value = "/rejectRequest/{basketId}")
    public ModelAndView rejectBasketRequest(@PathVariable int basketId) throws SQLException {
        Basket basket = basketService.getBasketById(basketId);
        basket.setBasketStatus("Reject");
        basketService.updateBasket(basket);
        return new ModelAndView("approveRejectRequest");
    }

    @GetMapping(value = "/viewRegistrationRequest")
    public ModelAndView registrationRequest() {
        List<User> registeredUserList = userService.getUserByStatus("Registered");
        ModelAndView modelAndView = new ModelAndView("registrationRequest");
        modelAndView.addObject("registeredUserList", registeredUserList);
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @GetMapping(value = "/approveRegistration/{id}")
    public ModelAndView approveRegistration(@PathVariable int id) throws SQLException {
        User user = userService.getUserById(id);
        user.setStatus("ok");
        user.setActive(true);
        userService.insertUser(user);
        return new ModelAndView(ACTION_1);
    }

    @GetMapping(value = "/rejectRegistration/{id}")
    public ModelAndView rejectRegistration(@PathVariable int id) throws SQLException {
        User user = userService.getUserById(id);
        user.setStatus("Rejected");
        user.setActive(false);
        userService.insertUser(user);
        return new ModelAndView(ACTION_1);
    }

    @GetMapping(value = "/addNewSong")
    public ModelAndView addNewSong() {
        ModelAndView modelAndView = new ModelAndView("songForm");
        modelAndView.addObject("song", new Song());
        return modelAndView;
    }

    @PostMapping(value = "/insertSong")
    public ModelAndView saveSong(@ModelAttribute("song") Song song) {
        return songService.validateSong(song);
    }

    @GetMapping(value = "/blockUser/{id}")
    public ModelAndView blockUser(@PathVariable int id) throws SQLException {
        User user = userService.getUserById(id);
        user.setStatus("Blocked");
        userService.insertUser(user);
        return new ModelAndView(ACTION_1);
    }

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (ExcelHelper.hasExcelFormat(file)) {
            try {
                songService.save(file);

                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }

        message = "Please upload an excel file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }
}
