//package com.example.MongoDbBoard.service;
//
//
//
//import com.example.MongoDbBoard.model.Author;
//import com.example.MongoDbBoard.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.util.CollectionUtils;
//
//import java.util.ArrayList;
//import java.util.List;
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//    @Autowired
//    private UserRepository userRepository;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//       Author user = userRepository.findByName(username);
//        if(user==null){
//            throw new UsernameNotFoundException("User" + username +"not found");
//        }
//        List<String> roles = userRepository.findRolesById(user.getId());
//        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//        if (!CollectionUtils.isEmpty(roles)) {
//            for (String role : roles) {
//                grantedAuthorities.add(new SimpleGrantedAuthority(role));
//            }
//        }
//        return new User(user.getName(), user.getPassword(), grantedAuthorities);
//    }
//}
//
//
