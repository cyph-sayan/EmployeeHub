package com.nucleiassignment3.HttpServer;

import com.mysql_crud.grpc.CreateEmployeeRequest;
import com.mysql_crud.grpc.CreateEmployeeResponse;
import com.mysql_crud.grpc.Date;
import com.mysql_crud.grpc.EmployeesServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel= ManagedChannelBuilder.forAddress("localhost",8080)
                .usePlaintext()
                .build();
        EmployeesServiceGrpc.EmployeesServiceBlockingStub stub=EmployeesServiceGrpc.newBlockingStub(channel);
        CreateEmployeeResponse employeeResponse=stub.createEmployee(CreateEmployeeRequest.newBuilder()
                .setName("Pradahan")
                .setGender("M")
                .setDob(Date.newBuilder().setDay(11).setMonth(8).setYear(2000).build())
                .build());
        System.out.println(employeeResponse);
        channel.shutdown();
    }
}
