package com.example.demo.domain;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity @NoArgsConstructor
public class Client extends UserApp{
    public Client(String username, String password, Role role) {
        super(username, password, role);
    }
}
