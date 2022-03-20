package com.example.hexagonal.architecture.example.application.usercase;

import com.example.hexagonal.architecture.example.domain.User;

import java.util.Collection;

public interface SubmitNewUserUseCase {
    User saveUser(User user);
}
