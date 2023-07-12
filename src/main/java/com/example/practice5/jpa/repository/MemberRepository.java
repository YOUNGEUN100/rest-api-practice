package com.example.practice5.jpa.repository;

import com.example.practice5.jpa.model.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface MemberRepository extends JpaRepository<Member, Long> {


    Set<Member> readByEmail(String email);

//    List<Member> findByName(String name);
//    List<Member> readByName(String name);
//    List<Member> searchByName(String name);
//    List<Member> queryByName(String name);
//    List<Member> getByName(String name);
//    List<Member> streamByName(String name);

    Optional<Member> findByCreateAt(LocalDateTime localDataTime);

    boolean existsByName(String name);
    boolean existsByEmail(String email);

    Integer countByName(String name);

    List<Member> findTop1ByEmail(String email);
    List<Member> findFirst1ByEmail(String email);
    List<Member> findTop2ByEmail(String email);

    List<Member> findDistinctByEmail(String email);

    List<Member> findByNameAndEmail(String name, String email);
    List<Member> findByNameOrEmail(String name, String email);

    List<Member> findByCreateAtAfter(LocalDateTime yesterday);
    List<Member> findByCreateAtIsAfter(LocalDateTime yesterday);

    List<Member> findByCreateAtGreaterThan(LocalDateTime yesterday);
    List<Member> findByCreateAtGreaterThanEqual(LocalDateTime yesterday);
    List<Member> findByIdGreaterThanEqual(Long id);

    List<Member> findByCreateAtBetween(LocalDateTime yesterday, LocalDateTime tomorrow);

    List<Member> findByIdGreaterThanEqualAndIdLessThanEqual(Long id1, Long id2);

    List<Member> findByEmailIsNotNull();

    List<Member> findByNameLike(String likeName);

    List<Member> findByNameIn(List<String> nameList);

    List<Member> findByNameContains(String name);

    List<Member> findByNameStartingWith(String name);
    List<Member> findByNameEndingWith(String name);

    List<Member> findByAddressIsEmpty();

    List<Member> findByAddressIsNotEmpty();

//    List<Member> findByMaleIsFalse();

//    List<Member> findByName(String name);
    Page<Member> findByName(String name, Pageable pageable);
}

