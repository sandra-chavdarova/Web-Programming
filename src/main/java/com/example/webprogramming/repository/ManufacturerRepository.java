package com.example.webprogramming.repository;

import com.example.webprogramming.model.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface ManufacturerRepository {
    Optional<Manufacturer> findById(Long id);

    Manufacturer save(Manufacturer manufacturer);

    List<Manufacturer> findAll();

    List<Manufacturer> search(String text);

    void delete(Long id);

}
