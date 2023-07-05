package com.example.practice2.spring_ioc;

public interface IEncoder {
    String encodeString(String message);

    byte[] encodeByte(String message);
}
