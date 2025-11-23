package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Chef> chefs = new ArrayList<>();
    public static List<Dish> dishes = new ArrayList<>();

    @PostConstruct
    public void init() {
        chefs.add(new Chef(1L, "Gordon", "Ramsay", "World-renowned chef known for his high standards and innovative dishes blending British and French techniques", new ArrayList<>()));
        chefs.add(new Chef(2L, "Massimo", "Bottura", "Innovative Italian chef famous for reinterpreting traditional dishes with modern creativity", new ArrayList<>()));
        chefs.add(new Chef(3L, "Jamie", "Oliver", "Chef and food activist promoting healthy eating and easy home cooking", new ArrayList<>()));
        chefs.add(new Chef(4L, "Heston", "Blumenthal", "Celebrated for his experimental approach to cooking, using science to create unique flavors and dining experiences", new ArrayList<>()));
        chefs.add(new Chef(5L, "Blumenthal", "Keller", "American chef renowned for perfectionism and elegant French-inspired fine dining", new ArrayList<>()));

        dishes.add(new Dish("D001", "Spaghetti Carbonara", "Italian", 25));
        dishes.add(new Dish("D002", "Sushi Roll", "Japanese", 40));
        dishes.add(new Dish("D003", "Chicken Curry", "Indian", 35));
        dishes.add(new Dish("D004", "Beef Tacos", "Mexican", 30));
        dishes.add(new Dish("D005", "Greek Salad", "Greek", 15));
    }
}
