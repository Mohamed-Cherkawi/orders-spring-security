package com.example.demo.service.interfaces;

import com.example.demo.domain.UserApp;

import java.util.Optional;

public interface ApplicationUserDao {
    Optional<UserApp> selectApplicationUserByUsername(String username);

}
