package com.springproject.springrestfulserviceexample.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "user")
@RestController
public class UserController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user){
        user.setId(1);
        return user;
    }
}
