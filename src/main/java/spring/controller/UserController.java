package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    ValidationService validationService;
    private static final String ACTION_1 = "addressDetails";

    @GetMapping("/registration")
    public ModelAndView userRegistration() {
        ModelAndView modelAndView = new ModelAndView("registrationForm");
        modelAndView.addObject("user", new User());
        modelAndView.addObject(ACTION_1, new Address());
        return modelAndView;
    }

    @PostMapping("/saveNewUser")
    public ModelAndView saveNewUser(@ModelAttribute("user") User user, @ModelAttribute("address") Address address) {
        User user1 = userService.getUpdatedUser(user);
        Role role = new Role();
        address.setUserId(user1.getId());
        role.setUserName(user1.getUserName());
        role.setRole("ROLE_USER");
        addressService.insertAddress(address);
        roleService.insertRole(role);
        return new ModelAndView("registrationSuccessful");
    }

    @GetMapping("/getById/{userId}")
    public ModelAndView userProfile(@PathVariable int userId) throws SQLException {
        ModelAndView modelAndView = new ModelAndView("userProfile");
        User user = userService.getUserById(userId);
        List<Address> addressDetailsList = addressService.getByUserId(userId);
        List<User> userList = new ArrayList<>();
        userList.add(user);
        modelAndView.addObject("userList", userList);
        modelAndView.addObject("user", new User());
        modelAndView.addObject("addressDetailsList", addressDetailsList);
        modelAndView.addObject(ACTION_1, new Address());
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
        modelAndView.addObject("userId", userId);
        modelAndView.addObject("addressDetailsList", addressDetailsList);
        modelAndView.addObject(ACTION_1, new Address());
        modelAndView.setViewName("editAddressDetails");
        return modelAndView;
    }

    @GetMapping(value = "/addAddress/{userId}")
    public ModelAndView addAddress(@PathVariable int userId) {
        Address address = new Address();
        ModelAndView modelAndView = new ModelAndView("addressForm");
        address.setUserId(userId);
        modelAndView.addObject(ACTION_1, address);
        return modelAndView;
    }

    @GetMapping(value = "/editSelectedAddress/{addressId}")
    public ModelAndView editSelectedAddress(@PathVariable int addressId) throws SQLException {
        ModelAndView modelAndView = new ModelAndView("editSelectedAddress");
        Address addressDetails = addressService.getAddressById(addressId);
        modelAndView.addObject(ACTION_1, addressDetails);
        modelAndView.setViewName("editSelectedAddress");
        return modelAndView;
    }

    @PostMapping(value = "/saveAddress")
    public ModelAndView saveAddress(@ModelAttribute("addressDetails") Address addressDetails) {
        addressService.insertAddress(addressDetails);
        return new ModelAndView("successfulInundation");
    }

    @GetMapping(value = "/allSongs")
    public ModelAndView allSongs() {
        List<Song> romanceSongs = songService.getSongByGenre("Romance");
        List<Song> partySongs = songService.getSongByGenre("Party");
        List<Song> melodySongs = songService.getSongByGenre("Melody");
        List<Song> trendingSongs = songService.getSongByGenre("Trending");
        ModelAndView modelAndView = new ModelAndView("songList");
        modelAndView.addObject("romanceSongs", romanceSongs);
        modelAndView.addObject("partySongs", partySongs);
        modelAndView.addObject("melodySongs", melodySongs);
        modelAndView.addObject("trendingSongs", trendingSongs);
        modelAndView.addObject("song", new Song());
        return modelAndView;
    }

    @GetMapping(value = "/musicList/{userId}")
    public ModelAndView musicList(@PathVariable int userId) throws SQLException {
        User user = userService.getUserById(userId);
        ModelAndView modelAndView = validationService.categorizeSongsForUser(userId);
        Basket basket = validationService.validateUserBasket(userId);
        if (Objects.equals(user.getStatus(), "Blocked")) {
            modelAndView.setViewName("songList");
        } else if (Objects.equals(user.getStatus(), "ok")) {
            modelAndView.addObject("basket", basket);
            modelAndView.setViewName("downloadableSongs");
        } else modelAndView.setViewName("403");
        return modelAndView;
    }

    @GetMapping("/myLibrary/{userId}")
    public ModelAndView myLibrary(@PathVariable int userId) throws SQLException {
        List<Library> userLibrary = libraryService.getLibraryOfUser(userId);
        List<Song> librarySongs = validationService.getLibrarySongs(userId, userLibrary);
        ModelAndView modelAndView = new ModelAndView("myLibrary");
        modelAndView.addObject("librarySongs", librarySongs);
        modelAndView.addObject("song", new Song());
        return modelAndView;
    }

    @GetMapping("/playSong/{songId}")
    public ModelAndView playSong(@PathVariable int songId) throws SQLException {
        Song song = songService.getSongById(songId);
        ModelAndView modelAndView = new ModelAndView("playSong");
        modelAndView.addObject("song", song);
        return modelAndView;
    }
}
