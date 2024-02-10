package com.lucasjavit.webfluxproject.service.impl;

import com.lucasjavit.webfluxproject.model.Users;
import com.lucasjavit.webfluxproject.model.UsersDto;
import com.lucasjavit.webfluxproject.repository.UserRepository;
import com.lucasjavit.webfluxproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private ModelMapper modelMapper = new ModelMapper();


    @Override
    public Mono<ResponseEntity<Users>> save(UsersDto usersDto) {
        Users users = modelMapper.map(usersDto, Users.class);

        return userRepository.save(users)
                .map(ResponseEntity::ok)
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
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
                .map(ResponseEntity::ok)
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @Override
    public Mono<ResponseEntity<Users>> findById(String id) {
        return userRepository.findById(id)
                .map(ResponseEntity::ok)
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @Override
    public Mono<ResponseEntity<Users>> findByName(String name) {
        return userRepository.findByName(name)
                .map(ResponseEntity::ok)
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }
}
