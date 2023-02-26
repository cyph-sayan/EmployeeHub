package com.nucleiassignment3.HttpServer.grpc;

import com.google.protobuf.Empty;
import com.mysql_crud.grpc.CreateEmployeeRequest;
import com.mysql_crud.grpc.CreateEmployeeResponse;
import com.mysql_crud.grpc.DeleteEmployeeRequest;
import com.mysql_crud.grpc.Employee;
import com.mysql_crud.grpc.EmployeesServiceGrpc;
import com.mysql_crud.grpc.GetEmployeeRequest;
import com.mysql_crud.grpc.GetEmployeeResponse;
import com.mysql_crud.grpc.ListEmployeesRequest;
import com.mysql_crud.grpc.ListEmployeesResponse;
import com.mysql_crud.grpc.UpdateEmployeeRequest;
import com.mysql_crud.grpc.UpdateEmployeeResponse;
import com.nucleiassignment3.HttpServer.bo.EmployeeBo;
import com.nucleiassignment3.HttpServer.mapper.GrpcMapper;
import com.nucleiassignment3.HttpServer.service.EmployeeService;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GRpcService
public class EmployeeGrpcImpl extends EmployeesServiceGrpc.EmployeesServiceImplBase {
  @Autowired
  EmployeeService employeeService;

  @Override
  public void createEmployee(CreateEmployeeRequest request,
                             StreamObserver<CreateEmployeeResponse> responseObserver) {
    EmployeeBo employeeBo = employeeService.createEmployee(GrpcMapper.employeeRequest(request));
    CreateEmployeeResponse createEmployeeResponse = CreateEmployeeResponse.newBuilder()
        .setEmployee(GrpcMapper.boToProto(employeeBo))
        .build();
    responseObserver.onNext(createEmployeeResponse);
    responseObserver.onCompleted();
  }

  @Override
  public void getEmployee(GetEmployeeRequest request,
                          StreamObserver<GetEmployeeResponse> responseObserver) {
    EmployeeBo employeeBo = employeeService.getEmployee(request.getId());
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(employeeBo.getDob());
    GetEmployeeResponse employeeResponse = GetEmployeeResponse.newBuilder()
        .setEmployee(GrpcMapper.boToProto(employeeBo))
        .build();
    responseObserver.onNext(employeeResponse);
    responseObserver.onCompleted();
  }

  @Override
  public void listEmployees(ListEmployeesRequest request,
                            StreamObserver<ListEmployeesResponse> responseObserver) {
    int pageNumber = (request.getPageNumber() == 0) ? 0 : request.getPageNumber();
    int pageSize = (request.getPageSize() == 0) ? 10 : request.getPageSize();
    List<EmployeeBo> employeeBoList =
        employeeService.listEmployees(pageSize, pageNumber);
    List<Employee> employees = new ArrayList<>();
    for (EmployeeBo employeeBo : employeeBoList) {
      employees.add(GrpcMapper.boToProto(employeeBo));
    }
    ListEmployeesResponse listEmployeesResponse = ListEmployeesResponse.newBuilder()
        .addAllEmployees(employees)
        .build();
    responseObserver.onNext(listEmployeesResponse);
    responseObserver.onCompleted();
  }

  @Override
  public void updateEmployee(UpdateEmployeeRequest request,
                             StreamObserver<UpdateEmployeeResponse> responseObserver) {
    EmployeeBo employeeBo = employeeService.updateEmployee(request.getEmployee().getId(),
        GrpcMapper.updateEmployeeRequest(request));
    UpdateEmployeeResponse updateEmployeeResponse = UpdateEmployeeResponse.newBuilder()
        .setEmployee(GrpcMapper.boToProto(employeeBo))
        .build();
    responseObserver.onNext(updateEmployeeResponse);
    responseObserver.onCompleted();
  }

  @Override
  public void deleteEmployee(DeleteEmployeeRequest request,
                             StreamObserver<Empty> responseObserver) {
    employeeService.deleteEmployee(request.getId());
    responseObserver.onNext(Empty.newBuilder().build());
    responseObserver.onCompleted();
  }

}







