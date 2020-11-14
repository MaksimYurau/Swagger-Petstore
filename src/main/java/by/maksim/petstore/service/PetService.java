package by.maksim.petstore.service;

import by.maksim.petstore.entity.Pet;
import by.maksim.petstore.entity.Status;
import by.maksim.petstore.entity.Tag;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetService {
    List<Pet> pets = new ArrayList<>();

    public boolean save (Pet pet) {
        return pets.add(pet);
    }

    public List<Pet> findByStatus (Status status) {
        List<Pet> pets1 = new ArrayList<>();
        for (Pet pet : pets) {
            if (pet.getStatus().equals(status)) {
                pets1.add(pet);
            }
        }
        return pets1;
    }

    public Pet findPetById (long petId) {
        for (Pet pet : pets) {
            if (pet.getId() == petId) {
                return pet;
            }
        }
        return null;
    }

    public Pet updatePetById (Pet pet, long id) {

    }

    public Pet deletePetById (Pet pet, long id) {

    }
}
