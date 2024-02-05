package com.lucasjavit.webfluxproject.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
public class Users {

    @Id
    private String id;
    private String name;
    private LocalDate birthdate;

}
