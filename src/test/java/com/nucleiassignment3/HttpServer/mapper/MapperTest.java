package com.nucleiassignment3.HttpServer.mapper;

import com.nucleiassignment3.HttpServer.bo.EmployeeBo;
import com.nucleiassignment3.HttpServer.dao.EmployeeDao;
import com.nucleiassignment3.HttpServer.dao.EmployeeDaoImpl;
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
    @Test
    void createEmployee() {
        EmployeeDao employeeDao=new EmployeeDaoImpl();
        Employee employee=new Employee();
        employee.setEmp_id(24);
        employee.setName("Ricky");
        employee.setGender("M");
        employee.setDate(Date.valueOf("2000-08-11"));
        Employee employee1=employeeDao.createEmployee(new EmployeeBo(24,"Ricky",Date.valueOf("2000-08-11"),"M"));
        assertEquals(employee.getEmp_id(),employee1.getEmp_id());
        assertEquals(employee.getName(),employee1.getName());
        assertEquals(employee.getDate(),employee1.getDate());
        assertEquals(employee.getGender(),employee1.getGender());
    }
}
