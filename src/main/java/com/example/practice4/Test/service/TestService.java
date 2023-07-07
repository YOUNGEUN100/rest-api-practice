package com.example.practice4.Test.service;

import com.example.practice4.Test.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TestService {

    public List<String> getAllStringVal() {
        return Arrays.asList("abc","xyz");
    }

    public List<Member> getAllMembers() {
        Member member = new Member();
        member.setId(1L);
        member.setName("홍길동");

        List<Member> memberList = Arrays.asList(member);
        return memberList;
    }
}
