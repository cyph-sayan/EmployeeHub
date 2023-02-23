package com.nucleiassignment3.HttpServer.grpc;

import com.google.protobuf.Empty;
import com.mysql_crud.grpc.*;
import com.nucleiassignment3.HttpServer.bo.EmployeeBo;
import com.nucleiassignment3.HttpServer.mapper.ProtoToRequestMapper;
import com.nucleiassignment3.HttpServer.service.EmployeeService;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GRpcService
public class EmployeeGrpcImpl extends EmployeesServiceGrpc.EmployeesServiceImplBase {
    @Autowired
    EmployeeService employeeService;
    @Override
    public void createEmployee(CreateEmployeeRequest request, StreamObserver<CreateEmployeeResponse> responseObserver) {
        EmployeeBo employeeBo=employeeService.createEmployee(ProtoToRequestMapper.employeeRequest(request));
        java.sql.Date dob=employeeBo.getDob();
        CreateEmployeeResponse createEmployeeResponse=CreateEmployeeResponse.newBuilder()
                .setEmployee(Employee.newBuilder()
                        .setId(employeeBo.getEmpId())
                        .setName(employeeBo.getName())
                        .setDob(Date.newBuilder()
                                .setDay(dob.getDay())
                                .setMonth(dob.getMonth())
                                .setYear(dob.getYear())
                                .build())
                        .setGender(employeeBo.getGender())
                        .build())
                .build();
        responseObserver.onNext(createEmployeeResponse);
        responseObserver.onCompleted();
    }
    @Override
    public void getEmployee(GetEmployeeRequest request,StreamObserver<GetEmployeeResponse> responseObserver){
        EmployeeBo employeeBo=employeeService.getEmployee(request.getId());
        GetEmployeeResponse employeeResponse=GetEmployeeResponse.newBuilder()
                .setEmployee(Employee.newBuilder()
                        .setId(employeeBo.getEmpId())
                        .setName(employeeBo.getName())
                        .setGender(employeeBo.getGender())
                        .setDob(Date.newBuilder()
                                .setDay(employeeBo.getDob().getDay())
                                .setMonth(employeeBo.getDob().getMonth())
                                .setYear(employeeBo.getDob().getYear())
                                .build())
                        .build())
                .build();
        responseObserver.onNext(employeeResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void listEmployees(ListEmployeesRequest request, StreamObserver<ListEmployeesResponse> responseObserver) {
    }

    @Override
    public void updateEmployee(UpdateEmployeeRequest request,StreamObserver<UpdateEmployeeResponse> responseObserver){

    }

    @Override
    public void deleteEmployee(DeleteEmployeeRequest request, StreamObserver<Empty> responseObserver) {
    }

}







