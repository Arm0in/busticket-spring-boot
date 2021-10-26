package ir.maktab.busticketspringboot.controller;

import ir.maktab.busticketspringboot.domain.User;
import ir.maktab.busticketspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@CrossOrigin
@RestController
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody User loggedUser) {
        User user = userService.findByUsername(loggedUser.getUsername());
        if (user != null) {
            if (loggedUser.getPassword().equals(user.getPassword())) {
                String token = generateToken();
                user.setToken(token);
                userService.save(user);
                return new ResponseEntity<>(token, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/logout")
    public ResponseEntity logout(@RequestBody String token){
        try {
            userService.logout(token);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_GATEWAY);
        }
    }

    public static String generateToken() {
        int size = 128;
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        String token = "";
        for (int i = 0; i < size; i++) {
            int randomIndex = (int) (AlphaNumericString.length() * Math.random());
            token += AlphaNumericString.charAt(randomIndex);
        }
        return token;
    }


}
