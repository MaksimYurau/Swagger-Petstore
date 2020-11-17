package by.maksim.petstore.service.inDB;

import by.maksim.petstore.entity.Pet;
import by.maksim.petstore.entity.Status;
import by.maksim.petstore.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Pet createPet(Pet pet) {
        petRepository.save(pet);
        return pet;
    }

    public List<Pet> getPetByStatus(Status status) {
        return petRepository.findPetByStatus(status);
    }

    public Pet updatePet(int petId, Pet pet) {
        pet.setId(petId);
        return createPet(pet);
    }

    public ResponseEntity<Void> deletePet(int petId) {
        Pet pet = petRepository.findById((long) petId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        petRepository.delete(pet);
        return ResponseEntity.ok().build();
    }
}
