package com.example.practice5.jpa.repository;

import com.example.practice5.jpa.model.Book;
import com.example.practice5.jpa.model.Member;
import com.example.practice5.jpa.model.Publisher;
import com.example.practice5.jpa.model.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

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



}