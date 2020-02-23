package com.example.MongoDbBoard.repository;

import com.example.MongoDbBoard.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {
    Role findByRole(String role);
}
