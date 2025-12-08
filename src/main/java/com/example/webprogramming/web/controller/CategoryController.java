package com.example.webprogramming.web.controller;

import com.example.webprogramming.model.Category;
import com.example.webprogramming.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public String getProductPage(
            @RequestParam(required = false) String error,
            Model model
    ) {
        if (error != null) {
            model.addAttribute("error", error);
        }

        List<Category> categories = categoryService.listCategories();

        model.addAttribute("categories", categories);
        model.addAttribute("bodyContent", "categories");
        return "master-template";
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        categoryService.delete(id);
        return "redirect:/categories";
    }


    @GetMapping("/edit-form/{id}")
    public String editProductPage(@PathVariable Long id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        model.addAttribute("bodyContent", "category-form");
        return "master-template";
    }

    @GetMapping("/add-form")
    public String addProductPage(Model model) {
        model.addAttribute("bodyContent", "category-form");
        return "master-template";
    }

    @PostMapping
    public String saveProduct(
            @RequestParam String name,
            @RequestParam String description
    ) {
        categoryService.create(name, description);
        return "redirect:/categories";
    }

    @PostMapping("/{id}")
    public String updateProduct(
            @PathVariable Long id,
            @RequestParam String name,
            @RequestParam String description
    ) {
        categoryService.update(id, name, description);
        return "redirect:/categories";
    }
}

