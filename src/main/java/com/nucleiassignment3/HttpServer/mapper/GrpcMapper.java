package com.nucleiassignment3.HttpServer.mapper;

import com.mysql_crud.grpc.CreateEmployeeRequest;
import com.mysql_crud.grpc.Date;
import com.mysql_crud.grpc.Employee;
import com.nucleiassignment3.HttpServer.bo.EmployeeBo;
import com.nucleiassignment3.HttpServer.model.UpdateEmployeeRequest;
import java.util.Calendar;
import org.jetbrains.annotations.NotNull;

/**
 * Maps Proto Objects To Repository Entities, Request Models and Vice-Versa.
 */
public class GrpcMapper {
  /**
   * Maps EmployeeBO to proto object.
   */
  public static Employee boToProto(@NotNull EmployeeBo employeeBo) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(employeeBo.getDob());
    Employee employee = Employee.newBuilder()
        .setName(employeeBo.getName())
        .setGender(employeeBo.getGender())
        .setId(employeeBo.getEmpId())
        .setDob(Date.newBuilder()
            .setDay(calendar.get(calendar.DAY_OF_MONTH))
            .setMonth(calendar.get(calendar.MONTH) + 1)
            .setYear(calendar.get(calendar.YEAR))
            .build())
        .build();
    return employee;
  }

  /**
   * Maps Proto Create Employee Request to Model Create Employee Request.
   */
  public static com.nucleiassignment3.HttpServer.model.CreateEmployeeRequest employeeRequest(
      CreateEmployeeRequest request) {
    com.nucleiassignment3.HttpServer.model.CreateEmployeeRequest createEmployeeRequest =
        new com.nucleiassignment3.HttpServer.model.CreateEmployeeRequest();
    createEmployeeRequest.setName(request.getEmployee().getName());
    com.mysql_crud.grpc.Date dob = request.getEmployee().getDob();
    createEmployeeRequest.setDob(java.sql.Date.valueOf(
        String.valueOf(dob.getYear()) + "-" + String.valueOf(dob.getMonth()) + "-"
            + String.valueOf(dob.getDay())));
    createEmployeeRequest.setGender(request.getEmployee().getGender());
    return createEmployeeRequest;
  }

  /**
   * Maps Proto Update Employee Request to Model Update Employee Request.
   */
  public static UpdateEmployeeRequest updateEmployeeRequest(
      com.mysql_crud.grpc.UpdateEmployeeRequest updateEmployeeRequest) {
    UpdateEmployeeRequest request = new UpdateEmployeeRequest();
    request.setName(updateEmployeeRequest.getEmployee().getName());
    request.setGender(updateEmployeeRequest.getEmployee().getGender());
    com.mysql_crud.grpc.Date dob = updateEmployeeRequest.getEmployee().getDob();
    request.setDob((java.sql.Date.valueOf(
        String.valueOf(dob.getYear()) + "-" + String.valueOf(dob.getMonth()) + "-"
            + String.valueOf(dob.getDay()))));
    return request;
  }
}
