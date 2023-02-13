package com.nucleiassignment3.HttpServer.service;

import com.nucleiassignment3.HttpServer.bo.EmployeeBo;
import java.util.List;

public interface EmployeeService {

    EmployeeBo createEmployee(EmployeeBo employeeBo);
    EmployeeBo getEmployee(int id);
    List<EmployeeBo> listEmployees(int pageSize, int pageNumber);
    EmployeeBo updateEmployee(int id, EmployeeBo employeeBo);
    void deleteEmployee(int id);

}
