package com.example.webprogramming.repository.jpa;

import com.example.webprogramming.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
    List<Manufacturer> findByNameContainingIgnoreCase(String text);
}


