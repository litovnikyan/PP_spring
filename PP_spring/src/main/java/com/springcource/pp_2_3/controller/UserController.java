package com.springcource.pp_2_3.controller;

import com.springcource.pp_2_3.model.User;
import com.springcource.pp_2_3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "user/all-users";
    }

    @GetMapping("user/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "/user/addNewUser";
    }

    @PostMapping("/user/addNewUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.persistUser(user);
        return "redirect:/";
    }

    @GetMapping("user/updateUser")
    public String updateUserForm(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "user/updateUser";
    }

    @PostMapping("user/updateUser")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @PostMapping("user/deleteUser")
    public String removeUser(@RequestParam("id") int id) {
        userService.removeUser(id);
        return "redirect:/";
    }

}

