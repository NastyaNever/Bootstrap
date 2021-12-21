package com.example.Boot.controller;

import com.example.Boot.entity.User;
import com.example.Boot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/user")
public class UserController {


   private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{name}")
    public String pageForUser(Model model, @PathVariable("name") String name,@ModelAttribute("user") User user) {
        model.addAttribute("user",userService.findByUserName(name));
        return "pages/userPage" ;
    }
}