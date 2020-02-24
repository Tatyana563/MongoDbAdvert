package com.example.MongoDbBoard.service;

import com.example.MongoDbBoard.model.Role;
import com.example.MongoDbBoard.model.User;
import com.example.MongoDbBoard.repository.RoleRepository;
import com.example.MongoDbBoard.repository.UserRepository;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.TreeSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    RoleRepository roleRepository;


    @Override
    public void deleteById(String empId) {
        userRepository.delete(empId);
    }

    public User findById(String id) {
        if (Strings.isNullOrEmpty(id)) throw new IllegalArgumentException("id must be set");
        return userRepository.findById(id);
    }

    public void updateUserRole(String id, String role) {

        User user = mongoTemplate.findOne(
                Query.query(Criteria.where("id").is(id)), User.class);
        Set<Role> roles = new TreeSet<>();
        roles.add(roleRepository.findByRole(role));
        user.setRoles(roles);
        mongoTemplate.save(user, "user");
    }

    public Set<Role> findUserRole(String id) {

        User user = mongoTemplate.findOne(
                Query.query(Criteria.where("id").is(id)), User.class);
        Set<Role> roles = user.getRoles();
        return roles;
    }
}
