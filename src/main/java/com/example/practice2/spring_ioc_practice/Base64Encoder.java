package com.example.practice2.spring_ioc_practice;


import com.example.practice2.spring_ioc_practice.IEncoder;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Base64.Encoder;
@Component
public class Base64Encoder implements IEncoder {

    @Override
    public String encoderString(String message) {
        return Base64.getEncoder().encodeToString(message.getBytes());
    }

    @Override
    public byte[] encodeByte(String message) {
        Encoder encoder = Base64.getEncoder();
        byte[] encodedBytes = encoder.encode(message.getBytes());

        return encodedBytes;
    }
}