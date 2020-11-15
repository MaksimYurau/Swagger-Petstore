package by.maksim.petstore.controller;

import by.maksim.petstore.entity.User;
import by.maksim.petstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping (path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public boolean save (@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping ("/{userName}")
    public User getUserByUserName (@PathVariable String userName) {
        return userService.getUserByUserName(userName);
    }

    @PutMapping ("/{userName}")
    public User updateUserByUserName (@RequestBody User user, @PathVariable String userName) {
        return userService.updateUserByUserName(user, userName);
    }

    @DeleteMapping ("/{userName}")
    public User deleteUserByUserName (@RequestBody User user, @PathVariable String userName) {
        return userService.deleteUserByUserName(user, userName);
    }

    @GetMapping ("/logout")
    public HttpSession logout (@RequestBody HttpSession httpSession) {
        return userService.logout(httpSession);
    }
}
