package com.example.practice5.jpa.repository;

import com.example.practice5.jpa.model.Address;
import com.example.practice5.jpa.model.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddressRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private AddressRepository addressRepository;

    private Member getGivenMember() {
        Member member = Member.builder()
                .name("강유미")
                .email("gangumi@naver.com")
                .build();
        return memberRepository.save(member);
    }

    private Address getGivenAddress(Member member) {
        Address address = Address.builder()
                .zipcode("123-456")
                .member(member)
                .build();
        return addressRepository.save(address);
    }

    @DisplayName("m to a 테스트")
    @Test
    void oneToOneTest1() {
        Member member = getGivenMember();
        Address address = getGivenAddress(member);
        List<Address> addressList = addressRepository.findAll();
        addressList.forEach(System.out::println);

    }
}