package mk.ukim.finki.wp.lab4.web.controller;

import mk.ukim.finki.wp.lab4.model.Chef;
import mk.ukim.finki.wp.lab4.model.Dish;
import mk.ukim.finki.wp.lab4.service.ChefService;
import mk.ukim.finki.wp.lab4.service.DishService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/chefDetails")
public class ChefDetailsController {
    private final ChefService chefService;
    private final DishService dishService;

    public ChefDetailsController(ChefService chefService, DishService dishService) {
        this.chefService = chefService;
        this.dishService = dishService;
    }

    @GetMapping
    public String getChefDetails(@RequestParam Long chefId, Model model) {
        Chef chef = chefService.findById(chefId);
        List<Dish> dishes = dishService.dishesCookedByChef(chefId);

        model.addAttribute("chef", chef);
        model.addAttribute("dishes", dishes);

        return "chefDetails";
    }

    @PostMapping
    public String addDishToChef(@RequestParam Long chefId, @RequestParam String dishId) {
        Dish dish = dishService.findByDishId(dishId);
        chefService.addDishToChef(chefId, dish.getDishId());
        return "redirect:/chefDetails?chefId=" + chefId;
    }
}
