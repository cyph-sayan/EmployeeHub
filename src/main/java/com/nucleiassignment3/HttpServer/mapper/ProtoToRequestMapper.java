package com.nucleiassignment3.HttpServer.mapper;

import com.mysql_crud.grpc.CreateEmployeeRequest;
import java.sql.Date;

public class ProtoToRequestMapper {
    public static com.nucleiassignment3.HttpServer.model.CreateEmployeeRequest employeeRequest(CreateEmployeeRequest request){
        com.nucleiassignment3.HttpServer.model.CreateEmployeeRequest createEmployeeRequest=new com.nucleiassignment3.HttpServer.model.CreateEmployeeRequest();
        createEmployeeRequest.setName(request.getName());
        com.mysql_crud.grpc.Date dob=request.getDob();
        createEmployeeRequest.setDob(Date.valueOf(String.valueOf(dob.getYear())+"-"+String.valueOf(dob.getMonth())+"-"+String.valueOf(dob.getDay())));
        createEmployeeRequest.setGender(request.getGender());
        return createEmployeeRequest;
    }
}
