package mk.ukim.finki.wp.lab4.web.controller;

import mk.ukim.finki.wp.lab4.model.Dish;
import mk.ukim.finki.wp.lab4.service.ChefService;
import mk.ukim.finki.wp.lab4.service.DishService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/dishes")
public class DishController {
    private final DishService dishService;
    private final ChefService chefService;

    public DishController(DishService dishService, ChefService chefService) {
        this.dishService = dishService;
        this.chefService = chefService;
    }

    @GetMapping()
    public String getDishesPage(@RequestParam(required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", error);
        }
        List<Dish> dishes = dishService.listDishes();
        model.addAttribute("dishes", dishes);
        model.addAttribute("chefs", chefService.listChefs());
        return "listDishes";
    }

    @GetMapping("/dish-form")
    public String getAddDishPage(Model model) {
        model.addAttribute("chefs", chefService.listChefs());
        return "dish-form";
    }

    @PostMapping("/add")
    public String saveDish(@RequestParam String dishId, @RequestParam String name, @RequestParam String cuisine, @RequestParam int preparationTime, @RequestParam Long chefId) {
        dishService.create(dishId, name, cuisine, preparationTime, chefId);
        return "redirect:/dishes";
    }

    @GetMapping("/dish-form/{id}")
    public String getEditDishForm(@PathVariable Long id, Model model) {
        model.addAttribute("dish", dishService.findById(id));
        return "dish-form";
    }

    @PostMapping("/edit/{id}")
    public String editDish(@PathVariable Long id, @RequestParam String dishId, @RequestParam String name, @RequestParam String cuisine, @RequestParam int preparationTime) {
        dishService.update(id, dishId, name, cuisine, preparationTime);
        return "redirect:/dishes";
    }

    @PostMapping("/delete/{id}")
    public String deleteDish(@PathVariable Long id) {
        dishService.delete(id);
        return "redirect:/dishes";
    }

    // integrating with chef
    @PostMapping("/add-to-chef")
    public String addDishToChef(@RequestParam Long chefId, @RequestParam Long dishId) {
        Dish dish = dishService.findById(dishId);
        if (dish == null) {
            throw new RuntimeException();
        }
        chefService.addDishToChef(chefId, dish.getDishId());
        return "redirect:/chefDetails";
    }

    @PostMapping
    public String searchBooksByAuthor(@RequestParam(name = "chefId", required = false) Long chefId, Model model) {
        List<Dish> dishes;
        if (chefId == null) {
            dishes = dishService.listDishes();
        } else {
            dishes = dishService.dishesCookedByChef(chefId);
        }
        model.addAttribute("dishes", dishes);
        model.addAttribute("chefs", chefService.listChefs());
        model.addAttribute("selectedChefId", chefId);
        return "listDishes";
    }
}
