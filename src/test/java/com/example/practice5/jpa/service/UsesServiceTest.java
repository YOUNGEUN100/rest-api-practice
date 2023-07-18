package com.example.practice5.jpa.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UsesServiceTest {

    @Autowired
    private UsesService usesService;

    @Test
    void transactionalTest() {
        usesService.put();
    }
}