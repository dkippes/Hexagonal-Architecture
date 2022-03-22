package com.example.hexagonal.architecture.example.adapter.persistence.mappers;

import com.example.hexagonal.architecture.example.adapter.persistence.models.UserData;
import com.example.hexagonal.architecture.example.domain.User;
import com.example.hexagonal.architecture.example.infrastructure.anotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
public class UserJpaMapper {
    public User toDomain(UserData userData) {
        return User.builder()
                .id(userData.getId())
                .name(userData.getName())
                .email(userData.getEmail())
                .build();
    }

    public UserData toJpaEntity(User user) {
        return UserData.builder()
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
