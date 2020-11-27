package by.maksim.petstore.controller;

import by.maksim.petstore.entity.Pet;
import by.maksim.petstore.entity.Status;
import by.maksim.petstore.service.inDB.PetService;
import by.maksim.petstore.service.inMemory.InMemoryPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/pet")
public class PetController {

    @Autowired
    private InMemoryPetService inMemoryPetService;

    @Autowired
    private PetService petService;

    @PostMapping
    public ResponseEntity<Boolean> add(@Valid @RequestBody Pet pet) {
        if (petService.createPet(pet)) {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/getBy")
    public ResponseEntity<Pet> getById(@RequestParam long id) {
        Pet byId = petService.findById(id);
        if (byId != null) {
            return new ResponseEntity<>(byId, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity<Boolean> update(@Valid @RequestBody Pet pet) {
            if (petService.updatePet(pet)) {
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping(path = "/findByStatus")
    public ResponseEntity<?> getByStatus(@RequestParam Status status) {
        List<Pet> petsByStatus = petService.getPetByStatus(status);
        if (petsByStatus != null) {
            return new ResponseEntity<>(petsByStatus, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<Boolean> deleteById(@RequestParam int id) {
        if (petService.deletePet(id)) {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
