package com.example.picpaysimplificado.Controllers;

import com.example.picpaysimplificado.Services.UserService;
import com.example.picpaysimplificado.domain.User;
import com.example.picpaysimplificado.domain.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResponseExtractor;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> postUsers(@RequestBody UserDTO userdto){
       User user = userService.postUser(userdto);
       return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers(){
        var users = userService.ListAllUsers();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

}
