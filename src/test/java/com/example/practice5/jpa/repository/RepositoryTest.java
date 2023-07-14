package com.example.practice5.jpa.repository;

import com.example.practice5.jpa.model.Address;
import com.example.practice5.jpa.model.Board;
import com.example.practice5.jpa.model.Book;
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

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AddressRepository addressRepository;

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

    @DisplayName("book Table 테스트")
    @Test
    void bookRepositoryTest() throws InterruptedException {
        Book book = Book.builder()
                .title("어린왕자")
//                .author("생떽지베리")
                .build();
        Book book2 = bookRepository.save(book);

        Thread.sleep(5000);
//        book2.setAuthor("작가미상");
        bookRepository.save(book2);
    }



    @DisplayName("address Table 테스트")
    @Test
    void addressRepositoryTest() {
        Address address = Address.builder()
                .zipcode("123-456")
                .build();
        addressRepository.save(address);
    }

}
