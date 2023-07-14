package com.example.practice5.jpa.repository;

import com.example.practice5.jpa.model.Member;
import com.example.practice5.jpa.model.MemberLogHistory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MemberLogHistoryRepositoryTest {
    @Autowired
    private MemberLogHistoryRepository memberLogHistoryRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void selectTest() {
        givenMember();
        givenMember2();

        List<MemberLogHistory> memberLogHistoryList = memberLogHistoryRepository.findAll();
        System.out.println(">>> memberLogHistoryList " + memberLogHistoryList);
    }

    @Test
    void selectRelationTest2() {
//        givenMember();
//        givenMember2();
//
//        memberLogHistoryRepository.findByEmail("abctest1@naver.com").getMember();
    }

    private Member givenMember() {
        Member member = Member.builder()
                .name("권은비")
                .email("gueoneunbi@gmail.com")
                .build();
        return memberRepository.save(member);
    }

    private Member givenMember2() {
        Member member = Member.builder()
                .name("안유진")
                .email("anuzin@gmail.com")
                .build();
        return memberRepository.save(member);
    }



}