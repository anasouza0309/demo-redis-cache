package com.example.redis.cache.demo.model;

import lombok.*;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@Builder
@AllArgsConstructor
public class Customer implements Serializable {

    private int id;
    private String name;


}
