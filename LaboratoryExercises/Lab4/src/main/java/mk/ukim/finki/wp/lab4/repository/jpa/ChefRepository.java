package mk.ukim.finki.wp.lab4.repository.jpa;

import mk.ukim.finki.wp.lab4.model.Chef;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChefRepository extends JpaRepository<Chef, Long> {

}