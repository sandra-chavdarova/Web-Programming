package mk.ukim.finki.wp.lab4.repository.jpa;

import mk.ukim.finki.wp.lab4.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Long> {
    public Dish findDishByDishId(String dishId);

    public List<Dish> findAllByChef_Id(Long chefId);
}
