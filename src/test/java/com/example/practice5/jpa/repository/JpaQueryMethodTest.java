package com.example.practice5.jpa.repository;


import com.example.practice5.jpa.model.Member;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@SpringBootTest
public class JpaQueryMethodTest {
    @Autowired
    private  MemberRepository memberRepository;

    @Test
    void jpaQueryMethodTest1() {
        // SELECT문: email 값으로 특정 row 데이터 가져오기
        Set<Member> memberLeesunsin = memberRepository.readByEmail("leesunsin@gmail.com");
        memberLeesunsin.forEach(System.out::println);
//        System.out.println(memberLeesunsin);

        // SELECT문: name값으로 특정 row데이터 가져오기
//        List<Member> memberHongildongList = memberRepository.findByName("홍길동");
//        memberHongildongList.forEach(System.out::println);


//        System.out.println("findByName: " + memberRepository.findByName("이순신"));
//        System.out.println("readByName: " + memberRepository.readByName("이순신"));
//        System.out.println("searchByName: " + memberRepository.searchByName("이순신"));
//        System.out.println("queryByName: " + memberRepository.queryByName("이순신"));
//        System.out.println("getByName: " + memberRepository.getByName("이순신"));
//        System.out.println("streamByName: " + memberRepository.streamByName("이순신"));


//        Optional<Member> memberOpt1 = memberRepository.findByCreateAt(LocalDateTime.MAX);
//        System.out.println(memberOpt1);
//

    }

//    @Test
//    void jpaQueryMethodTest2() {
//        boolean isNameMember = memberRepository.existsByName("이순신");
//        if (isNameMember)
//            System.out.println("회원 이름이 존재합니다.");
//
//        boolean isEmailMember = memberRepository.existsByEmail("leesunsin@gmail.com");
//        if (isEmailMember)
//            System.out.println("회원 이메일이 존재합니다.");
//
//        Integer cntNameMember = memberRepository.countByName("홍길동");
//        System.out.println("cntNameMember: " + cntNameMember);
//
//        // topNumber, firstNumber, lastNumber
//        memberRepository.findTop1ByEmail("namsun@thejoeun.com").forEach(System.out::println);
//        memberRepository.findFirst1ByEmail("namsun@thejoeun.com").forEach(System.out::println);
//        memberRepository.findTop2ByEmail("namsun@thejoeun.com").forEach(System.out::println);
//
//        memberRepository.findDistinctByEmail("namsun@thejoeun.com").forEach(System.out::println);
//    }

//    @Test
//    void jpaQueryMethodTest3() {
//        List<Member> memberList = memberRepository.findByNameAndEmail("홍길동","mars@thejoeun.com");
//        memberList.forEach(System.out::println);
//
//        List<Member> memberList2 = memberRepository.findByNameOrEmail("홍길동","mars@thejoeun.com");
//        memberList2.forEach(System.out::println);
//
//        List<Member> memberList3 = memberRepository.findByCreateAtAfter(LocalDateTime.now().minusDays(1L));
//        memberList3.forEach(s -> System.out.println(s));
//    }

//    @Test
//    void jpaQueryMethodTest4() {
//        System.out.println("1. CreateAt + After----------------------------");
//        // CreateAt + After
//        List<Member> memberList1 = memberRepository.findByCreateAtAfter(LocalDateTime.now().minusDays(1L));
//        memberList1.forEach(s -> System.out.println(s));
//
//        System.out.println("2. CreateAt + IsAfter----------------------------");
//        // CreateAt + IsAfter
//        List<Member> memberList2 = memberRepository.findByCreateAtIsAfter(LocalDateTime.now().minusDays(1L));
//        memberList2.forEach(s -> System.out.println(s));
//
//        System.out.println("3. CreateAt + GreaterThan----------------------------");
//        // CreateAt + GreaterThan
//        List<Member> memberList3 = memberRepository.findByCreateAtGreaterThan(LocalDateTime.now().minusDays(1L));
//        memberList3.forEach(s -> System.out.println(s));
//
//        System.out.println("4. CreateAt + GreaterThanEqual----------------------------");
//        // CreateAt + GreaterThanEqual
//        List<Member> memberList4 = memberRepository.findByCreateAtGreaterThanEqual(LocalDateTime.now().minusDays(1L));
//        memberList4.forEach(s -> System.out.println(s));
//
//        System.out.println("5. GreaterThanEqual----------------------------");
//        // GreaterThanEqual
//        List<Member> memberList5 = memberRepository.findByIdGreaterThanEqual(3L);
//        memberList5.forEach(s -> System.out.println(s));
//
//        System.out.println("6. CreateAt + Between----------------------------");
//        // CreateAt + Between
//        List<Member> memberList6 = memberRepository.findByCreateAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(1L));
//        memberList6.forEach(s -> System.out.println(s));
//    }

//    @Test
//    void jpaQueryMethodTest5() {
//        List<Member> memberList7 = memberRepository.findByNameLike("%홍%");
//        memberList7.forEach(s -> System.out.println(s));
//
//        List<Member> memberList8 = memberRepository.findByNameIn(Lists.newArrayList("홍길동", "강감찬"));
//        memberList8.forEach(s -> System.out.println(s));
//
//        System.out.println("contains----------------");
//        List<Member> memberList1 = memberRepository.findByNameContains("이");
//        memberList1.forEach(s -> System.out.println(s));
//
//        System.out.println("startingWith----------------");
//        List<Member> memberList2 = memberRepository.findByNameStartingWith("이");
//        memberList2.forEach(s -> System.out.println(s));
//
//        System.out.println("EndingWith----------------");
//        List<Member> memberList3 = memberRepository.findByNameEndingWith("동");
//        memberList3.forEach(s -> System.out.println(s));
//
//        System.out.println("IsNotEmpty----------------");
//        List<Member> memberList11 = memberRepository.findByAddressIsNotEmpty();
//        memberList11.forEach(s -> System.out.println(s));
//
////        List<Member> memberList12 = memberRepository.findByMaleIsFalse();
////        memberList12.forEach(s -> System.out.println(s));
//    }

//    @Test
//    void jpaQueryMethodTest6() {
//        System.out.println("page-----------------");
//        Page<Member> pageMember = memberRepository.findByName("홍길동", PageRequest.of(0, 3, Sort.by(Sort.Order.desc("id"), Sort.Order.asc("name"))));
//        List<Member> memberList = pageMember.getContent();
//        memberList.forEach(System.out::println);
//    }


}
