package com.example.MongoDbBoard.repository;

        import com.example.MongoDbBoard.model.User;
        import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findByEmail(String email);

    User findById(String id);

}

