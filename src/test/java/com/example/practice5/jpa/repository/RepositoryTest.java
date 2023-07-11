package com.example.practice5.jpa.repository;

import com.example.practice5.jpa.model.Board;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class RepositoryTest {
    @Autowired
    private BoardRepository boardRepository;

    @BeforeEach
    void setUp() {

    }

    @DisplayName("Jpa 테스트")
    @Test
    void setBoardRepositoryTest() {
        Board board1 = Board.builder()
                        .boardNo(1L)
                        .boardKind("공지글")
                        .title("내용입니다.")
                        .build();
        List<Board> boardList = boardRepository.findAllById(Lists.newArrayList(1L));
        boardList.forEach(System.out::println);
    }



}
