package com.example.hexagonal.architecture.example.application.port.persistence;

import com.example.hexagonal.architecture.example.domain.User;

import java.util.List;

public interface WriteUserPort {
    User saveNew(User user);
}
