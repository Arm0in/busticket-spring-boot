package ir.maktab.busticketspringboot.service;

import ir.maktab.busticketspringboot.domain.User;

public interface UserService {
    User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);
}
