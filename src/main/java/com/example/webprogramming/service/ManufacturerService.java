package com.example.webprogramming.service;

import com.example.webprogramming.model.Manufacturer;

import java.util.List;

public interface ManufacturerService {
    List<Manufacturer> listManufacturers();

    Manufacturer findById(Long id);

    Manufacturer create(String name, String address);

    Manufacturer update(Long id, String name, String address);

    void delete(Long id);

    List<Manufacturer> searchManufacturers(String text);
}
