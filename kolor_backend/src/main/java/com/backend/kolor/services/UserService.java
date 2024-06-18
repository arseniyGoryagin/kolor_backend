package com.backend.kolor.services;


import com.backend.kolor.entities.User;
import com.backend.kolor.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service()
public class UserService {


    private final UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User registerUser(User newUser) throws IllegalArgumentException {
        Optional<User> user =  userRepository.findUserByEmail(newUser.getEmail());

        if(user.isPresent()){
            throw new IllegalArgumentException("User email already registred");
        }

        user = userRepository.findUserByUsername(newUser.getUsername());

        if(user.isPresent()){
            throw new IllegalArgumentException("Username already registred");
        }

        return userRepository.save(newUser);
    }


    public List<User> getUsersByScore(int page, int perPage){
        return userRepository.findAll();
    }


}
