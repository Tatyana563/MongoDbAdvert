package com.example.MongoDbBoard.service;

import com.example.MongoDbBoard.model.Author;
import com.example.MongoDbBoard.model.User;

public interface UserService {
    public void save(User user);

    void deleteById(String empId);
}
