package com.example.practice5.jpa.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Member2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", updatable = false)
    private Long id;
    @NonNull
    private String name;
    private String email;
    private String email2;
    private String email3;

}
