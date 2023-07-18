package com.example.practice5.jpa.model;

import com.example.practice5.jpa.model.enums.Nation;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@EqualsAndHashCode(callSuper=false)
//@Getter
//@Setter
@EntityListeners(value = MemberEntityListener.class)
public class Member extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    private String email;
    private Boolean male;


//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Address> address;

    @Enumerated(value = EnumType.ORDINAL)
    private Nation nation;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id", insertable = false, updatable = false)
    @ToString.Exclude
    private List<MemberLogHistory> memberLogHistories;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    @ToString.Exclude
    private List<Review> reviews;




//    @PrePersist
//    public void beforeInsert() {
//        System.out.println(">>> beforeInsert()");
//    }
//    @PreUpdate
//    public void beforeUpdate() {
//        System.out.println(">>> beforeUpdate()");
//    }
//    @PreRemove
//    public void beforeDelete() {
//        System.out.println(">>> beforeDelete()");
//    }
//
//    @PostPersist
//    public void afterInsert() {
//        System.out.println(">>> afterInsert()");
//    }
//    @PostRemove
//    public void afterDelete() {
//        System.out.println(">>> afterDelete()");
//    }
//    @PostUpdate
//    public void afterUpdate() {
//        System.out.println(">>> afterUpdate()");
//    }
//    @PostLoad
//    public void afterSelect() {
//        System.out.println(">>> afterSelect()");
//    }

}
