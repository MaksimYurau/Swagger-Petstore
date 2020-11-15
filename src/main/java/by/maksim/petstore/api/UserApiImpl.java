package by.maksim.petstore.api;

import by.maksim.petstore.entity.User;
import by.maksim.petstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserApiImpl {

    @Autowired
    private UserRepository userRepository;

    public UserApiImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity <Void> createUser (User user) {
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity <Void> createUsersWithArrayInput (List<User> users) {
        userRepository.saveAll(users);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity <Void> createUsersWithListInput (List<User> users) {
        return createUsersWithArrayInput(users);
    }

    public ResponseEntity<User> getUserByUserName (String userName) {
        return userRepository.findUserByUserName(userName);
    }

    public ResponseEntity<Void> updateUser (String userName, User user) {
        user.setUserName(userName);
        return createUser(user);
    }

    public ResponseEntity<Void> deleteUser (int id) {
        User user = userRepository.findById((long) id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Void> logoutUser () {
        return ResponseEntity.ok().build();
    }

    public static User createUser (int id, String userName, String firstName, String lastName, String email, String password, String phone, int userStatus) {
        return new User(id, userName, firstName, lastName, email, password, phone, userStatus);
    }
}
