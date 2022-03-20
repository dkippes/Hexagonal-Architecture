package com.example.hexagonal.architecture.example.adapter.persistence.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserData {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;
}
