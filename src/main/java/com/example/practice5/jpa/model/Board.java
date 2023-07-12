package com.example.practice5.jpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Board {
    @Id
    private long boardNo;
    private String boardKind;
    private String keywordType;
    private String userId;
    @Column(updatable = false)
    private LocalDateTime cdatetime;
    @Column(insertable = false)
    private LocalDateTime udatetime;
    private String title;
    private String content;
    private String viewCnt;
    private String delYn;
}

