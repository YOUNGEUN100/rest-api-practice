package com.example.practice2.spring_ioc_practice;

public interface IEncoder {
    String encoderString(String message);
    byte[] encodeByte(String message);
}
