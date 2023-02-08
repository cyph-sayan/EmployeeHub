package com.nucleiassignment3.HttpServer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private int emp_id;

    @Column(name = "name")
    private String name;

    @Column(name = "dob")
    private Date date;

    @Column(name = "gender")
    private String gender;

    @Column(name="created_at")
    @CreationTimestamp
    private Timestamp created_at;

}
