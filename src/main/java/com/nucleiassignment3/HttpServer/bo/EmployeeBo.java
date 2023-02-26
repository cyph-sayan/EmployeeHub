package com.nucleiassignment3.HttpServer.bo;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeBo {

  private String empId;
  private String name;
  private Date dob;
  private String gender;

}
