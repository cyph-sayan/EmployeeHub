package com.nucleiassignment3.HttpServer.bo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeBo implements Serializable {

    private String empId;
    private String name;
    private Date dob;
    private String gender;

}
