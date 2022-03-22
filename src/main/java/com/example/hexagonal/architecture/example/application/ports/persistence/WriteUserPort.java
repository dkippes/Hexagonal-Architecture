package com.example.hexagonal.architecture.example.application.ports.persistence;

import com.example.hexagonal.architecture.example.domain.User;

public interface WriteUserPort {
    User saveNew(User user);
}
