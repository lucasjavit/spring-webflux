package com.lucasjavit.webfluxproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class WebFluxProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebFluxProjectApplication.class, args);
    }

}
