package com.example.hexagonal.architecture.example.adapter.api;

import com.example.hexagonal.architecture.example.adapter.api.mappers.UserDtoMapper;
import com.example.hexagonal.architecture.example.adapter.api.model.SaveUserBodyDto;
import com.example.hexagonal.architecture.example.adapter.api.model.UserDto;
import com.example.hexagonal.architecture.example.application.ports.api.ChangeUserEndpointPort;
import com.example.hexagonal.architecture.example.application.usercases.SubmitNewUserUseCase;
import com.example.hexagonal.architecture.example.domain.User;
import com.example.hexagonal.architecture.example.infrastructure.anotations.Adapter;

@Adapter
public class ChangeUserEndpointAdapter implements ChangeUserEndpointPort {

    private final SubmitNewUserUseCase submitNewUserUseCase;
    private final UserDtoMapper userDtoMapper;

    public ChangeUserEndpointAdapter(SubmitNewUserUseCase submitNewUserUseCase, UserDtoMapper userDtoMapper) {
        this.submitNewUserUseCase = submitNewUserUseCase;
        this.userDtoMapper = userDtoMapper;
    }

    @Override
    public UserDto saveUser(SaveUserBodyDto saveUserBodyDto) {
        User user = userDtoMapper.toDomainFromSaveBody(saveUserBodyDto);
        User savedUser = submitNewUserUseCase.saveUser(user);
        return userDtoMapper.toDto(savedUser);
    }
}
