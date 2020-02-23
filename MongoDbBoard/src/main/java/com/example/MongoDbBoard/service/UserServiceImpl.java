package com.example.MongoDbBoard.service;

import com.example.MongoDbBoard.model.Author;
import com.example.MongoDbBoard.model.User;
import com.example.MongoDbBoard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
@Autowired
    UserRepository userRepository;
    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
