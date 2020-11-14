package by.maksim.petstore.service;

import by.maksim.petstore.entity.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<User> users = new ArrayList<>();

    public boolean save (User user) {
        return users.add(user);
    }

    public User getUserByUserName (String userName) {
        for (User user : users) {
            if (user.getUserName().equals(userName)) {
                return user;
            }
        }
        return null;
    }

    public User updateUserByUserName (User user, String userName) {
        return null;
    }

    public User deleteUserByUserName (User user, String userName) {
        for (int i = 0; i < users.size(); i++) {
            if (user.getUserName().equals(userName)) {
                user = null;
                return user;
            }
        }
        return null;
    }

    public HttpSession logout (HttpSession httpSession) {
        httpSession.invalidate();
        return httpSession;
    }
}
