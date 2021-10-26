package ir.maktab.busticketspringboot.service.impl;

import ir.maktab.busticketspringboot.domain.User;
import ir.maktab.busticketspringboot.repository.UserRepository;
import ir.maktab.busticketspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
//        User user = new User();
//        user.setUsername("armin");
//        user.setPassword("123");
//        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByToken(String token) {
        return userRepository.findByToken(token);
    }

    @Override
    public void logout(String token) {
        User user = findByToken(token);
        user.setToken(null);
        userRepository.save(user);
    }
}
