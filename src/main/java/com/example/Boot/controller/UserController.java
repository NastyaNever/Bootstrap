package com.example.Boot.controller;

import com.example.Boot.entity.User;
import com.example.Boot.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

    @GetMapping
    public String userInfo(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user",user);
        return "pages/userPage" ;
    }
}