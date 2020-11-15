package by.maksim.petstore.repository;

import by.maksim.petstore.entity.Status;
import by.maksim.petstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findUsersByUserStatus (Status status);
}
