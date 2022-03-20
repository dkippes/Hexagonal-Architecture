package com.example.hexagonal.architecture.example.adapter.api;

import com.example.hexagonal.architecture.example.adapter.api.model.SaveUserBodyDto;
import com.example.hexagonal.architecture.example.adapter.api.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/users")
public class UserController {

    private final FindUserEndpointAdapter findUserEndpointAdapter;
    private final ChangeUserEndpointAdapter changeUserEndpointAdapter;

    public UserController(FindUserEndpointAdapter findUserEndpointAdapter, ChangeUserEndpointAdapter changeUserEndpointAdapter) {
        this.findUserEndpointAdapter = findUserEndpointAdapter;
        this.changeUserEndpointAdapter = changeUserEndpointAdapter;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto saveUser(@RequestBody @Valid SaveUserBodyDto saveUserBodyDto) {
        return changeUserEndpointAdapter.saveUser(saveUserBodyDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Collection<UserDto> getUsers() {
        return findUserEndpointAdapter.fetchAllUsers();
    }

}
