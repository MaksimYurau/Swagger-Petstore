package by.maksim.petstore.service.inDB;

import by.maksim.petstore.entity.Pet;
import by.maksim.petstore.entity.Status;
import by.maksim.petstore.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public boolean createPet(@Valid Pet pet) {
        petRepository.save(pet);
        return true;
    }

    public Pet findById(long id) {
        Optional<Pet> byId = petRepository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        }
        return null;
    }

    public List<Pet> getPetByStatus(Status status) {
        List<Pet> pets = new ArrayList<>();
        pets.add(petRepository.getPetsByStatus(status));
        return pets;
    }

    public boolean updatePet(@Valid Pet pet) {
        if (petRepository.existsById((long) pet.getId())) {
            petRepository.save(pet);
            return true;
        }
        return false;
    }

    public boolean deletePet(int petId) {
        if (petRepository.existsById((long) petId)) {
            petRepository.deleteById((long) petId);
            return true;
        }
        return false;
    }
}
