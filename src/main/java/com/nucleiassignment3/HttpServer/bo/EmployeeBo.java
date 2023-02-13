package com.nucleiassignment3.HttpServer.bo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeBo {

    private int emp_id;
    private String name;
    private Date date;
    private String gender;

}
