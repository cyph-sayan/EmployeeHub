package com.nucleiassignment3.HttpServer.mapper;

import com.nucleiassignment3.HttpServer.bo.EmployeeBo;
import com.nucleiassignment3.HttpServer.entity.Employee;
import com.nucleiassignment3.HttpServer.model.CreateEmployeeRequest;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

  List<EmployeeBo> listEntityToListBo(List<Employee> employees);

  EmployeeBo entityToBo(Employee employee);

  Employee boToEntity(EmployeeBo employeeBo);

  @Mapping(target = "empId", source = "id")
  EmployeeBo createRequestToBo(CreateEmployeeRequest employeeRequest, String id);
}
