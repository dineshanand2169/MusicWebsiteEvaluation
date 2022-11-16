package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import spring.model.User;
import spring.service.UserService;
import java.security.Principal;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping("/userHome")
    public ModelAndView userHome(ModelMap model, Principal principal) {

        User user = getUser(principal);
        ModelAndView modelAndView = new ModelAndView("userHome","userName",user.getUserName());
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping("/adminHome")
    public ModelAndView adminHome(ModelMap model,Principal principal) {
        User user = getUser(principal);
        ModelAndView modelAndView = new ModelAndView("adminHome","userName",user.getUserName());
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    private User getUser(Principal principal) {
        String loggedInUserName= principal.getName();
        return userService.getUserByUserName(loggedInUserName);
    }

    @RequestMapping("/superAdminHome")
    public ModelAndView superAminHome(ModelMap model,Principal principal) {
        User user = getUser(principal);
        ModelAndView modelAndView = new ModelAndView("superAdminHome","userName",user.getUserName());
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @GetMapping(value="/login")
    public String login(ModelMap model) {

        return "login";

    }

    @GetMapping(value="/loginError")
    public String loginError(ModelMap model) {
        model.addAttribute("error", "true");
        return "login";
    }

    // for 403 access denied page
    @GetMapping(value = "/403")
    public ModelAndView accesssDenied(Principal user) {

        ModelAndView model = new ModelAndView();
        if (user != null) {
            model.addObject("msg", "Hi " + user.getName()
                    + ", You can not access this page!");
        } else {
            model.addObject("msg",
                    "You can not access this page!");
        }

        model.setViewName("403");
        return model;
    }
}