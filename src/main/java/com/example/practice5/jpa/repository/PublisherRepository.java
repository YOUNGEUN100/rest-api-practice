package com.example.practice5.jpa.repository;

import com.example.practice5.jpa.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
