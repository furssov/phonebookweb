package com.example.springweb.models;

import lombok.Data;

@Data
public class Contact {

    private int id;
    private String name;
    private int number;

    public Contact(int id, String name, int number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }
}
