package com.lucasjavit.webfluxproject.service.impl;

import com.lucasjavit.webfluxproject.model.Users;
import com.lucasjavit.webfluxproject.repository.UserRepository;
import com.lucasjavit.webfluxproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public Mono<Users> save(Users user) {
        return userRepository.save(user);
    }

    @Override
    public Mono<Users> update(Users user) {
        return userRepository.save(user);
    }

    @Override
    public Mono<Void> remove(Users user) {
        return userRepository.delete(user);
    }

    @Override
    public Flux<ResponseEntity<Users>> findAll() {
        return userRepository.findAll()
                .map(users -> ResponseEntity.ok(users))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @Override
    public Mono<ResponseEntity<Users>> findById(String id) {
        return userRepository.findById(id)
                .map(users -> ResponseEntity.ok(users))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }
}
