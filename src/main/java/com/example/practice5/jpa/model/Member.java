package com.example.practice5.jpa.model;

import com.example.practice5.jpa.model.enums.Nation;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Member {
    @Id
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    private String email;
    @Column(name = "colTest2", unique = true)
    private Integer test2;
    @Column(updatable = false)
    private LocalDateTime createAt;
    @Column(columnDefinition = "datetime(6) DEFAULT now() comment '수정시간'", insertable = false)
    private LocalDateTime updateAt;

    private Boolean male;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Address> address;

    @Enumerated(value = EnumType.ORDINAL)
    private Nation nation;


}
