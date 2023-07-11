package com.example.practice5.jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Recipe {
    @Id
    private Long recipeNo;
    private String recipeName;
    private String time;
    private String difficulty;
    private int recipeHits;
    private String deleteYn;
    private String hashtag;
    private LocalDateTime cdatetime;
    private LocalDateTime udatetime;

}
