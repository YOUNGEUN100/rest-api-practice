package com.example.practice2.spring_ioc;

import com.example.practice2.spring_ioc.IEncoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class SpringIocApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringIocApplication.class, args);
        ApplicationContext ac = ApplicationContextProvider.getApplicationContext();

        String url = "https://www.naver.com";

        Encoder encoder = ac.getBean("encoderUrl", Encoder.class);
        System.out.println("encoder객체(url): " + encoder);

        Encoder encoder2 = ac.getBean("encoderBase64", Encoder.class);
        System.out.println("encoder객체(base64): " + encoder2);

        String resultStr = encoder.encodeString(url);
        byte[] resultByte = encoder.encodeByte(url);

        System.out.println(resultStr);

        System.out.println("spring-ioc연습 끝");
    }
}

@Configuration
class AppConfig {

    @Bean
    public Encoder encoderBase64(Base64Encoder base64Encoder) {
        return new Encoder(base64Encoder);
    }

    @Bean
    public Encoder encoderUrl(UrlEncoder urlEncoder) {
        return new Encoder(urlEncoder);
    }
}

