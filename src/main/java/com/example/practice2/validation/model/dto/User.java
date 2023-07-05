package com.example.practice2.validation.model.dto;


import com.example.practice2.validation.annotation.YearMonth;
// 2.0 validation
import javax.validation.constraints.*;

public class User {
    @NotEmpty(message = "이름 필수 작성")
    private String name;

    @Max(value=200, message = "나이는 200 초과를 입력할 수 없음")
    @Min(value = 1, message = "나이는 1 미만을 입력할 수 없음")
    private int age;

    @Email
    private String email;

    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "폰 번호 오류")
    private String ph;

    @AssertFalse(message = "이메일의 끝 문자열은 .com 으로 끝나야 함")
    public boolean isTestSuccess() {
        // 별도의 로직
        if(email.endsWith(".com"))
            return false;

        return true;
    }

    // 생년월일
    // default 형식이 'YYYYMM' -> 199912
    // @Size(min=8, max=8)
    @YearMonth
    private String birth;


    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phoneNumber='" + ph + '\'' +
                '}';
    }
}
