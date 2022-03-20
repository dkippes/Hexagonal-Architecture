package com.example.hexagonal.architecture.example.adapter.persistence;

import com.example.hexagonal.architecture.example.application.port.persistence.ReadUserPort;
import com.example.hexagonal.architecture.example.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReadUserAdapter implements ReadUserPort {
    private final UserRepository userRepository;

    private final UserJpaMapper userJpaMapper;

    public ReadUserAdapter(UserRepository userRepository, UserJpaMapper userJpaMapper) {
        this.userRepository = userRepository;
        this.userJpaMapper = userJpaMapper;
    }

    @Override
    public List<User> fetchAll() {
        return userRepository.findAll()
                .stream()
                .map(userJpaMapper::toDomain)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Boolean existsUserByNameAndEmail(User user) {
        return !userRepository.findByNameAndEmail(user.getName(), user.getEmail())
                .isEmpty();
    }
}
