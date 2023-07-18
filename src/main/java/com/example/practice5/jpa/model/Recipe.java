package com.example.practice5.jpa.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Recipe {
    @Id
    private Long recipeNo;

    @NonNull
    private String recipeName;


    private String cookTime;

    private String difficulty;

    private int recipeHits;

    private String deleteYn;

    private String hashtag;

    @Column(updatable = false)
    private LocalDateTime createAt;

    @Column(insertable = false)
    private LocalDateTime updateAt;

}

