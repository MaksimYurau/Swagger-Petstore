package by.maksim.petstore.controller;

import by.maksim.petstore.entity.User;
import by.maksim.petstore.service.inDB.UserService;
import by.maksim.petstore.service.inMemory.InMemoryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Boolean> addUser(@Valid @RequestBody User user) {
        if (userService.createUser(user)) {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = "/getByUsername")
    public ResponseEntity<User> getByUsername(@Valid @RequestParam String username) {
        User byUsername = userService.getUserByUserName(username);
        if (byUsername != null) {
            return new ResponseEntity<>(byUsername, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Boolean> updateUser(@Valid @RequestBody User user) {
        if (userService.updateUser(user)) {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<?> deleteUser(@Valid @RequestParam String username) {
        userService.deleteUser(username);
//     if (userService.deleteUser(username)){
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
//     }
//     return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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
