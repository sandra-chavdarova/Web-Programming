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

    @GetMapping
    public String getManufacturerPage(@RequestParam(required = false) String error, Model model) {
        if (error != null)
            model.addAttribute("error", error);
        List<Manufacturer> manufacturers = manufacturerService.listManufacturers();
        model.addAttribute("manufacturers", manufacturers);
        return "manufacturers";
    }

    @PostMapping("/delete/{id}")
    public String deleteManufacturer(@PathVariable Long id) {
        manufacturerService.delete(id);
        return "redirect:/manufacturers";
    }

    @GetMapping("/edit-form/{id}")
    public String editManufacturerPage(@PathVariable Long id, Model model) {
        model.addAttribute("manufacturer", manufacturerService.findById(id));
        return "manufacturer-form";
    }

    @GetMapping("/add-form")
    public String addManufacturerPage() {
        return "manufacturer-form";
    }

    @PostMapping
    public String saveManufacturer(@RequestParam String name, @RequestParam String address) {
        manufacturerService.create(name, address);
        return "redirect:/manufacturers";
    }

    @PostMapping("/{id}")
    public String updateManufacturer(@PathVariable Long id, @RequestParam String name, @RequestParam String address) {
        manufacturerService.update(id, name, address);
        return "redirect:/manufacturers";
    }
}
