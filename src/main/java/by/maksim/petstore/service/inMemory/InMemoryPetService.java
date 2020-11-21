package by.maksim.petstore.service.inMemory;

import by.maksim.petstore.entity.Pet;
import by.maksim.petstore.entity.Status;
import by.maksim.petstore.entity.Tag;
import by.maksim.petstore.exception.PetNotFoundException;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class InMemoryPetService {
    private List<Pet> pets = new ArrayList<>();

    public boolean save(@Valid Pet pet) {
        return pets.add(pet);
    }

    public Pet findByID(long id) {
        Pet pet = null;
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getId() == id) {
                return pets.get(i);
            }
        }
        return pet;
    }

    public boolean update(@Valid Pet pet) {
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getId() == pet.getId()) {
                pets.set(i, pet);
                return true;
            }
        }
        return false;
    }

    public Pet getByStatus(Status status) {
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getStatus().equals(status)) {
                return pets.get(i);
            }
        }
        return null;
    }

    public boolean delete(long id) {
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getId() == id) {
                pets.remove(i);
                return true;
            }
        }
        return false;
    }
}
