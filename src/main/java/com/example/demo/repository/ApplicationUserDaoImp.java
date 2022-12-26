package com.example.demo.repository;

import com.example.demo.domain.UserApp;
import com.example.demo.service.interfaces.ApplicationUserDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("user-repo") @AllArgsConstructor
public class ApplicationUserDaoImp implements ApplicationUserDao {
    private final UserRepository userRepository;

    @Override
    public Optional<UserApp> selectApplicationUserByUsername(String username) {

        return getApplicationUsers()
                .stream()
                .filter(user -> username.equals(user.getUsername()))
                .findFirst();
    }

    private List<UserApp> getApplicationUsers() { return userRepository.findAll() ;}
}
