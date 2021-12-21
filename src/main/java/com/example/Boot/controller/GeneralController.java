package com.example.Boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class GeneralController {

    @GetMapping("/")
    public String index() {
        return "pages/index";
    }
}
