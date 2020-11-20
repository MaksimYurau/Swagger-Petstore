package by.maksim.petstore.service.inDB;

import by.maksim.petstore.entity.User;
import by.maksim.petstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(@Valid User user) {
        userRepository.save(user);
        return user;
    }

    public ResponseEntity<Void> createUsersWithArrayInput(List<User> users) {
        userRepository.saveAll(users);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Void> createUsersWithListInput(List<User> users) {
        return createUsersWithArrayInput(users);
    }

    public ResponseEntity<User> getUserByUserName(String userName) {
        return userRepository.findUserByUsername(userName);
    }

    public User updateUser(String userName, @Valid User user) {
        user.setUsername(userName);
        return createUser(user);
    }

    public ResponseEntity<Void> deleteUser(int id) {
        User user = userRepository.findById((long) id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Void> logoutUser() {
        return ResponseEntity.ok().build();
    }
}
