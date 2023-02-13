package com.nucleiassignment3.HttpServer.dao;

import com.nucleiassignment3.HttpServer.bo.EmployeeBo;
import com.nucleiassignment3.HttpServer.entity.Employee;
import java.util.List;

public interface EmployeeDao {
    EmployeeBo createEmployee(EmployeeBo employeeBo);
    EmployeeBo getEmployee(int id);
    List<EmployeeBo> listEmployees(int pageSize, int pageNumber);
    EmployeeBo updateEmployee(int  id, EmployeeBo employeeBo);
    void deleteEmployee(int id);
}
