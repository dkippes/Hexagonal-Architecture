package com.example.hexagonal.architecture.example.application.port.persistence;

import com.example.hexagonal.architecture.example.domain.User;

import java.util.List;

public interface ReadUserPort {
    List<User> fetchAll();
    Boolean existsUserByNameAndEmail(User user);
}
