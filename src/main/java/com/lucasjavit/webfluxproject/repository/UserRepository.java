package com.lucasjavit.webfluxproject.repository;

import com.lucasjavit.webfluxproject.model.Users;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveCrudRepository<Users, String> {

    Mono<Users> findByName(String name);
}
