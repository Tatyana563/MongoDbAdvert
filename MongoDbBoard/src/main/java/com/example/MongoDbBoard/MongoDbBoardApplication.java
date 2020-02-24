package com.example.MongoDbBoard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication
public class MongoDbBoardApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MongoDbBoardApplication.class, args);
    }

}
