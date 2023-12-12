package com.springcource.pp_2_3.controller;

import com.springcource.pp_2_3.model.User;
import com.springcource.pp_2_3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "user/all-users";
    }

    @GetMapping("user/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user/user-info";
    }

    @PostMapping
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("user/updateUser")
    public String updateUserForm(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "user/user-info";
    }

    @GetMapping("user/deleteUser")
    public String removeUser(@RequestParam("id") int id) {
        userService.removeUser(id);
        return "redirect:/";
    }

}

