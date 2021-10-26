package ir.maktab.busticketspringboot.service;

import ir.maktab.busticketspringboot.domain.User;

public interface UserService {
    User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);
    User save(User user);
    User findByToken(String token);
    void logout(String token);
}
