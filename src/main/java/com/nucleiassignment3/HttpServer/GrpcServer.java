package com.nucleiassignment3.HttpServer;

import com.nucleiassignment3.HttpServer.grpc.EmployeeGrpcImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;

public class GrpcServer {
    public static void main(String[] args) {
        Server server= ServerBuilder.forPort(8080).addService(new EmployeeGrpcImpl())
                .addService(ProtoReflectionService.newInstance())
                .build();
        try{
            server.start();
            server.awaitTermination();
        }catch (Exception e)
        {
            System.out.println("****");
        }
    }
}
