package mk.ukim.finki.wp.lab3.repository.jpa;

import mk.ukim.finki.wp.lab3.model.Chef;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChefRepository extends JpaRepository<Chef, Long> {

}