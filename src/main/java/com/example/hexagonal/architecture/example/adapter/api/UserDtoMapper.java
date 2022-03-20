package com.example.hexagonal.architecture.example.adapter.api;

import com.example.hexagonal.architecture.example.adapter.api.model.SaveUserBodyDto;
import com.example.hexagonal.architecture.example.adapter.api.model.UserDto;
import com.example.hexagonal.architecture.example.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper {
    UserDto toDto(User user) {
        return UserDto.builder()
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    User toDomainFromSaveBody(SaveUserBodyDto saveUserBodyDto) {
        return User.builder()
                .name(saveUserBodyDto.getName())
                .email(saveUserBodyDto.getEmail())
                .build();
    }
}
