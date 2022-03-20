package com.example.hexagonal.architecture.example.adapter.persistence;

import com.example.hexagonal.architecture.example.adapter.persistence.models.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface UserRepository extends JpaRepository<UserData, Integer> {
    Collection<UserData> findByNameAndEmail(String name, String email);
}
