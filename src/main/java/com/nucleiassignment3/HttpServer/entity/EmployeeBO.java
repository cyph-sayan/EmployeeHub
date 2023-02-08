package com.nucleiassignment3.HttpServer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeBO {
    private String name;
    private Date dob;
    private String gender;
}
