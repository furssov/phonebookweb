package com.example.springweb.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static
        org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static
        org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static
        org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static
        org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void homeTest() throws Exception
    {
       mockMvc.perform(get("/"))
               .andExpect(status().isOk())
               .andExpect(view().name("startPage"))
               .andExpect(content().string(containsString("Menu:")));
    }
    
}
