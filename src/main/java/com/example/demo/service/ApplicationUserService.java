package com.example.demo.service;

import com.example.demo.domain.UserApp;
import com.example.demo.enums.RoleEnum;
import com.example.demo.repository.ApplicationUserDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserService implements UserDetailsService {

    private final ApplicationUserDaoImp applicationUserDao;

    @Autowired
    public ApplicationUserService(@Qualifier("user-repo") ApplicationUserDaoImp applicationUserDao) {
        this.applicationUserDao = applicationUserDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserApp user = applicationUserDao
                .selectApplicationUserByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format("Username %s not found", username))
                );

        RoleEnum userRole =  user.getRole().getName();

        user.setGrantedAuthorities(userRole.getGrantedAuthorities());
        return user;
    }
}
