package com.example.springweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PhonebookController {

    @GetMapping("/")
    public String startPage()
    {
        return "startPage";
    }
}
