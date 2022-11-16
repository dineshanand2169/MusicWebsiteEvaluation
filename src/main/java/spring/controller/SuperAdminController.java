package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import spring.model.Role;
import spring.model.User;
import spring.service.RoleService;
import spring.service.UserService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/superAdmin")
public class SuperAdminController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @GetMapping(value = "/getAllUser")
    public ModelAndView getAllUser() {
        List<Role> userRole = roleService.getUserByRole("ROLE_USER");
        List<User> userList = new ArrayList<>();
        userClassification(userRole, userList);
        userList.removeIf(user -> Objects.equals(user.getStatus(), "Rejected"));
        ModelAndView modelAndView = new ModelAndView("superAdminUserList");
        modelAndView.addObject("userList", userList);
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    public void userClassification(List<Role> userRole, List<User> userList) {
        for (Role role : userRole) {
            User user = userService.getUserByUserName(role.getUserName());
            userList.add(user);
        }
    }
    @GetMapping(value = "/getAllAdmin")
    public ModelAndView getAllAdmin(){
        List<Role> adminRole = roleService.getUserByRole("ROLE_ADMIN");
        List<User> adminList = new ArrayList<>();
        userClassification(adminRole, adminList);
        ModelAndView modelAndView = new ModelAndView("adminList");
        modelAndView.addObject("userList",adminList);
        modelAndView.addObject("user",new User());
        return  modelAndView;
    }
    @GetMapping(value ="/makeAdmin/{id}")
    public ModelAndView makeAdmin(@PathVariable int id) throws SQLException {
        User user = userService.getUserById(id);
        user.setStatus("ok");
        Role role = roleService.getRoleByUserName(user.getUserName());
        role.setRole("ROLE_ADMIN");
        userService.insertUser(user);
        roleService.updateRole(role);
        return new ModelAndView("requestManagementSuccessful");
    }
    @GetMapping(value ="/removeAdmin/{id}")
    public ModelAndView removeAdmin(@PathVariable int id) throws SQLException {
        User user = userService.getUserById(id);
        user.setStatus("ok");
        Role role = roleService.getRoleByUserName(user.getUserName());
        role.setRole("ROLE_USER");
        userService.insertUser(user);
        roleService.updateRole(role);
        return new ModelAndView("requestManagementSuccessful");
    }
}
