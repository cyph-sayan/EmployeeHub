package com.nucleiassignment3.httpserver.service;

import com.nucleiassignment3.httpserver.bo.EmployeeBo;
import com.nucleiassignment3.httpserver.model.CreateEmployeeRequest;
import com.nucleiassignment3.httpserver.model.UpdateEmployeeRequest;

import java.util.List;

public interface EmployeeService {

  EmployeeBo createEmployee(CreateEmployeeRequest createEmployeeRequest);

  EmployeeBo getEmployee(String id);

  List<EmployeeBo> listEmployees(int pageSize, int pageNumber);

  EmployeeBo updateEmployee(String id, UpdateEmployeeRequest updateEmployeeRequest);

  void deleteEmployee(String id);

}
