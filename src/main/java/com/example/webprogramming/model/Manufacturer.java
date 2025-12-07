package com.example.webprogramming.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Manufacturer {
    private Long id;
    private String name;
    private String address;

    public Manufacturer(String name, String address) {
        this.id = (long) (Math.random() * 1000);
        this.name = name;
        this.address = address;
    }
}
