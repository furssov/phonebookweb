package com.example.springweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/phonebook")
public class PhonebookController {

    @GetMapping
    public String peopleList(Model model)
    {
        //Получаем список всех люедй из записной книги
        return null;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model)
    {
        //Получаем конкретного человека по айди
        return null;
    }
}
