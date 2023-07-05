package com.example.practice2.spring_ioc_practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringIocPracticeApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringIocPracticeApplication.class, args);
        ApplicationContext ac = ApplicationContextProvider.getApplicationContext();
        
        String url = "http://www.naver.com";
        
        Encoder encoder = ac.getBean("", Encoder.class);
        System.out.println(encoder);

        System.out.println("spring-ioc 연습 끝");

    }
}
