package com.example.demo.domain;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity @NoArgsConstructor
public class Supplier extends UserApp{
    public Supplier(String username, String password, Role role) {
        super(username, password, role);
    }
}
