package mk.ukim.finki.wp.lab4.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab4.model.Chef;
import mk.ukim.finki.wp.lab4.model.Dish;
import mk.ukim.finki.wp.lab4.repository.jpa.ChefRepository;
import mk.ukim.finki.wp.lab4.repository.jpa.DishRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DataHolder {
    public static List<Chef> chefs = null;
    public static List<Dish> dishes = null;

    public final DishRepository dishRepository;
    public final ChefRepository chefRepository;

    public DataHolder(DishRepository dishRepository, ChefRepository chefRepository) {
        this.dishRepository = dishRepository;
        this.chefRepository = chefRepository;
    }

    @PostConstruct
    public void init() {
        if (chefRepository.findAll().isEmpty()) {
            chefs = new ArrayList<>();
            chefs.add(new Chef("Gordon", "Ramsay", "World-renowned chef known for his high standards and innovative dishes blending British and French techniques", new ArrayList<>()));
            chefs.add(new Chef("Massimo", "Bottura", "Innovative Italian chef famous for reinterpreting traditional dishes with modern creativity", new ArrayList<>()));
            chefs.add(new Chef("Jamie", "Oliver", "Chef and food activist promoting healthy eating and easy home cooking", new ArrayList<>()));
            chefs.add(new Chef("Heston", "Blumenthal", "Celebrated for his experimental approach to cooking, using science to create unique flavors and dining experiences", new ArrayList<>()));
            chefs.add(new Chef("Blumenthal", "Keller", "American chef renowned for perfectionism and elegant French-inspired fine dining", new ArrayList<>()));
            chefRepository.saveAll(chefs);
        }

        if (dishRepository.findAll().isEmpty()) {
            dishes = new ArrayList<>();
            Random random = new Random();
            dishes.add(new Dish("D001", "Spaghetti Carbonara", "Italian", 25, chefs.get(random.nextInt(chefs.size()))));
            dishes.add(new Dish("D002", "Sushi Roll", "Japanese", 40, chefs.get(random.nextInt(chefs.size()))));
            dishes.add(new Dish("D003", "Chicken Curry", "Indian", 35, chefs.get(random.nextInt(chefs.size()))));
            dishRepository.saveAll(dishes);
        }
    }
}
