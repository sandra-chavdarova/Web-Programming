package com.example.webprogramming.web.controller;

import com.example.webprogramming.model.Product;
import com.example.webprogramming.model.enums.ProductLevel;
import com.example.webprogramming.service.CategoryService;
import com.example.webprogramming.service.ManufacturerService;
import com.example.webprogramming.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;
    private final ManufacturerService manufacturerService;

    public ProductController(ProductService productService, CategoryService categoryService, ManufacturerService manufacturerService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.manufacturerService = manufacturerService;
    }

    @GetMapping()
    public String getProductPage(@RequestParam(required = false) String error, @RequestParam(required = false) String search, Model model) {
        if (error != null) {
            model.addAttribute("error", error);
        }
        List<Product> products;
        if (search != null && !search.isEmpty())
            products = productService.search(search);
        else
            products = productService.findAll();
        model.addAttribute("products", products);
        return "products";
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return "redirect:/products";
    }

    @GetMapping("/edit-form/{id}")
    public String editProductPage(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("levels", ProductLevel.values());
        model.addAttribute("categories", categoryService.listCategories());
        model.addAttribute("manufacturers", manufacturerService.listManufacturers());
        return "product-form";
    }

    @GetMapping("/add-form")
    public String addProductPage(Model model) {
        model.addAttribute("levels", ProductLevel.values());
        model.addAttribute("categories", categoryService.listCategories());
        model.addAttribute("manufacturers", manufacturerService.listManufacturers());
        return "product-form";
    }

    @PostMapping
    public String saveProduct(@RequestParam String name, @RequestParam Double price, @RequestParam Integer quantity, @RequestParam ProductLevel level, @RequestParam Long category, @RequestParam Long manufacturer) {
        productService.create(name, price, quantity, level, category, manufacturer);
        return "redirect:/products";
    }

    @PostMapping("/{id}")
    public String updateProduct(@PathVariable Long id, @RequestParam String name, @RequestParam Double price, @RequestParam Integer quantity, @RequestParam ProductLevel level, @RequestParam Long category, @RequestParam Long manufacturer) {
        productService.update(id, name, price, quantity, level, category, manufacturer);
        return "redirect:/products";
    }
}
