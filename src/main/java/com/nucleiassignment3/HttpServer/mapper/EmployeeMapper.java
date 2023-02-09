package com.nucleiassignment3.HttpServer.mapper;

import com.nucleiassignment3.HttpServer.bo.EmployeeBo;
import com.nucleiassignment3.HttpServer.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeBo employeeToEmployeeBo(Employee employee);
    Employee employeeBoToEmployee(EmployeeBo employeeBo);
}
