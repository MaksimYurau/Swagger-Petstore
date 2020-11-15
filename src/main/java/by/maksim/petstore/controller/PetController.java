package by.maksim.petstore.controller;

import by.maksim.petstore.entity.Pet;
import by.maksim.petstore.entity.Status;
import by.maksim.petstore.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (path = "/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping
    public boolean savePet (@RequestBody Pet pet) {
         return petService.save(pet);
    }

    @PutMapping
    public boolean updatePet (@RequestBody Pet pet) {
        return petService.save(pet);
    }

    @GetMapping ("/findByStatus")
    public List<Pet> findByStatus (@RequestParam Status status) {
        return petService.findByStatus(status);
    }

    @GetMapping ("/{petId}")
    public Pet findPetById (@PathVariable int petId) {
        return petService.findPetById(petId);
    }

    @PostMapping ("/{petId}")
    public Pet updatePetById (@RequestBody Pet pet, @PathVariable int petId) {
        return petService.updatePetById(pet, petId);
    }

    @DeleteMapping ("/{petId}")
    public Pet deletePetById (@RequestBody Pet pet, @PathVariable int petId) {
        return petService.deletePetById(pet, petId);
    }
}
