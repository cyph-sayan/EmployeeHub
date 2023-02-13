package com.nucleiassignment3.HttpServer.mapper;

import com.nucleiassignment3.HttpServer.bo.EmployeeBo;
import com.nucleiassignment3.HttpServer.entity.Employee;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    List<EmployeeBo> listEntityToListBo(List<Employee> employees);
    EmployeeBo entityToBo(Employee employee);
    Employee boToEntity(EmployeeBo employeeBo);

}
