package com.example.demo.domain;

import com.example.demo.enums.RoleEnum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;


@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private short id;
    @Enumerated(EnumType.STRING)
    private RoleEnum name;
}
