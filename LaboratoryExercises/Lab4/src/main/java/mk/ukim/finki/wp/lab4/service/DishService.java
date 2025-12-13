package mk.ukim.finki.wp.lab4.service;

import mk.ukim.finki.wp.lab4.model.Dish;

import java.util.List;

public interface DishService {
    List<Dish> listDishes();

    Dish findByDishId(String dishId);

    Dish findById(Long id);

    Dish create(String dishId, String name, String cuisine, int preparationTime, Long chefId);

    Dish update(Long id, String dishId, String name, String cuisine, int preparationTime);

    void delete(Long id);

    List<Dish> dishesCookedByChef(Long chefId);
}
