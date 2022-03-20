package com.example.hexagonal.architecture.example.adapter.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaveUserBodyDto {
    private String name;
    private String email;
}
