package com.nucleiassignment3.HttpServer.mapper;

import com.mysql_crud.grpc.CreateEmployeeRequest;
import com.nucleiassignment3.HttpServer.bo.EmployeeBo;
import com.nucleiassignment3.HttpServer.utility.IdGenerator;

import java.sql.Date;

public class ProtoToRequestMapper {
    public static com.nucleiassignment3.HttpServer.model.CreateEmployeeRequest employeeRequest(CreateEmployeeRequest request){
        com.nucleiassignment3.HttpServer.model.CreateEmployeeRequest createEmployeeRequest=new com.nucleiassignment3.HttpServer.model.CreateEmployeeRequest();
        createEmployeeRequest.setName(request.getName());
        com.mysql_crud.grpc.Date dob=request.getDob();
        createEmployeeRequest.setDob(Date.valueOf(String.valueOf(dob.getDay())+String.valueOf(dob.getMonth())+String.valueOf(dob.getYear())));
        createEmployeeRequest.setGender(request.getGender());
        return createEmployeeRequest;
    }
}
