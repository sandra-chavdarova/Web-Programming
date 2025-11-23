package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import mk.ukim.finki.wp.lab.service.ChefService;
import mk.ukim.finki.wp.lab.service.DishService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("chefName", chef.getFirstName() + " " + chef.getLastName());
        model.addAttribute("chefBio", chef.getBio());
        model.addAttribute("dishes", chef.getDishes());
        model.addAttribute("chefId", chefId);

        return "chefDetails";
    }

    @PostMapping
    public String addDishToChef(@RequestParam Long chefId, @RequestParam String dishId) {
        Dish dish = dishService.findByDishId(dishId);
        chefService.addDishToChef(chefId, dish.getDishId());
        return "redirect:/chefDetails?chefId=" + chefId;
    }
}
