//package com.nucleiassignment3.HttpServer.grpc;
//import com.mysql_crud.grpc.CreateEmployeeRequest;
//import com.mysql_crud.grpc.Employee;
//import com.mysql_crud.grpc.MySqlCrudServiceGrpc;
//import com.nucleiassignment3.HttpServer.service.EmployeeService;
//import io.grpc.stub.StreamObserver;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class GrpcController extends MySqlCrudServiceGrpc.MySqlCrudServiceImplBase {
//
//    @Autowired
//    EmployeeService employeeService;
//
//    @Override
//    public void createEmployee(CreateEmployeeRequest request, StreamObserver<Employee> employeeStreamObserver){
//        employeeService.createEmployee();
//    }
//}
