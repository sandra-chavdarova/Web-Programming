package mk.ukim.finki.wp.lab4.repository.mock.impl;

import mk.ukim.finki.wp.lab4.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab4.model.Dish;
import mk.ukim.finki.wp.lab4.repository.mock.DishRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class InMemoryDishRepository implements DishRepository {

    @Override
    public List<Dish> findAll() {
        return DataHolder.dishes;
    }

    @Override
    public Dish findByDishId(String dishId) {
        return DataHolder.dishes.stream().filter(d -> d.getDishId().equals(dishId)).findFirst().orElse(null);
    }

    @Override
    public Optional<Dish> findById(Long id) {
        return DataHolder.dishes.stream().filter(d -> Objects.equals(d.getId(), id)).findFirst();
    }

    @Override
    public Dish save(Dish dish) {
        DataHolder.dishes.removeIf(d -> d.getId().equals(dish.getId()));
        DataHolder.dishes.add(dish);
        return dish;
    }

    @Override
    public void deleteById(Long id) {
        DataHolder.dishes.removeIf(d -> d.getId().equals(id));
    }
}
