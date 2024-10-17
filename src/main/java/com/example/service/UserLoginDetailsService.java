package com.example.service;

import com.example.model.UserLoginDetails;

import java.util.List;


public interface UserLoginDetailsService {


    void createNewUser(UserLoginDetails userLoginDetails);

    List<UserLoginDetails> getAllUsers();

    String verify(UserLoginDetails userLoginDetails);
}
