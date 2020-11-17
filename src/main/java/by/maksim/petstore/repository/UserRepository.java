package by.maksim.petstore.repository;

import by.maksim.petstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    ResponseEntity<User> findUserByUsername (String userName);
}
