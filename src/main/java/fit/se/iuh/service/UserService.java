package fit.se.iuh.service;

import org.springframework.stereotype.Service;

import fit.se.iuh.model.User;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    List<User> getAllUser();
    void updateUser(User user);
    void removeUserById(int id);
    Optional<User> getUserById(int id);
    Optional<User> getUserByEmail(String email);
}
