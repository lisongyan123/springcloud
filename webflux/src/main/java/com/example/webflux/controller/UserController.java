package com.example.webflux.controller;

import com.example.webflux.controller.domain.User;
import com.example.webflux.controller.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public Flux<User> list() {
        return this.userService.list();
    }

    @GetMapping("/{id}")
    public Mono<User> getById(@PathVariable("id") final String id) {
        return this.userService.getById(id);
    }

    @PostMapping("")
    public Mono<User> create(@RequestBody final User user) {
        return this.userService.createOrUpdate(user);
    }

    @PutMapping("/{id}")
    public Mono<User> update(@PathVariable("id") final String id, @RequestBody final User user) {
        Objects.requireNonNull(user);
        user.setId(id);
        return this.userService.createOrUpdate(user);
    }

    @DeleteMapping("/{id}")
    public Mono<User> delete(@PathVariable("id") final String id) {
        return this.userService.delete(id);
    }
}