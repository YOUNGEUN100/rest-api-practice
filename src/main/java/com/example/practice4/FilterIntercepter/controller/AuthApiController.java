package com.example.practice4.FilterIntercepter.controller;

import com.example.practice4.FilterIntercepter.annotations.AuthUser;
import com.example.practice4.FilterIntercepter.dto.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authapi")
@AuthUser
public class AuthApiController {
    @GetMapping("/get")
    public String get() {
        return "authapi/get 호출";
    }
}
