package com.example.hexagonal.architecture.example.application.ports.api;

import com.example.hexagonal.architecture.example.adapter.api.model.UserDto;

import java.util.Collection;

public interface FindUserEndpointPort {
    Collection<UserDto> fetchAllUsers();
}
