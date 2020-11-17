package by.maksim.petstore.service.inMemory;

import by.maksim.petstore.entity.User;
import by.maksim.petstore.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class InMemoryUserService {
    private List<User> users = new ArrayList<>();
    private List<String> tokens = new ArrayList<>();

    public boolean save(User user) {
        return users.add(user);
    }

    public User getUserByUsername(String username) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username)) {
                return users.get(i);
            }
        }
        return null;
    }

    public boolean update(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(user.getUsername())) {
                users.set(i, user);
                return true;
            }
        }
        return false;
    }

    public boolean delete(String username) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username)) {
                users.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean authorize(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                if (user.getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void addToken(String token) {
        tokens.add(token);
    }

    public boolean containsToken(String token) {
        return tokens.contains(token);
    }
}
