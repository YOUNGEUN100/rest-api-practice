package com.example.practice5.lombok;

import com.example.practice5.lombok.model.Member;
import com.example.practice5.lombok.model.User;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class LombokTestApplicationTest {

    @BeforeEach
    void setUp() {
    }

    @DisplayName("Lombok 테스트")
    @Test
    void lombokTest() {
        User user = new User();
        user.setName("홍길동");
        user.setEmail("gildong@gmail.com");

        User user2 = new User("김복순", "boksun@abc.com", LocalDateTime.now(), LocalDateTime.now());
        User user3 = new User("엄복동", "bokdong@abc.com");


        System.out.println(user.getName());
        System.out.println(user.getEmail());

        // user builder 이용한 user 객체 생성
        // null pointer exception 을 방지하는 기능
        User user4 = User.builder()
                .name("태리")
                .email("asdlfj@naver.com")
                .createAt(LocalDateTime.now()).build();

        System.out.println("-----user4-----");
        System.out.println(user4.getName());
        System.out.println(user4.getEmail());
        System.out.println(user4.getCreateAt());

        Member member = new Member();
        member.setId(1L);

        System.out.println("-----------");
        System.out.println(member.getId());
    }

    @AfterEach
    void tearDown() {
    }


}