package com.example.hexagonal.architecture.example.application.services;

import com.example.hexagonal.architecture.example.application.ports.persistence.ReadUserPort;
import com.example.hexagonal.architecture.example.application.ports.persistence.WriteUserPort;
import com.example.hexagonal.architecture.example.application.usercases.SubmitNewUserUseCase;
import com.example.hexagonal.architecture.example.domain.User;
import org.springframework.stereotype.Service;

@Service
public class SubmitNewUserService implements SubmitNewUserUseCase {
    private final WriteUserPort writeUserPort;
    private final ReadUserPort readUserPort;

    public SubmitNewUserService(WriteUserPort writeUserPort, ReadUserPort readUserPort) {
        this.writeUserPort = writeUserPort;
        this.readUserPort = readUserPort;
    }

    @Override
    public User saveUser(User user) {
        if(readUserPort.existsUserByNameAndEmail(user)) {
            throw new IllegalArgumentException("User duplicated...");
        }
        return writeUserPort.saveNew(user);
    }
}
