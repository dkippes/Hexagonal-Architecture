package com.example.hexagonal.architecture.example.application.ports.api;

import com.example.hexagonal.architecture.example.adapter.api.model.SaveUserBodyDto;
import com.example.hexagonal.architecture.example.adapter.api.model.UserDto;

public interface ChangeUserEndpointPort {
    UserDto saveUser(SaveUserBodyDto saveUserBodyDto);
}
