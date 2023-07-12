package com.example.practice5.jpa.model.enums;

public enum Nation {
    KOREA(10),
    JAPAN(20),
    CHINA(30),
    ENGLAND(40),
    기타(50);

    private final int value;

    Nation(int value) {
        this.value = value;
    }

}
