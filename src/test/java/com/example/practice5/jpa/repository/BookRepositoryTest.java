package com.example.practice5.jpa.repository;

import com.example.practice5.jpa.model.*;
import jakarta.persistence.Tuple;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@SpringBootTest
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PublisherRepository publisherRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MemberRepository memberRepository;

    
    @Test
    @Transactional
    void relationTest1() {
        givenBookAndReview();

        Member member = memberRepository.findByEmail("leesunsin@gmail.com");
        System.out.println(">>> member: " + member);

        Book book = member.getReviews().get(0).getBook();
        System.out.println(">>> book: " + book);
        Publisher publisher = book.getPublisher();
        System.out.println(">>> publisher: " + publisher);
    }

    private Book givenBook(Publisher publisher) {
        Book book = Book.builder()
                .title("java를 잡아")
                .publisher(publisher)
                .build();
        return bookRepository.save(book);
    }

    private Publisher givenPublisher() {
        Publisher publisher = Publisher.builder()
                .name("나무나무")
                .build();
        return  publisherRepository.save(publisher);
    }

    private Book givenBook() {
        Book book = Book.builder()
                .title("java를 잡아")
                .build();
        return bookRepository.save(book);
    }
    private Member givenMember() {
        return memberRepository.findByEmail("leesunsin@gmail.com");
    }

    private Review givenReview(Member member, Book book) {
        Review review = Review.builder()
                .title("너무 재밌는 책")
                .content("java를 잡아 너무 재미있는 책입니다.")
                .book(book)
                .member(member)
                .build();
        return reviewRepository.save(review);
    }
    


    private void givenBookAndReview() {
        givenReview(givenMember(), givenBook(givenPublisher()));
    }

    @Test
    void jpaTest() {


//        List<Book> bookList = bookRepository.findByMyBook("자바책");
//        bookList.forEach(System.out::println);
//        System.out.println("findByMyBook--------------------------------------------------------------------");

//
//        List<Book> bookList2 = bookRepository.findByMyBooksAndMyId("자바책", 1L);
//        bookList2.forEach(System.out::println);
//        System.out.println("findByMyBooksAndMyId--------------------------------------------------------------------");
//
//
//        // 성공
//        List<String> bookList3 = bookRepository.findTitleByMyBooks("자바책");
//        bookList3.forEach(System.out::println);
//        System.out.println("findTitleByMyBooks--------------------------------------------------------------------");
//
//
////        // 에러
////        List<Book> bookList4 = bookRepository.findTitleIdByMyBooks("자바책");
////        bookList4.forEach(System.out::println);
//        List<Map<String, Object>> listMap1 = bookRepository.findTitleIdByMyBooks("자바책");
//        listMap1.forEach(x -> System.out.println(x.entrySet()));
//        listMap1.forEach(x -> System.out.println(x.values()));
//        System.out.println("findTitleIdByMyBooks--------------------------------------------------------------------");
//
//        List<Map<String, Object>> listMap2 = bookRepository.findByNamedTitleIdByMyBooks("자바책");
//        listMap2.forEach(x -> System.out.println(x.entrySet()));
//        System.out.println("findByNamedTitleIdByMyBooks--------------------------------------------------------------------");

    }

    @Test
    void nativeSqlTest1() {
//        List<Book> bookListByNative = bookRepository.findByNativeByMyBooks( "자바책");
//        bookListByNative.forEach(System.out::println);
//
//        System.out.println("--------------------------------------------------------------------1");
//
//        List<Book> bookListByNativeName = bookRepository.findByNativeTitleByMyBooks( "자바책");
//        bookListByNativeName.forEach(System.out::println);
    }

    @Test
    void customTest1() {
//        List<BookAndId> bookAndIdList = bookRepository.findByCustomNamedTitleIdByMyBooks("자바책");
//        bookAndIdList.forEach(s -> System.out.println(s.getAbc() + " : " + s.getTitle2()));

//        List<Tuple> bookAndIdList = bookRepository.findByCustomNamedNameIdByMyBooks("자바책");
//        bookAndIdList.forEach(tuple -> System.out.println(tuple.get(0) + " : " + tuple.get(1)));

    }

    @Test
    void updateTest1() {
//        int isUpdate = bookRepository.updateSpecificName(1L);
//        System.out.println("2번 id를 book의 이름 " + (isUpdate > 0? "바뀜" : "안바뀜") + isUpdate);

//        int isUpdate = bookRepository.updateSpecificNameByJPQL(2L);
//        System.out.println("2번 id를 가진 book의 이름 " + (isUpdate > 0 ? " 바뀜" : " 바뀌지 않음"));

    }

}