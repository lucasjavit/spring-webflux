package com.lucasjavit.webfluxproject.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Address {

    @Id
    private String id;
    private String addressLine;
    private String postalCode;
    private String city;

}
