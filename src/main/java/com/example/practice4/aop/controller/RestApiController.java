package com.example.practice4.aop.controller;

import com.example.practice4.aop.annotation.Log;
import com.example.practice4.aop.annotation.TimeChecker;
import com.example.practice4.aop.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {
    @TimeChecker
    @GetMapping("/user/{id}")
    public String user(@PathVariable String id, @RequestParam String name) {

        System.out.println("id: " + id);
        System.out.println("name: " + name);

        return id + " " + name;
    }

    @PostMapping("/user")
    public User user(User user) {
        System.out.println("id: " + user.getId());
        System.out.println("name: " + user.getName());
        return user;
    }

    @PutMapping("/user")
    public User Updateuser(User user) {
        System.out.println(user);
        return user;
    }

}
