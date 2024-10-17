package com.example.repository;

import com.example.model.UserLoginDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginDetailsRepository extends JpaRepository<UserLoginDetails, Long> {


    UserLoginDetails findByUsernameIgnoreCase(String username);
}
