package com.example.hexagonal.architecture.example.application.usercases;

import com.example.hexagonal.architecture.example.domain.User;

public interface SubmitNewUserUseCase {
    User saveUser(User user);
}
