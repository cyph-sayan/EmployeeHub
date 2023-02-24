package com.nucleiassignment3.HttpServer;

import com.mysql_crud.grpc.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void createEmployee()
    {
        ManagedChannel channel= ManagedChannelBuilder.forAddress("localhost",8080)
                .usePlaintext()
                .build();
        EmployeesServiceGrpc.EmployeesServiceBlockingStub stub=EmployeesServiceGrpc.newBlockingStub(channel);
        CreateEmployeeResponse employeeResponse=stub.createEmployee(CreateEmployeeRequest.newBuilder()
                        .setEmployee(Employee.newBuilder()
                                .setName("Pradahan")
                                .setGender("M")
                                .setDob(Date.newBuilder().setDay(11).setMonth(6).setYear(2000).build())
                                .build())
                                .build());
        System.out.println(employeeResponse);
        channel.shutdown();
    }
    public static void getEmployee()
    {
        ManagedChannel channel= ManagedChannelBuilder.forAddress("localhost",8080)
                .usePlaintext()
                .build();
        EmployeesServiceGrpc.EmployeesServiceBlockingStub stub=EmployeesServiceGrpc.newBlockingStub(channel);
        GetEmployeeResponse getEmployeeResponse=stub.getEmployee(GetEmployeeRequest
                .newBuilder()
                .setId("GN-ZVC95SR2KDNB70WVALZRZ")
                .build());
        System.out.println(getEmployeeResponse);
        channel.shutdown();
    }
    public static void listEmployees()
    {
        ManagedChannel channel= ManagedChannelBuilder.forAddress("localhost",8080)
                .usePlaintext()
                .build();
        EmployeesServiceGrpc.EmployeesServiceBlockingStub stub=EmployeesServiceGrpc.newBlockingStub(channel);
        ListEmployeesResponse listEmployeesResponse=stub.listEmployees(ListEmployeesRequest
                .newBuilder()
                .setPageNumber(0)
                .setPageSize(10)
                .build());
        System.out.println(listEmployeesResponse);
        channel.shutdown();
    }
    public static void updateEmployee(){
        ManagedChannel managedChannel=ManagedChannelBuilder.forAddress("localhost",8080)
                .usePlaintext()
                .build();
        EmployeesServiceGrpc.EmployeesServiceBlockingStub stub=EmployeesServiceGrpc.newBlockingStub(managedChannel);
        UpdateEmployeeResponse updateEmployeeResponse=stub.updateEmployee(UpdateEmployeeRequest.newBuilder()
                        .setEmployee(Employee.newBuilder().setId("GN-1XRDE9RYBJ4DVP9BBD04A").setName("RamPrasad").setDob(Date.newBuilder().setDay(11).setMonth(8).setYear(2000).build()).setGender("M").build())
                .build());
        System.out.println(updateEmployeeResponse);
        managedChannel.shutdown();
    }
    public static void deleteEmployee()
    {
        ManagedChannel managedChannel=ManagedChannelBuilder.forAddress("localhost",8080)
                .usePlaintext()
                .build();
        EmployeesServiceGrpc.EmployeesServiceBlockingStub stub=EmployeesServiceGrpc.newBlockingStub(managedChannel);
        stub.deleteEmployee(DeleteEmployeeRequest.newBuilder()
                .setId("GN-F3QG2W081KPOUIEDZEQC6")
                .build());
        managedChannel.shutdown();
    }
    public static void main(String[] args) {
//        GrpcClient.createEmployee();
          GrpcClient.getEmployee();
//        GrpcClient.listEmployees();
//        GrpcClient.deleteEmployee();
//        GrpcClient.updateEmployee();
    }
}
