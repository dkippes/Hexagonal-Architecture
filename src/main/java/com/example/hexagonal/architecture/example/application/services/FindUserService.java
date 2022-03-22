package com.example.hexagonal.architecture.example.application.services;

import com.example.hexagonal.architecture.example.application.ports.persistence.ReadUserPort;
import com.example.hexagonal.architecture.example.application.usercases.FindAllUsersUseCase;
import com.example.hexagonal.architecture.example.domain.User;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FindUserService implements FindAllUsersUseCase {

    private final ReadUserPort readUserPort;

    FindUserService(ReadUserPort readUserPort) {
        this.readUserPort = readUserPort;
    }

    @Override
    public Collection<User> fetchAllPersisted() {
        return readUserPort.fetchAll();
    }
}
