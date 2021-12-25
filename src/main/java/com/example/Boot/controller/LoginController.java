package com.example.Boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {

    @GetMapping
    public String index() {
        return "pages/index";
    }

    @GetMapping("/login")
    public String login() {
        return "pages/login";
    }
}
