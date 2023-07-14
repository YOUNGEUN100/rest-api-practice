package com.example.practice5.jpa.model;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

public class TimeAuditableEntityListener {

    @PrePersist
    public void preInsert(Object o) {
        if (o instanceof  TimeAuditable) {
            ((TimeAuditable) o).setCreateAt(LocalDateTime.now());
        }
    }
    @PreUpdate
    public void preUpdate(Object o) {
        if (o instanceof  TimeAuditable) {
            ((TimeAuditable) o).setUpdateAt(LocalDateTime.now());
        }
    }
}
