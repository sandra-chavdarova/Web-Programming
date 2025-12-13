package mk.ukim.finki.wp.lab4.repository.mock;

import mk.ukim.finki.wp.lab4.model.Chef;

import java.util.List;
import java.util.Optional;

public interface ChefRepository {
    List<Chef> findAll();

    Optional<Chef> findById(Long id);

    Chef save(Chef chef);
}