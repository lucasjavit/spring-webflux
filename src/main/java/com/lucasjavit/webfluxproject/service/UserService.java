package com.lucasjavit.webfluxproject.service;

import com.lucasjavit.webfluxproject.model.Users;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<Users> save(Users user);

    Mono<Users> update(Users user);

    Mono<Void> remove(Users user);

    Flux<ResponseEntity<Users>> findAll();

    Mono<ResponseEntity<Users>> findById(String id);

    Mono<ResponseEntity<Users>> findByName(String name);
}
