package com.nucleiassignment3.HttpServer.grpc;

import com.mysql_crud.grpc.CreateEmployeeRequest;
import com.mysql_crud.grpc.CreateEmployeeResponse;
import com.mysql_crud.grpc.Date;
import com.mysql_crud.grpc.Employee;
import com.mysql_crud.grpc.EmployeesServiceGrpc.EmployeesServiceImplBase;
import com.mysql_crud.grpc.GetEmployeeRequest;
import com.mysql_crud.grpc.GetEmployeeResponse;
import com.nucleiassignment3.HttpServer.bo.EmployeeBo;
import com.nucleiassignment3.HttpServer.mapper.ProtoToRequestMapper;
import com.nucleiassignment3.HttpServer.repository.EmployeeRepository;
import com.nucleiassignment3.HttpServer.service.EmployeeService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class EmployeeGrpcImpl extends EmployeesServiceImplBase{
    @Autowired
    EmployeeService employeeService;
    @Autowired
    private EmployeeRepository employeeRepository;

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

}
