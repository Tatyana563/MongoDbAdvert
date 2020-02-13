package com.example.MongoDbBoard.repository;

import com.example.MongoDbBoard.model.Advert;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertRepository extends MongoRepository<Advert, String>, QueryDslPredicateExecutor<Advert> {
    Advert findById(String id);

    List<Advert> findByPriceLessThan(int maxPrice);

    @Query(value = "{author.name:?0}")
    List<Advert> findByAuthor(String name);

}
