package com.example.springredis.model;

import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class UserDto {
    private String id;
    private String name;
    private int age;

    @Builder
    public UserDto(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}