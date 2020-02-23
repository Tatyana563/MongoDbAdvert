//package com.example.MongoDbBoard.controller;
//
//
//import com.example.MongoDbBoard.model.Author;
//import com.example.MongoDbBoard.service.UserServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//
//@Controller
//public class UserController {
//
//
//    @Autowired
//    private UserServiceImpl userService;
//
//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//
//    @RequestMapping(value = "/user/new", method = RequestMethod.POST)
//    public String create(
//            @RequestParam("name") String name,
//            @RequestParam("password") String password,
//            @RequestParam("phone") String phone,
//            @RequestParam("email") String email,
//            @RequestParam("city") String city
//
//    ) {
//        final Author userEntity = new Author();
//        userEntity.setName(name);
//        userEntity.setEmail(email);
//        userEntity.setPhone(phone);
//        userEntity.setPassword(passwordEncoder.encode(password));
//        userEntity.setCity(city);
//        userService.save(userEntity);
//        return "/login";
//    }
//
//    @GetMapping("/login")
//    public String newPageLogin(final Model model) {
//        return "login";
//
//    }
//
//    @GetMapping("/registration")
//    public String newPageRegistration(final Model model) {
//        return "registration";
//
//    }
//}
//
//
//
