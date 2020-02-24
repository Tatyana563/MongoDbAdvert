package com.example.MongoDbBoard.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@Setter
@Getter
public class Author {
    @Id
    private String id;
    private String name;
    private String phone;
    private String email;
    private String city;
    private String role;
    private String password;

    public Author(String name, String phone, String email, String city) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.city = city;
    }

    public Author(String name, String phone, String email, String city, String role, String password) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.city = city;
        this.role = role;
        this.password = password;
    }
}
