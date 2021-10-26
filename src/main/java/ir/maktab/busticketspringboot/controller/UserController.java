package ir.maktab.busticketspringboot.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import ir.maktab.busticketspringboot.domain.Trip;
import ir.maktab.busticketspringboot.domain.User;
import ir.maktab.busticketspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    //    @RequestMapping(method = RequestMethod.POST, path = "/authenticate")
    @PostMapping("/authenticate")
    public ResponseEntity<User> authenticate(@RequestBody User loggedUser, HttpSession session) {
        User user = userService.findByUsername(loggedUser.getUsername());
        if (user != null) {
            if (loggedUser.getPassword().equals(user.getPassword())) {
                session.setAttribute("current_user", user);
                return new ResponseEntity<User>(user, HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }



}
