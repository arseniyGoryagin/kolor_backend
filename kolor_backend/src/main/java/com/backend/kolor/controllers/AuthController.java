package com.backend.kolor.controllers;


import com.backend.kolor.dtos.LoginDto;
import com.backend.kolor.entities.User;
import com.backend.kolor.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller("/auth")
public class AuthController {



    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }


    // TODO add email validation
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User newUser){
        try {
            userService.registerUser(newUser);
            return ResponseEntity.status(HttpStatus.CREATED).body("Registration successe");
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username or email already registered");
        }
    }


    @PostMapping("/login")
    public void loginUser(@RequestBody LoginDto login){




    }



}
