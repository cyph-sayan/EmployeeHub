package com.nucleiassignment3.HttpServer.grpc;

import com.google.protobuf.Empty;
import com.mysql_crud.grpc.*;
import com.nucleiassignment3.HttpServer.bo.EmployeeBo;
import com.nucleiassignment3.HttpServer.mapper.GrpcMapper;
import com.nucleiassignment3.HttpServer.service.EmployeeService;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@GRpcService
public class EmployeeGrpcImpl extends EmployeesServiceGrpc.EmployeesServiceImplBase {
    @Autowired
    EmployeeService employeeService;
    @Override
    public void createEmployee(CreateEmployeeRequest request, StreamObserver<CreateEmployeeResponse> responseObserver) {
        EmployeeBo employeeBo=employeeService.createEmployee(GrpcMapper.employeeRequest(request));
        CreateEmployeeResponse createEmployeeResponse=CreateEmployeeResponse.newBuilder()
                .setEmployee(GrpcMapper.boToProto(employeeBo))
                .build();
        responseObserver.onNext(createEmployeeResponse);
        responseObserver.onCompleted();
    }
    @Override
    public void getEmployee(GetEmployeeRequest request,StreamObserver<GetEmployeeResponse> responseObserver){
        String id=request.getId();
        EmployeeBo employeeBo=employeeService.getEmployee(request.getId());
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(employeeBo.getDob());
        GetEmployeeResponse employeeResponse=GetEmployeeResponse.newBuilder()
                .setEmployee(GrpcMapper.boToProto(employeeBo))
                .build();
        responseObserver.onNext(employeeResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void listEmployees(ListEmployeesRequest request, StreamObserver<ListEmployeesResponse> responseObserver) {
        List<EmployeeBo> employeeBoList=employeeService.listEmployees(request.getPageSize(),request.getPageNumber());
        List<Employee> employees=new ArrayList<>();
        for(EmployeeBo employeeBo : employeeBoList)
        {
            employees.add(GrpcMapper.boToProto(employeeBo));
        }
        ListEmployeesResponse listEmployeesResponse=ListEmployeesResponse.newBuilder()
                .addAllEmployees(employees)
                .build();
        responseObserver.onNext(listEmployeesResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void updateEmployee(UpdateEmployeeRequest request,StreamObserver<UpdateEmployeeResponse> responseObserver){
        EmployeeBo employeeBo=employeeService.updateEmployee(request.getEmployee().getId(), GrpcMapper.updateEmployeeRequest(request));
        UpdateEmployeeResponse updateEmployeeResponse= UpdateEmployeeResponse.newBuilder()
                .setEmployee(GrpcMapper.boToProto(employeeBo))
                .build();
        responseObserver.onNext(updateEmployeeResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteEmployee(DeleteEmployeeRequest request, StreamObserver<Empty> responseObserver) {
        employeeService.deleteEmployee(request.getId());
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

}







