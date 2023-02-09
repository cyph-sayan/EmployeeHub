package com.nucleiassignment3.HttpServer;

import com.nucleiassignment3.HttpServer.bo.EmployeeBo;
import com.nucleiassignment3.HttpServer.entity.Employee;
import com.nucleiassignment3.HttpServer.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapperTest {
    private EmployeeMapper employeeMapper= Mappers.getMapper(EmployeeMapper.class);
    @Test
    void testEntityToBo(){
        Employee employee=new Employee();
        employee.setName("Sayan");
        employee.setDate(Date.valueOf("2000-08-11"));
        employee.setGender("M");

        EmployeeBo employeeBo=employeeMapper.employeeToEmployeeBo(employee);
        assertEquals(employeeBo.getName(),employee.getName());
        assertEquals(employeeBo.getGender(),employee.getGender());
        assertEquals(employeeBo.getDate(),employee.getDate());
    }

    @Test
    void testBoToEntity(){
        EmployeeBo employeeBo=new EmployeeBo();
        employeeBo.setName("Sayan");
        employeeBo.setDate(Date.valueOf("2000-08-11"));
        employeeBo.setGender("M");

        Employee employee=employeeMapper.employeeBoToEmployee(employeeBo);
        assertEquals(employee.getName(),employeeBo.getName());
        assertEquals(employee.getGender(),employeeBo.getGender());
        assertEquals(employee.getDate(),employeeBo.getDate());

    }
}
