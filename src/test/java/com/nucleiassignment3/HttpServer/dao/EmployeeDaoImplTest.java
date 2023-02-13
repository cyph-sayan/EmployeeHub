package com.nucleiassignment3.HttpServer.dao;

import com.nucleiassignment3.HttpServer.bo.EmployeeBo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.sql.Date;

public class EmployeeDaoImplTest {


        @Test
        void getEmployee() {

            EmployeeDao employeeDao=new EmployeeDaoImpl();
            EmployeeBo employeeBo=new EmployeeBo();
            employeeBo.setName("Sayan");
            employeeBo.setDate(Date.valueOf("2000-08-11"));
            employeeBo.setGender("M");
            employeeBo.setEmp_id(123);
            EmployeeBo actualEmployeeBo=employeeDao.createEmployee(employeeBo);
            Assertions.assertEquals(employeeBo.getName(),actualEmployeeBo.getName());
            Assertions.assertEquals(employeeBo.getDate(),actualEmployeeBo.getDate());
            Assertions.assertEquals(employeeBo.getGender(),actualEmployeeBo.getGender());
            Assertions.assertEquals(employeeBo.getEmp_id(),actualEmployeeBo.getEmp_id());

        }
    }
