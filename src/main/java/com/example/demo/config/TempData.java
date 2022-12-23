package com.example.demo.config;

import com.example.demo.domain.Role;
import com.example.demo.domain.UserApp;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.transaction.Transactional;

import java.util.List;

import static com.example.demo.enums.RoleEnum.*;

@Configuration @Transactional @AllArgsConstructor
public class TempData {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


    @Bean
    public void creatingSomeRolesAndUsers(){
        // Creating some roles
        Role role1 = new Role(ADMIN);
        Role role2 = new Role(SUPPLIER);
        Role role3 = new Role(CLIENT);

        roleRepository.saveAll(List.of(role1,role2,role3));

        // Creating some roles
        UserApp user1 = new UserApp("coder2002",passwordEncoder.encode("pass123"),role1);
        UserApp user2 = new UserApp("Sara",passwordEncoder.encode("sarasara"),role3);
        UserApp user3 = new UserApp("Sanfour",passwordEncoder.encode("sanfour123"),role2);

        userRepository.saveAll(List.of(user1,user2,user3));

    }
}
