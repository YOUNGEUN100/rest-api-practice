package com.example.practice5.jpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "memberCopy", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})}, indexes = {@Index(columnList = "email")})
public class Member2 {
    @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = true)
    private Long id;
    //    @NonNull
    private String name;
    private String email;
    private String email2;
}

