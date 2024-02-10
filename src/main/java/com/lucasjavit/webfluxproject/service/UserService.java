package com.lucasjavit.webfluxproject.service;

import com.lucasjavit.webfluxproject.model.Users;
import com.lucasjavit.webfluxproject.model.UsersDto;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<ResponseEntity<Users>> save(UsersDto user);

    Mono<Users> update(Users user);

    Mono<Void> remove(Users user);

    Flux<ResponseEntity<Users>> findAll();

    Mono<ResponseEntity<Users>> findById(String id);

    Mono<ResponseEntity<Users>> findByName(String name);
}
