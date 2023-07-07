package com.example.practice4.Test.controller;

import com.example.practice4.Test.model.Member;
import com.example.practice4.Test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TestController {
    @Autowired
    TestService testService;

    @GetMapping("/test1")
    public List<String> getAllStringsVal() {
        return testService.getAllStringVal();
    }

    @GetMapping("/test2")
    public List<Member> getAllMembers() {
        return testService.getAllMembers();
    }

}
