package com.nucleiassignment3.HttpServer.service;

import com.nucleiassignment3.HttpServer.bo.EmployeeBo;
import com.nucleiassignment3.HttpServer.model.CreateEmployeeRequest;
import com.nucleiassignment3.HttpServer.model.UpdateEmployeeRequest;

import java.util.List;

public interface EmployeeService {

    EmployeeBo createEmployee(CreateEmployeeRequest createEmployeeRequest);
    EmployeeBo getEmployee(String id);
    List<EmployeeBo> listEmployees(int pageSize, int pageNumber);
    EmployeeBo updateEmployee(String id, UpdateEmployeeRequest updateEmployeeRequest);
    void deleteEmployee(String id);

}
