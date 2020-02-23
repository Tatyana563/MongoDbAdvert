package com.example.MongoDbBoard.controller;

import com.example.MongoDbBoard.model.Role;
import com.example.MongoDbBoard.model.User;
import com.example.MongoDbBoard.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.TreeSet;

@RestController
@RequestMapping("/users")
public class UserRestController {
    @Autowired
    UserServiceImpl userService;
    //http://localhost:8095/users/update?id=5e52c60fdc2dfb1110048131&role=ADMIN
    @GetMapping("/update")
    public ResponseEntity<User> updateRoleById(
            @RequestParam(value = "id") String id,
            @RequestParam("role") String role
    ){
//       final User user = new User();
//     Set<Role> roles= new TreeSet<>();
//        user.setRoles(roles);
        userService.updateUserRole(id, role);
        return ResponseEntity.ok(userService.findById(id));
    }

    //http://localhost:8095/users/delete/e522d1adc2dfb1bacfe2f06 - not ok
        @GetMapping ("/delete/{id}")
        public void deleteById(@PathVariable("id") String id) {
           userService.deleteById(id);

        }

//http://localhost:8095/users/find/5e522d1adc2dfb1bacfe2f06 - ok
    @GetMapping("find/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") String id) {
        return ResponseEntity.ok(userService.findById(id));
    }


}
