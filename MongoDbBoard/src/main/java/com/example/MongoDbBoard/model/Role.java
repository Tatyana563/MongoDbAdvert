package com.example.MongoDbBoard.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Document(collection = "role")
public class Role implements Comparable {

    @Id
    private String id;
    private String role;

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}