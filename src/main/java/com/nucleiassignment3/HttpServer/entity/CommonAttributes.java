package com.nucleiassignment3.HttpServer.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

public abstract class CommonAttributes {

    @javax.persistence.Column(name="created_time")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @javax.persistence.Column(name="update_time")
    @UpdateTimestamp
    private LocalDateTime updateTimestamp;

    @javax.persistence.Column(name="active")
    private int active=1;

    @javax.persistence.Column(name = "created_by")
    private String creator;

    @javax.persistence.Column(name = "updated_by")
    private String updator;
}
