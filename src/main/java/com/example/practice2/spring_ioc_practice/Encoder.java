package com.example.practice2.spring_ioc_practice;

public class Encoder implements IEncoder{

    private IEncoder iEncoder;

    public Encoder(IEncoder iEncoder) {
        this.iEncoder = iEncoder;
    }

    @Override
    public String encoderString(String message) {
        return iEncoder.encoderString(message);
    }

    @Override
    public byte[] encodeByte(String message) {
        return iEncoder.encodeByte(message);
    }
}
