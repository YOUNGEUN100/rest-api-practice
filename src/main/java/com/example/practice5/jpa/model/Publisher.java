package com.example.practice5.jpa.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class Publisher extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany
    @JoinColumn(name = "publisher_id")
    private List<Book> books;

    @ManyToOne
    private List<Author> authors;
}
