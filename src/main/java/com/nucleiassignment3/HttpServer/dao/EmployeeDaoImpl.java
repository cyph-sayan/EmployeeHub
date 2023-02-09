package com.nucleiassignment3.HttpServer.dao;

import com.nucleiassignment3.HttpServer.bo.EmployeeBo;
import com.nucleiassignment3.HttpServer.entity.Employee;
import com.nucleiassignment3.HttpServer.mapper.EmployeeMapper;
import com.nucleiassignment3.HttpServer.repository.EmployeeRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    private EmployeeMapper employeeMapper= Mappers.getMapper(EmployeeMapper.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(EmployeeBo employeeBo) {

        return employeeRepository.save(employeeMapper.employeeBoToEmployee(employeeBo));
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
    public Employee updateEmployee(int id, EmployeeBo employeeBo) {
        Employee existingEmployee=employeeRepository.findById(id).orElse(null);
        existingEmployee.setName(employeeBo.getName());
        existingEmployee.setDate(employeeBo.getDate());
        existingEmployee.setGender(employeeBo.getGender());
        return employeeRepository.save(existingEmployee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
