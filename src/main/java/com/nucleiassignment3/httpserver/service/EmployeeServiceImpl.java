package com.nucleiassignment3.httpserver.service;

import com.nucleiassignment3.httpserver.bo.EmployeeBo;
import com.nucleiassignment3.httpserver.dao.EmployeeDao;
import com.nucleiassignment3.httpserver.mapper.EmployeeMapper;
import com.nucleiassignment3.httpserver.model.CreateEmployeeRequest;
import com.nucleiassignment3.httpserver.model.UpdateEmployeeRequest;
import com.nucleiassignment3.httpserver.utility.IdGenerator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  EmployeeMapper employeeMapper;
  @Autowired
  EmployeeDao employeeDao;

  @Override
  public EmployeeBo createEmployee(final CreateEmployeeRequest createEmployeeRequest) {
    final EmployeeBo employeeBo =
        employeeMapper.createRequestToBo(createEmployeeRequest, IdGenerator.generateEmployeeId());
    return employeeDao.createEmployee(employeeBo);
  }

  @Override
  public EmployeeBo getEmployee(final String id) {
    return employeeDao.getEmployee(id);
  }

  @Override
  public List<EmployeeBo> listEmployees(final int pageSize, final int pageNumber) {
    return employeeDao.listEmployees(pageSize, pageNumber);
  }

  @Override
  public EmployeeBo updateEmployee(final String id, final UpdateEmployeeRequest request) {
    return employeeDao.updateEmployee(id, request);
  }

  @Override
  public void deleteEmployee(final String id) {
    employeeDao.deleteEmployee(id);
  }

}
