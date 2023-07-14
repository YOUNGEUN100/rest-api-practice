package com.example.practice5.jpa.repository;

import com.example.practice5.jpa.model.BookReviewInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookReviewInfoRepository extends JpaRepository<BookReviewInfo, Long> {
}
