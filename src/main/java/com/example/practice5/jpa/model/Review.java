package com.example.practice5.jpa.model;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(500)", nullable = false)
    private String title;
    @Column(columnDefinition = "text")
    private String content;
    @Column(columnDefinition = "float")
    private float score;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Book book;
}


