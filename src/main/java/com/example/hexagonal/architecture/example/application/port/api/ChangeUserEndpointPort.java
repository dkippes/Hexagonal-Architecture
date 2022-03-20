package com.example.hexagonal.architecture.example.application.port.api;

import com.example.hexagonal.architecture.example.adapter.api.model.SaveUserBodyDto;
import com.example.hexagonal.architecture.example.adapter.api.model.UserDto;
import org.springframework.stereotype.Component;

import java.util.Collection;

public interface ChangeUserEndpointPort {
    UserDto saveUser(SaveUserBodyDto saveUserBodyDto);
}
