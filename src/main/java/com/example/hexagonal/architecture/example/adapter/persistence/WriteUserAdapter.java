package com.example.hexagonal.architecture.example.adapter.persistence;

import com.example.hexagonal.architecture.example.adapter.persistence.models.UserData;
import com.example.hexagonal.architecture.example.application.port.persistence.ReadUserPort;
import com.example.hexagonal.architecture.example.application.port.persistence.WriteUserPort;
import com.example.hexagonal.architecture.example.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WriteUserAdapter implements WriteUserPort {
    private final UserRepository userRepository;

    private final UserJpaMapper userJpaMapper;

    public WriteUserAdapter(UserRepository userRepository, UserJpaMapper userJpaMapper) {
        this.userRepository = userRepository;
        this.userJpaMapper = userJpaMapper;
    }

    @Override
    public User saveNew(User user) {
        UserData userData = userJpaMapper.toJpaEntity(user);
        UserData userSaved = userRepository.save(userData);
        return userJpaMapper.toDomain(userSaved);
    }
}
