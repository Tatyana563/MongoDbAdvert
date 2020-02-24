package com.example.MongoDbBoard.controller;

import com.example.MongoDbBoard.model.User;
import com.example.MongoDbBoard.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserRestController {
    @Autowired
    UserServiceImpl userService;
// change user's role
    //http://localhost:8095/users/update?id=5e53b784dc2dfb1facc53a4e&role=ADMIN
    @GetMapping("/update")
    public ResponseEntity<User> updateRoleById(
            @RequestParam(value = "id") String id,
            @RequestParam("role") String role
    ) {

        userService.updateUserRole(id, role);
        return ResponseEntity.ok(userService.findById(id));
    }

    //http://localhost:8095/users/delete/e522d1adc2dfb1bacfe2f06 - not ok
    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") String id) {
        userService.deleteById(id);

    }

    //http://localhost:8095/users/find/5e522d1adc2dfb1bacfe2f06 - ok
    @GetMapping("find/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") String id) {
        return ResponseEntity.ok(userService.findById(id));
    }


}
