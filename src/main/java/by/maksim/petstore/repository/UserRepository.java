package by.maksim.petstore.repository;

import by.maksim.petstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    void deleteByUsername(String username);
    User getUserByUsername(String username);
}
