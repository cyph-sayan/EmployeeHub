package com.nucleiassignment3.HttpServer.mapper;

import com.nucleiassignment3.HttpServer.bo.EmployeeBo;
import com.nucleiassignment3.HttpServer.entity.Employee;
import com.nucleiassignment3.HttpServer.model.CreateEmployeeRequest;
import com.nucleiassignment3.HttpServer.model.UpdateEmployeeRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    List<EmployeeBo> listEntityToListBo(List<Employee> employees);

    EmployeeBo entityToBo(Employee employee);

    Employee boToEntity(EmployeeBo employeeBo);

    @Mapping(target="empId",source = "id")

    EmployeeBo createRequestToBo(CreateEmployeeRequest employeeRequest, String id);

    Employee updateRequestToEntity(UpdateEmployeeRequest employeeRequest);

//    @Mapping(target="empId",source = "id")
//    @Mapping(target="dob", source = "dob", qualifiedByName = "dateConverter")
//    EmployeeBo protoToBo(com.mysql_crud.grpc.CreateEmployeeRequest employeeRequest, String id);
//
//    @Named("dateConverter")
//    public static Date dateConverter(com.mysql_crud.grpc.Date dob){
//        return Date.valueOf(String.valueOf(dob.getDay())+String.valueOf(dob.getMonth())+String.valueOf(dob.getYear()));
//    }

}
