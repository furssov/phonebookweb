package com.example.springweb.models;

import lombok.Data;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class Contact {

    private int id;
    @NotEmpty(message = "name cant be empty")
    @Size(min = 4, max = 30, message = "bad size")
    private String name;
    private int number;

    public Contact(int id, String name, int number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }

    public Contact() {

    }
}
