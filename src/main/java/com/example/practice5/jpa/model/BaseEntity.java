package com.example.practice5.jpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(value = AuditingEntityListener.class)
public class BaseEntity implements TimeAuditable{
    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime createAt;
    @Column(insertable = false)
    @LastModifiedDate
    private LocalDateTime updateAt;
    @CreatedBy
    private Long createBy;
    @LastModifiedBy
    private Long updateBy;
}
