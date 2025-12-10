package mk.ukim.finki.wp.lab3.service.impl;

import mk.ukim.finki.wp.lab3.model.Chef;
import mk.ukim.finki.wp.lab3.model.Dish;
import mk.ukim.finki.wp.lab3.repository.jpa.ChefRepository;
import mk.ukim.finki.wp.lab3.repository.jpa.DishRepository;
import mk.ukim.finki.wp.lab3.service.ChefService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChefServiceImpl implements ChefService {
    private final ChefRepository chefRepository;
    private final DishRepository dishRepository;

    public ChefServiceImpl(ChefRepository chefRepository, DishRepository dishRepository) {
        this.chefRepository = chefRepository;
        this.dishRepository = dishRepository;
    }

    @Override
    public List<Chef> listChefs() {
        return chefRepository.findAll();
    }

    @Override
    public Chef findById(Long id) {
        return chefRepository.findById(id).orElse(null);
    }

    @Override
    public Chef addDishToChef(Long chefId, String dishId) {
        Chef chef = findById(chefId);
        Dish dish = dishRepository.findDishByDishId(dishId);
        if (dish != null) {
            dish.setChef(chef);
            dishRepository.save(dish);
        }
        return chef;
    }
}
