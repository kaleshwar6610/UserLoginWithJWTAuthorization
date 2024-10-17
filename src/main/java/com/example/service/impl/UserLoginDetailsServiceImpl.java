package com.example.service.impl;

import com.example.model.UserLoginDetails;
import com.example.repository.UserLoginDetailsRepository;
import com.example.service.JWTService;
import com.example.service.UserLoginDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLoginDetailsServiceImpl implements UserLoginDetailsService {

    @Autowired
    UserLoginDetailsRepository userLoginDetailsRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTService jwtService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Override
    public void createNewUser(UserLoginDetails userLoginDetails) {
        userLoginDetails.setPassword(encoder.encode(userLoginDetails.getPassword()));
        userLoginDetailsRepository.save(userLoginDetails);
    }

    @Override
    public List<UserLoginDetails> getAllUsers() {
        return userLoginDetailsRepository.findAll();
    }

    @Override
    public String verify(UserLoginDetails userLoginDetails) {
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLoginDetails.getUsername(), userLoginDetails.getPassword()));

        if (authentication.isAuthenticated()){
            return jwtService.generateToken(userLoginDetails.getUsername());
        }

        return "login Failure";
    }


}
