package com.example.MongoDbBoard.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Setter
@Getter
@Document(collection = "Advert")
public class Advert {
    @Id
    private String id;
    private String title;
    private double price;
    private String description;
    private Author author;

    public Advert(String title, double price, String description, Author author) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.author = author;
    }
}
