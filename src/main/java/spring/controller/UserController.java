package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spring.model.*;
import spring.service.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    AddressService addressService;
    @Autowired
    SongService songService;
    @Autowired
    LibraryService libraryService;
    @Autowired
    BasketService basketService;

    @GetMapping("/registration")
    public ModelAndView userRegistration(){
        ModelAndView modelAndView = new ModelAndView("registrationForm");
        modelAndView.addObject("user",new User());
        modelAndView.addObject("addressDetails",new Address());
        return modelAndView;
    }
    @PostMapping("/saveNewUser")
    public ModelAndView saveNewUser(@ModelAttribute("user")User user,@ModelAttribute("address")Address address){
       User user1= userService.getUpdatedUser(user);
       address.setUserId(user1.getId());
       addressService.insertAddress(address);
        Role role = new Role();
        role.setUserName(user1.getName());
        role.setRole("USER");
        roleService.insertRole(role);
        return new ModelAndView("registrationSuccessful");
    }
    @GetMapping("/getById/{userId}")
    public ModelAndView userProfile(@PathVariable int userId) throws SQLException {
        ModelAndView modelAndView = new ModelAndView("userProfile");
        User user = userService.getUserById(userId);
        List<User> userList = new ArrayList<>();
        userList.add(user);
        modelAndView.addObject("userList",userList);
        modelAndView.addObject("user",new User());
        List<Address> addressDetailsList = addressService.getByUserId(userId);
        modelAndView.addObject("addressDetailsList",addressDetailsList);
        modelAndView.addObject("addressDetails",new Address());
        return modelAndView;
    }
    @GetMapping(value = "/editProfile/{userId}")
    public ModelAndView editProfile(@PathVariable int userId) throws SQLException {
        ModelAndView modelAndView = new ModelAndView("editProfile");
        User user = userService.getUserById(userId);
        modelAndView.addObject("user", user);
        return modelAndView;
    }
    @GetMapping(value = "/editPersonalDetails/{userId}")
    public ModelAndView editPersonalDetails(@PathVariable int userId) throws SQLException {
        ModelAndView modelAndView = new ModelAndView("editPersonalDetails");
        modelAndView.addObject("user", this.userService.getUserById(userId));
        modelAndView.setViewName("editPersonalDetails");
        return modelAndView;
    }

    @PostMapping(value = "/saveUser")
    public ModelAndView saveUser(@ModelAttribute("user") User user) throws SQLException {
        userService.updateUser(user);
        return new ModelAndView("successfulInundation");
    }

    @GetMapping(value = "/editAddressDetails/{userId}")
    public ModelAndView editAddressDetails(@PathVariable int userId) throws SQLException {
        ModelAndView modelAndView = new ModelAndView("editAddressDetails");
        List<Address> addressDetailsList = addressService.getByUserId(userId);
        modelAndView.addObject("addressDetailsList",addressDetailsList);
        modelAndView.addObject("addressDetails",new Address());
        modelAndView.setViewName("editAddressDetails");
        return modelAndView;
    }
    @GetMapping(value = "/editSelectedAddress/{addressId}")
    public ModelAndView editSelectedAddress(@PathVariable int addressId) throws SQLException {
        ModelAndView modelAndView = new ModelAndView("editSelectedAddress");
        Address addressDetails = addressService.getAddressById(addressId);
        modelAndView.addObject("addressDetails", addressDetails);
        modelAndView.setViewName("editSelectedAddress");
        return modelAndView;
    }
    @PostMapping(value = "/saveAddress")
    public ModelAndView saveAddress(@ModelAttribute("addressDetails") Address addressDetails) {
        addressService.insertAddress(addressDetails);
        return new ModelAndView("successfulAddressInundation");
    }
    @GetMapping(value = "/musicList/{userId}")
    public ModelAndView musicList(@PathVariable int userId) throws SQLException {
        List<Song> songList = songService.getAvailableSongs(userId);
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.getUserById(userId);
        List<Song> romanceSongs= new ArrayList<>();
        List<Song> partySongs= new ArrayList<>();
        List<Song> melodySongs= new ArrayList<>();
        List<Song> trendingSongs= new ArrayList<>();
        for(Song song : songList){
            if(Objects.equals(song.getGenre(), "Romance")){
                romanceSongs.add(song);
            } else if (Objects.equals(song.getGenre(), "Party")) {
                partySongs.add(song);
            }else if(Objects.equals(song.getGenre(), "Melody")){
                melodySongs.add(song);
            }else if(Objects.equals(song.getGenre(), "Trending")){
                trendingSongs.add(song);
            }
        }
        modelAndView.addObject("romanceSongs",romanceSongs);
        modelAndView.addObject("partySongs",partySongs);
        modelAndView.addObject("melodySongs",melodySongs);
        modelAndView.addObject("trendingSongs",trendingSongs);
        modelAndView.addObject("song",new Song());
        Basket basket = validateBasket(userId);
        if(Objects.equals(user.getStatus(), "Blocked")){
            modelAndView.setViewName("songList");
        }else if(Objects.equals(user.getStatus(), "ok")){
            modelAndView.addObject("basket",basket);
            modelAndView.setViewName("downloadableSongs");}
        else modelAndView.setViewName("403");
        return modelAndView;
    }
    public Basket validateBasket(int userId) {
        if (basketService.getBasketByUserId(userId, "Pending") == null) {
            Basket basket = new Basket();
            basket.setUserId(userId);
            basket.setBasketStatus("Pending");
            basketService.insertBasket(basket);
            return basket;
        } else return basketService.getBasketByUserId(userId, "Pending");
    }
}
