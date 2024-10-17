package com.example.controller;

import com.example.model.UserLoginDetails;
import com.example.service.UserLoginDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserLoginDetailsController {

    @Autowired
    private UserLoginDetailsService userLoginDetailsService;

    @PostMapping("/user")
    public String createNewUser(@RequestBody UserLoginDetails userLoginDetails){
        userLoginDetailsService.createNewUser(userLoginDetails);
        return "user "+userLoginDetails.getUsername()+" is created";
    }

    @GetMapping("/user")
    public List<UserLoginDetails> getAllUsers(){
        return userLoginDetailsService.getAllUsers();
    }

    @PostMapping("/login")
    private String loginUser(@RequestBody UserLoginDetails userLoginDetails){
        return userLoginDetailsService.verify(userLoginDetails);
    }
}
