package com.example.practice2.validation.controller;

import com.example.practice2.validation.model.dto.User;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api")
@Validated
public class ApiController {

    // 모든 사용자 정보를 조회하는 API
    @GetMapping("/userAll")
    public String user() {
        return "";
    }

    // 특정 사용자 정보를 조회하는 API(/api/user/?name=홍길동&age=30)
    @GetMapping("/user")
    public String user(@Size(min=2) @RequestParam String name, @RequestParam int age) {
        return "이름 : " + name + ", 나이 : " + age;
    }



    // 사용자 정보를 등록하는 api
    @PostMapping("/user")
    public ResponseEntity user(@Valid @RequestBody User user, BindingResult bindingResult) {
        System.out.println(user);

        if(bindingResult.hasErrors()) {
            System.out.println("에러 발생");

            List<ObjectError> listObjectError = bindingResult.getAllErrors();
            for (ObjectError objectError : listObjectError) {
                FieldError fieldError = (FieldError) objectError;
                System.out.println("field : " + fieldError.getField());
                System.out.println("message : " + fieldError.getDefaultMessage());

                if (fieldError.getField().equals("name")) {
                    // 이름이 긴 경우 뒤에 텍스트를 cut 해서 줄임...
                }
            }
        }

        return ResponseEntity.ok(user);
    }
}