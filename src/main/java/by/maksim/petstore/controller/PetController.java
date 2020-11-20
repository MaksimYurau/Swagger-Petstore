package by.maksim.petstore.controller;

import by.maksim.petstore.entity.ApiResponse;
import by.maksim.petstore.entity.Pet;
import by.maksim.petstore.entity.Status;
import by.maksim.petstore.service.inMemory.InMemoryPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/pet")
public class PetController {

    @Autowired
    private InMemoryPetService inMemoryPetService;

    @PostMapping
    public ApiResponse add(@RequestBody Pet pet) {
        ApiResponse apiResponse;
        if (inMemoryPetService.save(pet)) {
            apiResponse = new ApiResponse(HttpStatus.ACCEPTED.value(), "Accepted", "Operation succeed");
        } else {
            apiResponse = new ApiResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Error", "Invalid input");
        }
        return apiResponse;
    }

    @GetMapping(path = "/getBy")
    public Pet getByID(@RequestParam long id) {
        return inMemoryPetService.findByID(id);
    }

    @PutMapping
    public ApiResponse update(@RequestBody Pet pet) {
        ApiResponse apiResponse;
        if (inMemoryPetService.update(pet)) {
            apiResponse = new ApiResponse(HttpStatus.ACCEPTED.value(), "Accepted", "Operation succeed");
        } else {
            apiResponse = new ApiResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Error", "Invalid input");
        }
        return apiResponse;
    }

    @GetMapping(path = "/findByStatus")
    public Pet getByStatus(@RequestParam Status status) {
        return inMemoryPetService.getByStatus(status);
    }

    @DeleteMapping(path = "/delete")
    public ApiResponse delete(@RequestParam long id) {
        ApiResponse apiResponse;
        if (inMemoryPetService.delete(id)) {
            apiResponse = new ApiResponse(HttpStatus.ACCEPTED.value(), "Accepted", "Operation succeed");
        } else {
            apiResponse = new ApiResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Error", "Invalid input");
        }
        return apiResponse;
    }
}
