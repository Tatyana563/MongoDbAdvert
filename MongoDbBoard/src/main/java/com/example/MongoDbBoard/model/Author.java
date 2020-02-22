package com.example.MongoDbBoard.model;

import org.springframework.data.annotation.Id;

public class Author {
    @Id
    private String id;
    private String name;
    private String phone;
    private String email;
    private String city;
    private String role;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public Author() {
    }
}
