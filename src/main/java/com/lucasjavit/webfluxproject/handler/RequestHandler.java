package com.lucasjavit.webfluxproject.handler;


import com.lucasjavit.webfluxproject.model.Users;
import com.lucasjavit.webfluxproject.model.UsersDto;
import com.lucasjavit.webfluxproject.service.UserService;
import lombok.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Value
@Component
public class RequestHandler {

    private UserService userService;

    Mono<ServerResponse> save(ServerRequest request) {
        Mono<UsersDto> body = request.bodyToMono(UsersDto.class);
        Mono<ResponseEntity<Users>> result = body.flatMap(it -> userService.save(it));

        return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM)
                .body(result, Users.class);
    }

    Mono<ServerResponse> getAll(ServerRequest request) {
        Flux<ResponseEntity<Users>> result = userService.findAll();

        return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM)
                .body(result, Users.class);
    }
}
