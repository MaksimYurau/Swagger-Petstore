package by.maksim.petstore.controller;

import by.maksim.petstore.entity.ApiResponse;
import by.maksim.petstore.entity.User;
import by.maksim.petstore.service.inDB.UserService;
import by.maksim.petstore.service.inMemory.InMemoryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private InMemoryUserService inMemoryUserService;

    @Autowired
    private UserService userService;

    @PostMapping
    public ApiResponse save(@Valid @RequestBody User user) {
        ApiResponse apiResponse;
        if (inMemoryUserService.save(user)) {
            apiResponse = new ApiResponse(HttpStatus.ACCEPTED.value(), "Accepted", "Operation succeed");
        } else {
            apiResponse = new ApiResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Error", "Invalid input");
        }
        return apiResponse;
    }

    @GetMapping(path = "/getBy")
    public User getByUserName(@RequestParam String username) {
        return inMemoryUserService.getUserByUsername(username);
    }

    @PutMapping
    public ApiResponse update(@Valid @RequestBody User user) {
        ApiResponse apiResponse;
        if (inMemoryUserService.update(user)) {
            apiResponse = new ApiResponse(HttpStatus.ACCEPTED.value(), "Accepted", "Operation succeed");
        } else {
            apiResponse = new ApiResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Error", "Invalid input");
        }
        return apiResponse;
    }

    @DeleteMapping(path = "/delete")
    public ApiResponse delete(@RequestParam String username) {
        ApiResponse apiResponse;
        if (inMemoryUserService.delete(username)) {
            apiResponse = new ApiResponse(HttpStatus.ACCEPTED.value(), "Accepted", "Operation succeed");
        } else {
            apiResponse = new ApiResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Error", "Invalid input");
        }
        return apiResponse;
    }

    @PostMapping(path = "/auth")
    public String authorize(@RequestParam String username, @RequestParam String password) {
        String uuid = "not authorized";
        if (inMemoryUserService.authorize(username, password)) {
            uuid = UUID.randomUUID().toString();
            inMemoryUserService.addToken(uuid);
        }
        return uuid;
    }
}
