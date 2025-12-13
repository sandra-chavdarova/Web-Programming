package mk.ukim.finki.wp.lab4.web.controller;

import mk.ukim.finki.wp.lab4.model.Chef;
import mk.ukim.finki.wp.lab4.service.ChefService;
import mk.ukim.finki.wp.lab4.service.DishService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/dish")
public class ChooseDishController {

    private final DishService dishService;
    private final ChefService chefService;

    public ChooseDishController(DishService dishService, ChefService chefService) {
        this.dishService = dishService;
        this.chefService = chefService;
    }

    @GetMapping
    public String getDishPage(@RequestParam(required = false) Long chefId, Model model) {
        if (chefId != null) {
            Chef chef = chefService.findById(chefId);
            model.addAttribute("chefName", chef.getFirstName() + " " + chef.getLastName());
            model.addAttribute("chefId", chefId);
        }
        model.addAttribute("dishes", dishService.listDishes());
        return "dishesList";
    }

    @PostMapping
    public String postDish(@RequestParam Long chefId) {
        return "redirect:/dish?chefId=" + chefId;
    }
}
