package com.example.webclient.webClient.controller;

import com.example.webclient.webClient.model.User;
import com.example.webclient.webClient.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webclient-users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id){
        return userService.getUser(id);
    }

    @GetMapping("/")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }
}
