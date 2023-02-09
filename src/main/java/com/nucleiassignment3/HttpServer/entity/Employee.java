package com.nucleiassignment3.HttpServer.entity;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@javax.persistence.Table(name="employees")
public class Employee {
    @Column(name="row_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int row_id;

    @javax.persistence.Id
    @javax.persistence.Column(name = "emp_id")
    private int emp_id;

    @javax.persistence.Column(name = "name")
    private String name;

    @javax.persistence.Column(name = "dob")
    private Date date;

    @javax.persistence.Column(name = "gender")
    private String gender;

    @javax.persistence.Column(name="created_at")
    @CreationTimestamp
    private Timestamp created_at;

}
