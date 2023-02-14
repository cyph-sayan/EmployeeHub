package com.nucleiassignment3.HttpServer.mapper;

import com.nucleiassignment3.HttpServer.bo.EmployeeBo;
import com.nucleiassignment3.HttpServer.entity.Employee;
import com.nucleiassignment3.HttpServer.model.CreateEmployeeRequest;
import com.nucleiassignment3.HttpServer.utility.IdGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapperTest {

    @Autowired
    public EmployeeMapper employeeMapper;

    @Test
    void testEntityToBo()
    {
        Employee employee=new Employee();
        employee.setName("Sayan");
        employee.setDob(Date.valueOf("2000-08-11"));
        employee.setGender("M");

        EmployeeBo employeeBo=employeeMapper.entityToBo(employee);
        assertEquals(employeeBo.getName(),employee.getName());
        assertEquals(employeeBo.getGender(),employee.getGender());
        assertEquals(employeeBo.getDob(),employee.getDob());
    }

    @Test
    void testBoToEntity()
    {
        EmployeeBo employeeBo=new EmployeeBo();
        employeeBo.setName("Sayan");
        employeeBo.setDob(Date.valueOf("2000-08-11"));
        employeeBo.setGender("M");

        Employee employee=employeeMapper.boToEntity(employeeBo);
        assertEquals(employee.getName(),employeeBo.getName());
        assertEquals(employee.getGender(),employeeBo.getGender());
        assertEquals(employee.getDob(),employeeBo.getDob());
    }
    @Test
    void testCreateRequestToBo()
    {
        CreateEmployeeRequest createEmployeeRequest=new CreateEmployeeRequest();
        createEmployeeRequest.setName("Sayan");
        createEmployeeRequest.setDob(Date.valueOf("2000-08-11"));
        createEmployeeRequest.setGender("M");
        EmployeeBo employeeBo=employeeMapper.createRequestToBo(createEmployeeRequest,IdGenerator.generateEmployeeId());
        System.out.println(employeeBo.getEmpId());
        assertEquals("Sayan",employeeBo.getName());
        assertEquals(Date.valueOf("2000-08-11"),employeeBo.getDob());
        assertEquals("M",employeeBo.getGender());
    }
}
