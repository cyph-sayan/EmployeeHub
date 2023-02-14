package com.nucleiassignment3.HttpServer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.sql.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@javax.persistence.Table(name="employee")
public class Employee extends MetaData
{
    @Column(name="row_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int rowId;

    @Id
    @Column(name = "emp_id")
    private String empId;

    @Column(name = "name")
    private String name;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "dob")
    private Date dob;

    @Column(name = "gender")
    private String gender;
}
