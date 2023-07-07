package com.example.practice4.FilterIntercepter.controller;

import com.example.practice4.FilterIntercepter.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/user/{id}")
    public String user(@PathVariable String id, @RequestParam(required = false, defaultValue = "태리") String name) {

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
