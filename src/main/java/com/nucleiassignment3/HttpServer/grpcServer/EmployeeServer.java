//package com.nucleiassignment3.HttpServer.grpcServer;
//import com.nucleiassignment3.HttpServer.entity.Employee;
//import com.nucleiassignment3.HttpServer.grpc.EmployeeGrpcImpl;
//import io.grpc.Server;
//import io.grpc.ServerBuilder;
//import java.util.logging.Logger;
//import java.io.IOException;
//import java.util.logging.Level;
//
//public class EmployeeServer {
//
//    private static final Logger logger = Logger.getLogger(Employee.class.getName());
//
//    public static void main(String[] args) {
//        Server server = ServerBuilder.forPort(8080)
//                .addService(new EmployeeGrpcImpl())
//                .build();
//        try {
//            server.start();
//            logger.log(Level.INFO, "RESULT SERVER STARTED ON PORT 8080");
//            server.awaitTermination();
//        } catch (IOException e) {
//            logger.log(Level.SEVERE, "RESULT SERVER DID NOT START");
//        } catch (InterruptedException e) {
//            logger.log(Level.SEVERE, "SERVER SHUT DOWN ON INTERRUPTED");
//        }
//    }
//}
