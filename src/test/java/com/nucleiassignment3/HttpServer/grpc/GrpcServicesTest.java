package com.nucleiassignment3.HttpServer.grpc;

import com.mysql_crud.grpc.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GrpcServicesTest {

    @Test
    void createEmployeeTest()
    {
        ManagedChannel channel= ManagedChannelBuilder.forAddress("localhost",8080)
                .usePlaintext()
                .build();
        EmployeesServiceGrpc.EmployeesServiceBlockingStub stub=EmployeesServiceGrpc.newBlockingStub(channel);
        CreateEmployeeResponse employeeResponse=stub.createEmployee(CreateEmployeeRequest.newBuilder()
                .setEmployee(Employee.newBuilder()
                        .setName("Sarath")
                        .setGender("M")
                        .setDob(Date.newBuilder().setDay(21).setMonth(12).setYear(2007).build())
                        .build())
                .build());
        assertEquals("Sarath",employeeResponse.getEmployee().getName());
        assertEquals("M",employeeResponse.getEmployee().getGender());
        assertEquals(21,employeeResponse.getEmployee().getDob().getDay());
        assertEquals(12,employeeResponse.getEmployee().getDob().getMonth());
        assertEquals(2007,employeeResponse.getEmployee().getDob().getYear());
        channel.shutdown();
    }

    @Test
    void getEmployeeTest() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();
        EmployeesServiceGrpc.EmployeesServiceBlockingStub stub = EmployeesServiceGrpc.newBlockingStub(channel);
        GetEmployeeResponse getEmployeeResponse = stub.getEmployee(GetEmployeeRequest
                .newBuilder()
                .setId("GN-ZVC95SR2KDNB70WVALZRZ")
                .build());
        assertEquals("GN-ZVC95SR2KDNB70WVALZRZ", getEmployeeResponse.getEmployee().getId());
        assertEquals("Pradahan",getEmployeeResponse.getEmployee().getName());
        assertEquals("M",getEmployeeResponse.getEmployee().getGender());
        assertEquals(11,getEmployeeResponse.getEmployee().getDob().getDay());
        assertEquals(6,getEmployeeResponse.getEmployee().getDob().getMonth());
        assertEquals(2000,getEmployeeResponse.getEmployee().getDob().getYear());
        channel.shutdown();
    }
    @Test
    void updateEmployee(){
        ManagedChannel managedChannel=ManagedChannelBuilder.forAddress("localhost",8080)
                .usePlaintext()
                .build();
        EmployeesServiceGrpc.EmployeesServiceBlockingStub stub=EmployeesServiceGrpc.newBlockingStub(managedChannel);
        UpdateEmployeeResponse updateEmployeeResponse=stub.updateEmployee(UpdateEmployeeRequest.newBuilder()
                .setEmployee(Employee.newBuilder().setId("GN-ZVC95SR2KDNB70WVALZRZ").setName("RamPrasad").setDob(Date.newBuilder().setDay(11).setMonth(8).setYear(2000).build()).setGender("M").build())
                .build());
        assertEquals("GN-ZVC95SR2KDNB70WVALZRZ", updateEmployeeResponse.getEmployee().getId());
        assertEquals("RamPrasad",updateEmployeeResponse.getEmployee().getName());
        assertEquals("M",updateEmployeeResponse.getEmployee().getGender());
        assertEquals(11,updateEmployeeResponse.getEmployee().getDob().getDay());
        assertEquals(8,updateEmployeeResponse.getEmployee().getDob().getMonth());
        assertEquals(2000,updateEmployeeResponse.getEmployee().getDob().getYear());
        managedChannel.shutdown();
    }
    @Test
    void listEmployees()
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
        assertEquals(2,listEmployeesResponse.getEmployeesList().size());
        channel.shutdown();
    }
}
