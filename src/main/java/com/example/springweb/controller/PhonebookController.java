package com.example.springweb.controller;

import com.example.springweb.dao.ContactDao;
import com.example.springweb.models.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;

@Controller
@RequestMapping("/phonebook")
public class PhonebookController {

    private ContactDao contactDao;
     @Autowired
    public PhonebookController(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    @GetMapping()
    public String contactsList(Model model) throws SQLException {
        model.addAttribute("people", contactDao.showList());
        return "phonebook/contacts";
    }

    @GetMapping("/{id}")
    public String showContact(@PathVariable("id") int id, Model model) throws SQLException {
        model.addAttribute("person", contactDao.getByIndex(id));
        return "phonebook/contact";
    }

    @GetMapping("/new")
    public String addContact(Model model)
    {
        model.addAttribute("person", new Contact());
        return "phonebook/addContact";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") @Valid Contact contact, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors())
        {
            return "phonebook/addContact";
        }
        contactDao.save(contact);
        return "redirect:/phonebook";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) throws SQLException {
            model.addAttribute("person", contactDao.getByIndex(id));
            return "phonebook/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") Contact contact, @PathVariable("id") int id) throws SQLException {
        contactDao.update(id, contact);
        return "redirect:/phonebook";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) throws SQLException {
        contactDao.delete(id);
        return "redirect:/phonebook";
    }
}
