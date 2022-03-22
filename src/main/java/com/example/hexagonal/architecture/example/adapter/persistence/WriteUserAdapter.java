package com.example.hexagonal.architecture.example.adapter.persistence;

import com.example.hexagonal.architecture.example.adapter.persistence.mappers.UserJpaMapper;
import com.example.hexagonal.architecture.example.adapter.persistence.models.UserData;
import com.example.hexagonal.architecture.example.adapter.persistence.repositories.UserRepository;
import com.example.hexagonal.architecture.example.application.ports.persistence.WriteUserPort;
import com.example.hexagonal.architecture.example.domain.User;
import org.springframework.stereotype.Component;

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
