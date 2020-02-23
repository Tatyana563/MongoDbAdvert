package com.example.MongoDbBoard.repository;

import com.example.MongoDbBoard.model.Advert;
import com.example.MongoDbBoard.model.Author;
import com.example.MongoDbBoard.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    User findByEmail(String email);

}

