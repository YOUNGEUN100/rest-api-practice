package com.example.practice5.jpa.model;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class T4Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardNo;
    private String userId;
    private String nick;
    private String status;
    private String title;
    private String content;
    private int hits;
}
