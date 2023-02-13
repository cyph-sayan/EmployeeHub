package com.nucleiassignment3.HttpServer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@javax.persistence.Table(name="employees")
public class Employee extends CommonAttributes{

    @javax.persistence.Column(name="row_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int rowId;

    @Id
    @javax.persistence.Column(name = "emp_id")
    private int empId;

    @javax.persistence.Column(name = "name")
    private String name;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @javax.persistence.Column(name = "dob")
    private Date dob;

    @javax.persistence.Column(name = "gender")
    private String gender;

    @javax.persistence.Column(name="created_at")
    @CreationTimestamp
    private Timestamp created_at;

}
