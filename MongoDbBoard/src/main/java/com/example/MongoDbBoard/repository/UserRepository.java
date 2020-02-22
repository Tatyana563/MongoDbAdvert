package com.example.MongoDbBoard.repository;

import com.example.MongoDbBoard.model.Advert;
import com.example.MongoDbBoard.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.util.List;

public interface UserRepository  extends MongoRepository<Author, String>/*, QueryDslPredicateExecutor<Author> */{

    Author findByName(String name);

  //  @Query(value = "{author.role:?0,}")
 List<String> findRolesById(String id);
}
