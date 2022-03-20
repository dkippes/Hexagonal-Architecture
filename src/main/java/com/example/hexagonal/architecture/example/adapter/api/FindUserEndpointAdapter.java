package com.example.hexagonal.architecture.example.adapter.api;

import com.example.hexagonal.architecture.example.adapter.api.model.UserDto;
import com.example.hexagonal.architecture.example.application.port.api.FindUserEndpointPort;
import com.example.hexagonal.architecture.example.application.usercase.FindAllUsersUseCase;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
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
