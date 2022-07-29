package com.example.springweb.dao;

import com.example.springweb.models.Contact;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContactDao {

    private List<Contact> contacts;

    {
        contacts = new ArrayList<>();
        contacts.add(new Contact(1, "jane1", 222333));
        contacts.add(new Contact(2, "jane2", 333222));
        contacts.add(new Contact(3, "jane3", 211444));
    }

    public List<Contact> showList()
    {
        return contacts;
    }

    public Contact getByIndex(int index)
    {
        return contacts.stream().filter(contact -> contact.getId() == index).findAny().orElse(null);
    }
}
