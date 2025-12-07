package com.example.webprogramming.service.impl;

import com.example.webprogramming.model.Manufacturer;
import com.example.webprogramming.model.exceptions.ManufacturerNotFoundException;
import com.example.webprogramming.repository.ManufacturerRepository;
import com.example.webprogramming.service.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;

    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Manufacturer> listManufacturers() {
        return manufacturerRepository.findAll();
    }

    @Override
    public Manufacturer findById(Long id) {
        return manufacturerRepository.findById(id).orElseThrow(() -> new ManufacturerNotFoundException(id));
    }

    @Override
    public Manufacturer create(String name, String address) {
        if (name == null || name.isEmpty() || address == null || address.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return manufacturerRepository.save(new Manufacturer(name, address));
    }

    @Override
    public Manufacturer update(Long id, String name, String address) {
        if (name == null || name.isEmpty() || address == null || address.isEmpty()) {
            throw new IllegalArgumentException();
        }

        Manufacturer manufacturer = manufacturerRepository.findById(id).orElseThrow(() -> new ManufacturerNotFoundException(id));
        manufacturer.setName(name);
        manufacturer.setAddress(address);
        return manufacturerRepository.save(manufacturer);
    }

    @Override
    public void delete(Long id) {
        manufacturerRepository.delete(id);
    }

    @Override
    public List<Manufacturer> searchManufacturers(String text) {
        return manufacturerRepository.search(text);
    }
}
