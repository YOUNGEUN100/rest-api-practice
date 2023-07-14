package com.example.practice5.jpa.repository;

import com.example.practice5.jpa.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
