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
public class Author extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;


//    @ManyToMany
//    @ToString.Exclude
//    private List<Book> books;

//    @OneToMany
//    @JoinColumn
//    private List<AuthorAndBook> authorAndBookList;

    @OneToMany
    @JoinColumn
    private List<Publisher> publisherList;


}
