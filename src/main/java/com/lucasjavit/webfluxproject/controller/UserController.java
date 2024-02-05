package com.lucasjavit.webfluxproject.controller;

import com.lucasjavit.webfluxproject.model.Users;
import com.lucasjavit.webfluxproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public Mono<Users> save(@RequestBody Users user) {
        return userService.save(user);
    }

    @PatchMapping
    public Mono<Users> update(@RequestBody Users user) {
        return userService.save(user);
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Users>> findById(@PathVariable("id") String id){
        return userService.findById(id);
    }

    @GetMapping()
    public Flux<ResponseEntity<Users>> findAll(){
        return userService.findAll();
    }
}
