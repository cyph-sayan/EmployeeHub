package com.nucleiassignment3.HttpServer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeRequest
{
    private String name;
    private Date dob;
    private String gender;
}
