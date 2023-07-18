package com.example.practice5.jpa.service;

import com.example.practice5.jpa.model.Users;
import com.example.practice5.jpa.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsesService {
    private  final UsersRepository usersRepository;

    @Transactional
    public  void put() {
        Users user1 = Users.builder()
                .name("강호동")
                .build();

        usersRepository.save(user1);


    }
}
