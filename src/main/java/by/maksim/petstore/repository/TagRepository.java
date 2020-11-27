package by.maksim.petstore.repository;

import by.maksim.petstore.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface TagRepository extends JpaRepository<Tag, Long> {
    boolean existsByName(String name);
}
