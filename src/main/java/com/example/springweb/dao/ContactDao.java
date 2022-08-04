package com.example.springweb.dao;

import com.example.springweb.models.Contact;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContactDao {

    private static int ID = 0;

    private List<Contact> contacts;

    {
        contacts = new ArrayList<>();
        contacts.add(new Contact(++ID, "jane", 222333));
        contacts.add(new Contact(++ID, "ann", 333222));
        contacts.add(new Contact(++ID, "nick", 211444));
    }

    public List<Contact> showList()
    {
        return contacts;
    }

    public Contact getByIndex(int index)
    {
        return contacts.stream().filter(contact -> contact.getId() == index).findAny().orElse(null);
    }

    public void save(Contact contact)
    {
        contact.setId(++ID);
        contacts.add(contact);
    }

    public void update(int id, Contact contact) {
        contacts.get(--id).setName(contact.getName());
        contacts.get(--id).setNumber(contact.getNumber());
    }

    public void delete(int id) {
        contacts.removeIf(contact -> contact.getId() == id);
    }
}
