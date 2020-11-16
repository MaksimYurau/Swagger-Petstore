package by.maksim.petstore.api;

import by.maksim.petstore.entity.Pet;
import by.maksim.petstore.entity.Status;
import by.maksim.petstore.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetApiImpl {

    @Autowired
    private PetRepository petRepository;

    public PetApiImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public ResponseEntity<Void> createPet(Pet pet) {
        petRepository.save(pet);
        return ResponseEntity.ok().build();
    }

    public List<Pet> findPetByStatus(Status status) {
        return petRepository.findPetByStatus(status);
    }

    public Optional<Pet> findPetById(int id) {
        return petRepository.findById((long) id);
    }

    public Pet updatePetByPetId(int petId) {
        return null;
    }

    public Pet deletePetByPetId(int petId) {
        return null;
    }
}
