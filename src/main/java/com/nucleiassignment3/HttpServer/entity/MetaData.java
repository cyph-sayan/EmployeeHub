package com.nucleiassignment3.HttpServer.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class MetaData {

    @Column(name="create_time")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name="update_time")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(name="active")
    private int active=1;

    @Column(name = "created_by")
    private String creator;

    @Column(name = "updated_by")
    private String updator;
}
