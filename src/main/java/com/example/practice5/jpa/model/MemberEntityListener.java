package com.example.practice5.jpa.model;

import com.example.practice5.jpa.repository.MemberLogHistoryRepository;
import com.example.practice5.jpa.util.SpringBeanUtils;
import jakarta.persistence.*;

public class MemberEntityListener {

    @PostPersist
    @PostUpdate
    public void afterMemberSave(Object o) {
        MemberLogHistoryRepository memberLogHistoryRepository = SpringBeanUtils.getBean(MemberLogHistoryRepository.class);

        Member member = (Member) o;

        MemberLogHistory memberLogHistory = MemberLogHistory.builder()
                .member(member)
                .name(member.getName())
                .email(member.getEmail())
                .build();

        memberLogHistoryRepository.save(memberLogHistory);
    }
}
