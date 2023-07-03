package com.example.practice;

import org.springframework.web.bind.annotation.*;

@RestController
public class MvcController1 {

    // @RequestMapping("/test")
    @GetMapping("/test1")
    public String test() {
        return "test3333";
    }

    @PostMapping(value = "/post-test1")
    public String postTest() {
        return """
                {
                    "name": "홍길동",
                    "birth": "1990-05-05"
                }
               """;
    }

    @PutMapping("/put-test1")
    public String putTest() {
        return "put은 업데이트 htttp 메소드 입니다";
    }

    @DeleteMapping("/delete-test1")
    public String deleteTest() {
        return "delete 테스트입니다";
    }
}
