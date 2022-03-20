package com.example.hexagonal.architecture.example.adapter.api.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDto {
    private final String name;
    private final String email;
}
