package com.example.practice5.jpa.repository;

import com.example.practice5.jpa.model.Member;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;


@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void crud() {
//        Member member1 = new Member(1L, "홍길동", null, LocalDateTime.now(), LocalDateTime.now());
        // insert문
//        Member copyMember = memberRepository.save(member1); // insert into Member values (~~~
//        System.out.println("copyMember -> " + copyMember);

//        Member member =
        // select all문
        System.out.println("select all문--------------------------------------------------------");
        List<Member> memberList = memberRepository.findAll(Sort.by(Sort.Direction.DESC, "name")); // == select * from member
        // jdk 1.8에서 사용된 stream기술을 이용한 print찍는 방법
        memberList.forEach(System.out::println);
//        for(Member member : memberList) {
//            System.out.println(member.toString());
//        }

        // select where문
        System.out.println("select where문 --------------------------------------------------------");
        List<Member> memberList2 = memberRepository.findAllById(Lists.newArrayList(1L, 3L, 5L)); // == select * from member where id in (1, 3)
        memberList2.forEach(System.out::println);

        // update문
        System.out.println("update문 --------------------------------------------------------");
        Member member1 = new Member(1L, "홍길동", "이메일 주소", LocalDateTime.now(), LocalDateTime.now());
        memberRepository.save(member1);     // 1번을 가진 id가 있다면 update, 없으면 create문 발생
        List<Member> memberList3 = memberRepository.findAll();
        memberList3.forEach(System.out::println);

         //delete문
        System.out.println("delete문 --------------------------------------------------------");
        memberRepository.deleteAll();  // deleteaLL 한개씩  : 성능안좋은
        memberRepository.deleteAllInBatch(); // delete 한번에
        List<Member> memberList4 = memberRepository.findAll();
        memberList4.forEach(System.out::println);
    }

    @Test
    void crud2() {
        // insert 문
        Member member = Member.builder()
                .id(8L)
                .name("소우리")
                .createAt(LocalDateTime.now())
                .build();
        memberRepository.save(member);

        Member member2 = Member.builder()
                .id(9L)
                .name("박소현")
                .email("parksohyeon@gmail.com")
                .updateAt(LocalDateTime.now())
                .build();
        memberRepository.save(member2);

        Member member3 = Member.builder()
                .id(15L)
                .name("박조은")
                .email("parkjoeun@gmail.com")
                .createAt(LocalDateTime.now())
                .build();
        memberRepository.save(member3);

        // select(by)
        Optional<Member> memberOptional = memberRepository.findById(10L);
        System.out.println("memberOptional" + memberOptional);
//        Member member = memberRepository.findById(1L).orElse(null);
//        if (member != null) {
//            System.out.println(member);
//        }

        List<Member> memberList4 = memberRepository.findAllById(Lists.newArrayList(3L, 7L)); // == select * from member where id in (1, 3)
        memberList4.forEach(System.out::println);

        // select count 함수
        System.out.println("count: " + memberRepository.count());

        // select exist함수
        boolean isFiveNumberMember = memberRepository.existsById(5L);
        if (isFiveNumberMember)
            System.out.println("5번 회원 존재");

        boolean isNinetyNumberMember = memberRepository.existsById(90L);
        if (isNinetyNumberMember)
            System.out.println("90번 회원 존재");

        // select page함수
        Page<Member> membersPage = memberRepository.findAll(PageRequest.of(0, 4));
        System.out.println("page: " + membersPage);
        System.out.println("totalElements: " + membersPage.getTotalElements());
        System.out.println("totalPage: " + membersPage.getTotalPages());
        System.out.println("numberOfElements: " + membersPage.getNumberOfElements());
        System.out.println("sort: " + membersPage.getSort());
        System.out.println("size: " + membersPage.getSize());

        List<Member> memberList2 = membersPage.getContent();
        memberList2.forEach(System.out::println);

        System.out.println("-----------------------------------------------------------");
        // jpa find example이용(select)
        ExampleMatcher matcher = ExampleMatcher.matching()
//                .withIgnorePaths("name")
                .withMatcher("email", endsWith());

        Example<Member> memberExample = Example.of(
                Member.builder().email("@thejoeun.com").build(),
                matcher
        );

        memberRepository.findAll(memberExample).forEach(System.out::println);

    }

    @DisplayName("semiProject sqlmapper관련 xml sql코드를 jpa 자바코드로 변환 테스트")
    @Test
    void crudSemiSqlMapper() {

    }


}