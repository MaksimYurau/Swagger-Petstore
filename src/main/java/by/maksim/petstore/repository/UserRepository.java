package by.maksim.petstore.repository;

import by.maksim.petstore.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Pet, Long> {

}
