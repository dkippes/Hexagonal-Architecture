package com.example.hexagonal.architecture.example.adapter.api;

import com.example.hexagonal.architecture.example.adapter.api.mappers.UserDtoMapper;
import com.example.hexagonal.architecture.example.adapter.api.model.UserDto;
import com.example.hexagonal.architecture.example.application.ports.api.FindUserEndpointPort;
import com.example.hexagonal.architecture.example.application.usercases.FindAllUsersUseCase;
import com.example.hexagonal.architecture.example.infrastructure.anotations.Adapter;

import java.util.Collection;
import java.util.stream.Collectors;

@Adapter
public class FindUserEndpointAdapter implements FindUserEndpointPort {
    private final UserDtoMapper userDtoMapper;
    private final FindAllUsersUseCase findAllUsersUseCase;

    public FindUserEndpointAdapter(FindAllUsersUseCase findAllUsersUseCase, UserDtoMapper userDtoMapper) {
        this.findAllUsersUseCase = findAllUsersUseCase;
        this.userDtoMapper = userDtoMapper;
    }

    @Override
    public Collection<UserDto> fetchAllUsers() {
        return findAllUsersUseCase.fetchAllPersisted()
                .stream()
                .map(userDtoMapper::toDto)
                .collect(Collectors.toUnmodifiableList());
    }
}
