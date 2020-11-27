package by.maksim.petstore.repository;

import by.maksim.petstore.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existsByName(String name);
}
