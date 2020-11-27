package by.maksim.petstore.repository;

import by.maksim.petstore.entity.Pet;
import by.maksim.petstore.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface PetRepository extends JpaRepository<Pet, Long> {
    Pet getPetsByStatus(Status status);
}
