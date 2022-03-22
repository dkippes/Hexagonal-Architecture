package com.example.hexagonal.architecture.example.adapter.api.mappers;

import com.example.hexagonal.architecture.example.adapter.api.model.SaveUserBodyDto;
import com.example.hexagonal.architecture.example.adapter.api.model.UserDto;
import com.example.hexagonal.architecture.example.domain.User;
import com.example.hexagonal.architecture.example.infrastructure.anotations.Mapper;

@Mapper
public class UserDtoMapper {
    public UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    public User toDomainFromSaveBody(SaveUserBodyDto saveUserBodyDto) {
        return User.builder()
                .name(saveUserBodyDto.getName())
                .email(saveUserBodyDto.getEmail())
                .build();
    }
}
