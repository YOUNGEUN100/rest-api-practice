package com.example.practice5.jpa.repository;

import com.example.practice5.jpa.model.Member;
import com.example.practice5.jpa.model.Users;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class EntityManagerTest {
    @Autowired
    private EntityManager em;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private UsersRepository usersRepository;

    @Test
    void entityManagerTest() {
        em.createQuery("select u from Member u").getResultList().forEach(s -> System.out.println(s));
    }

    @Test
    @Transactional
    void cacheEntityFindTest() {
//        System.out.println(memberRepository.findById(1L));
//        System.out.println(memberRepository.findById(1L));
//        System.out.println(memberRepository.findById(1L));

        memberRepository.deleteById(1L);
    }

    @Test
    @Transactional
    void cacheEntityFindTest2() {
        Member member = memberRepository.findById(1L).get();
        member.setName("이몽룡");

        memberRepository.save(member);
//        memberRepository.flush();
        System.out.println("-------------------------------------flush!!!!");

        member.setEmail("leemonglyong@naver.com");
        memberRepository.save(member);
//        memberRepository.flush();
        System.out.println("-------------------------------------flush!!!!");
    }

    @Test
    @Transactional
    void entityManagerTest2() {
        Member member = Member.builder()
                .name("김민지")
                .email("kimmingi@naver.com")
                .build();
        em.persist(member); // jpa 영속성 상태 존재

        em.detach(member);

//        em.remove(member);

        memberRepository.findAll().forEach(System.out::println);
    }


    @Test
    @Transactional
    @Commit
    void entityManagerTest3() {
        Users user = Users.builder()
                .name("홍길동10")
                .build();
//        usersRepository.save(users)
        em.persist(user); // 영속성 상태
        em.detach(user);
        user.setEmail("ho10@abc.com");

        em.detach(user);
//        em.clear();
//        em.merge(user); // 준영속성 상태에서 영속성 상태로 변경
//        em.remove(user);    // 비영속성으로 삭제 상태

        usersRepository.findAll().forEach(System.out::println);
//        System.out.println(usersRepository.findByName("홍길동10").get(0));
    }

    @Test
    @Transactional
    @Commit
    void persisCacheDelayUpdateTest() {
        Users user1 = usersRepository.findById(1L).get();
        user1.setName("최은아");
        usersRepository.save(user1);

//        user1.setEmail("choieuna@gmail.com");
//        usersRepository.save(user1);
    }

}
