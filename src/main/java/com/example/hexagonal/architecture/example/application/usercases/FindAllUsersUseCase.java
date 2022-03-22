package com.example.hexagonal.architecture.example.application.usercases;

import com.example.hexagonal.architecture.example.domain.User;

import java.util.Collection;

public interface FindAllUsersUseCase {
    Collection<User> fetchAllPersisted();
}
