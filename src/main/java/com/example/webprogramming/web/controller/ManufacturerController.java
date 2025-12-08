package com.example.webprogramming.web.controller;

import com.example.webprogramming.model.Manufacturer;
import com.example.webprogramming.service.ManufacturerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/manufacturers")
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @GetMapping()
    public String getProductPage(
            @RequestParam(required = false) String error,
            Model model
    ) {
        if (error != null) {
            model.addAttribute("error", error);
        }

        List<Manufacturer> manufacturers = manufacturerService.listManufacturers();

        model.addAttribute("manufacturers", manufacturers);
        model.addAttribute("bodyContent", "manufacturers");
        return "master-template";
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        manufacturerService.delete(id);
        return "redirect:/manufacturers";
    }


    @GetMapping("/edit-form/{id}")
    public String editProductPage(@PathVariable Long id, Model model) {
        model.addAttribute("manufacturer", manufacturerService.findById(id));
        model.addAttribute("bodyContent", "manufacturer-form");
        return "master-template";
    }

    @GetMapping("/add-form")
    public String addProductPage(Model model) {
        model.addAttribute("bodyContent", "manufacturer-form");
        return "master-template";
    }

    @PostMapping
    public String saveProduct(
            @RequestParam String name,
            @RequestParam String address
    ) {
        manufacturerService.create(name, address);
        return "redirect:/manufacturers";
    }

    @PostMapping("/{id}")
    public String updateProduct(
            @PathVariable Long id,
            @RequestParam String name,
            @RequestParam String address
    ) {
        manufacturerService.update(id, name, address);
        return "redirect:/manufacturers";
    }
}
