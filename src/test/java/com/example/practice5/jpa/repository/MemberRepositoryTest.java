package com.example.practice5.jpa.repository;

import com.example.practice5.jpa.model.Member;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;
    @Test
    void crud() {
        // select all 문
        System.out.println("select all -----------------------------------------------------");
        List<Member> memberList = memberRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        memberList.forEach(System.out::println);

        // select where 문
        System.out.println("select where-----------------------------------------------------");
        List<Member> memberList2 = memberRepository.findAllById(Lists.newArrayList(1L,3L));
        memberList2.forEach(System.out::println);

        // update 문
        System.out.println("update -----------------------------------------------------");
        Member member1 = new Member(1L,"홍길동","이메일 주소", LocalDateTime.now(),LocalDateTime.now());
        memberRepository.save(member1);
        // 1번을 가진 id 가 있다면 update, 없다면 create문 발생
        List<Member> memberList3 = memberRepository.findAll();
        memberList3.forEach(System.out::println);

        // delete 문
        System.out.println("delete -----------------------------------------------------");
//        memberRepository.deleteAll();
        memberRepository.deleteAllInBatch();

        List<Member> memberList4 = memberRepository.findAll();
        memberList4.forEach(System.out::println);
    }
}