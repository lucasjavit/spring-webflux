package com.lucasjavit.webfluxproject.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
public class UsersDto {

    private String id;
    private String name;
    private LocalDate birthdate;
    private AddressDto shippingAddress;

}
