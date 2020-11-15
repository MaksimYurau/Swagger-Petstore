package by.maksim.petstore.service;

import by.maksim.petstore.entity.Pet;
import by.maksim.petstore.entity.Status;
import by.maksim.petstore.entity.Tag;
import by.maksim.petstore.exception.PetNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetService {
    private List<Pet> pets = new ArrayList<>();

    public boolean save (Pet pet) throws PetNotFoundException {
        if (!pets.add(pet)) {
            throw new PetNotFoundException();
        } else {
            return true;
        }
    }

    public List<Pet> findByStatus (Status status) throws PetNotFoundException {
        List<Pet> pets1 = new ArrayList<>();
        for (Pet pet : pets) {
            if (pet.getStatus().equals(status)) {
                pets1.add(pet);
                return pets1;
            }
        }
        throw new PetNotFoundException();
    }

    public Pet findPetById (int petId) {
        for (Pet pet : pets) {
            if (pet.getId() == petId) {
                return pet;
            }
        }
        return null;
    }

    public Pet updatePetById (Pet pet, int petId) throws PetNotFoundException {
        throw new PetNotFoundException();
    }

    public Pet deletePetById (Pet pet, int petId) throws PetNotFoundException {
        for (int i = 0; i < pets.size(); i++) {
            if (pet.getId() == petId) {
                pet = null;
                return pet;
            }
        }
        throw new PetNotFoundException();
    }
}
