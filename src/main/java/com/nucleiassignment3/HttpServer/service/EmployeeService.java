package com.nucleiassignment3.HttpServer.service;

import com.nucleiassignment3.HttpServer.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee createEmployee(Employee employee);
    public Employee getEmployee(int id);
    public List<Employee> listEmployees();
    public Employee updateEmployee(int id, Employee employee);
    public String deleteEmployee(int id);
}
