package com.example.demo.domain;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity @NoArgsConstructor
public class Admin extends UserApp{
    public Admin(String username, String password, Role role) {
        super(username, password, role);
    }
}
