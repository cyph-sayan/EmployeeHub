package com.nucleiassignment3.HttpServer.dao;

import com.nucleiassignment3.HttpServer.bo.EmployeeBo;
import com.nucleiassignment3.HttpServer.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee createEmployee(EmployeeBo employeeBo);
    Employee getEmployee(int id);
    List<Employee> listEmployees();
    Employee updateEmployee(int  id, EmployeeBo employeeBo);
    void deleteEmployee(int id);
}
