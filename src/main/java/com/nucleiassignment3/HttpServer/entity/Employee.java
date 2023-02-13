package com.nucleiassignment3.HttpServer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@javax.persistence.Table(name="employees")
public class Employee extends MetaData
{
    @Column(name="row_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int rowId;

    @Id
    @Column(name = "emp_id")
    private int empId;

    @Column(name = "name")
    private String name;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "dob")
    private Date dob;

    @Column(name = "gender")
    private String gender;
}
