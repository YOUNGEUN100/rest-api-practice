package com.example.practice2.ioc;

public interface IEncoder {
    String encodeString(String message);

    byte[] encodeByte(String message);
}
