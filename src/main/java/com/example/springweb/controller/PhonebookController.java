package com.example.springweb.controller;

import com.example.springweb.dao.ContactDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/phonebook")
public class PhonebookController {

    private ContactDao contactDao;
     @Autowired
    public PhonebookController(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    @GetMapping
    public String contactsList(Model model)
    {
        model.addAttribute("people",contactDao.showList());
        return "phonebook/contacts";
    }

    @GetMapping("/{id}")
    public String showContact(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("person", contactDao.getByIndex(id));
        return "phonebook/contact";
    }
}
