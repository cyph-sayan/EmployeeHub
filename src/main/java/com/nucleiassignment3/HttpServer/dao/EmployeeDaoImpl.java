package com.nucleiassignment3.HttpServer.dao;

import com.nucleiassignment3.HttpServer.entity.Employee;
import com.nucleiassignment3.HttpServer.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> listEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(int id,Employee employee) {
        Employee existingEmployee=employeeRepository.findById(id).orElse(null);
        existingEmployee.setName(employee.getName());
        existingEmployee.setDate(employee.getDate());
        existingEmployee.setGender(employee.getGender());
        return employeeRepository.save(existingEmployee);
    }

    @Override
    public String deleteEmployee(int id) {
        employeeRepository.deleteById(id);
        return "Employee Deleted: "+id;
    }
}
