package com.example.practice2.ioc;

import java.util.Base64.Encoder;
import java.util.Base64;

public class Base64Encoder implements IEncoder{

    @Override
    public String encodeString(String message) {
        // Base64 인코딩 ///////////////////////////////////////////////////
        return Base64.getEncoder().encodeToString(message.getBytes());
    }

    public byte[] encodeByte(String message) {
        // Base64 인코딩 ///////////////////////////////////////////////////
        Encoder encoder = Base64.getEncoder();
        byte[] encodedBytes = encoder.encode(message.getBytes());

        return encodedBytes;
    }
}