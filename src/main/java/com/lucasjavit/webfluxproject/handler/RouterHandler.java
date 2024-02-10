package com.lucasjavit.webfluxproject.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterHandler {

    @Autowired
    private RequestHandler requestHandler;
    @Bean
    public RouterFunction<ServerResponse> usersEndPoint() {
        return RouterFunctions.route()
                .GET("/all", requestHandler::getAll)
                .POST("/save", requestHandler::save)
                .build();

    }
}
