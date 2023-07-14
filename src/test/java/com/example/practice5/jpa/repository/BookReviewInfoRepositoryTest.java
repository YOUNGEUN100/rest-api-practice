package com.example.practice5.jpa.repository;

import com.example.practice5.jpa.model.Book;
import com.example.practice5.jpa.model.BookReviewInfo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookReviewInfoRepositoryTest {


    @Autowired
    private BookReviewInfoRepository bookReviewInfoRepository;
    @Autowired
    private BookRepository bookRepository;



    @BeforeEach
    void setUp() {}

    @Test
    void crudTest1() {
        BookReviewInfo bookReviewInfo = BookReviewInfo.builder()
//                .bookId(1L)
                .avgReviewScore(2.5f)
                .reviewCount(8)
                .build();
        bookReviewInfoRepository.save(bookReviewInfo);
        System.out.println(">>>" + bookReviewInfo);
    }

    @Test
    void crudTest2() {
        Book book = Book.builder()
                .title("홍길동전")
//                .author("작가미상")
                .build();
        bookRepository.save(book);

        BookReviewInfo bookReviewInfo = BookReviewInfo.builder()
//                .bookId(1L)
                .avgReviewScore(2.5f)
                .reviewCount(8)
                .build();
        bookReviewInfoRepository.save(bookReviewInfo);

        List<BookReviewInfo> bookReviewInfoList = bookReviewInfoRepository.findAll();
        bookReviewInfoList.forEach(System.out::println);

//        Book book2 = bookRepository.findById(bookReviewInfoList.get(0).getBookId()).orElseThrow(RuntimeException::new);
//        System.out.println(">>> book2: " + book2);
    }

    private Book getGivenBook() {
        Book book = Book.builder()
                .title("인어공주")
//                .author("안데르센")
                .build();
        return bookRepository.save(book);
    }
    private BookReviewInfo getGivenBookReviewInfo(Book book) {
        BookReviewInfo bookReviewInfo = BookReviewInfo.builder()
                .book(book)
                .avgReviewScore(4.2f)
                .reviewCount(120)
                .build();
        return bookReviewInfoRepository.save(bookReviewInfo);
    }

    @Test
    void oneToOneTest() {
        Book book = getGivenBook();
        BookReviewInfo bookReviewInfo = getGivenBookReviewInfo(book);
//        System.out.println("book>>>>>>" + book);
//        System.out.println("bookInfo>>>>>>" + bookReviewInfo);

//        List<BookReviewInfo> bookReviewInfoList = bookReviewInfoRepository.findAll();
//        bookReviewInfoList.forEach(System.out::println);
        bookReviewInfoRepository.findById(1L);
    }


    @AfterEach
    void tearDown() {}


}