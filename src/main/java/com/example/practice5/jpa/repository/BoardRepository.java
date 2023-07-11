package com.example.practice5.jpa.repository;

import com.example.practice5.jpa.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
