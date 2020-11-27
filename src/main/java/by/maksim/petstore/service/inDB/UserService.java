package by.maksim.petstore.service.inDB;

import by.maksim.petstore.entity.User;
import by.maksim.petstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean createUser(@Valid User user) {
        userRepository.save(user);
        return true;
    }

    public boolean createUsersWithArrayInput(List<User> users) {
        userRepository.saveAll(users);
        return true;
    }

    public boolean createUsersWithListInput(List<User> users) {
        userRepository.saveAll(users);
        return true;
    }

    public User getUserByUserName(String username) {
        User userByUsername = userRepository.getUserByUsername(username);
        return userByUsername;
    }

    public boolean updateUser(@Valid User user) {
        if (userRepository.existsById((long) user.getId())) {
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public void deleteUser(String username) {
        userRepository.deleteByUsername(username);
    }

    public ResponseEntity<Void> logoutUser() {
        return ResponseEntity.ok().build();
    }
}
