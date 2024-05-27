package com.example.redis.cache.demo.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Address {

    private int id;
    private String name;
    private int customerId;


}
