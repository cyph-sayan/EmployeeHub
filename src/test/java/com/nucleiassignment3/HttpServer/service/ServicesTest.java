package com.nucleiassignment3.HttpServer.service;

import com.nucleiassignment3.HttpServer.bo.EmployeeBo;
import com.nucleiassignment3.HttpServer.model.CreateEmployeeRequest;
import java.sql.Date;
import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Disabled
public class ServicesTest {
  @Autowired
  EmployeeService employeeService;

  @Ignore
  @Test
  void createRequestTest() {
    EmployeeBo employeeBo = employeeService.createEmployee(
        new CreateEmployeeRequest("Syan", Date.valueOf("2000-08-11"), "M"));
    Assertions.assertEquals("Syan", employeeBo.getName());
    Assertions.assertEquals("2000-08-11", employeeBo.getDob());
    Assertions.assertEquals("M", employeeBo.getGender());
  }
}
