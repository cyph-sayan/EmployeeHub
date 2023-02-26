package com.nucleiassignment3.HttpServer.dao;

import com.nucleiassignment3.HttpServer.bo.EmployeeBo;
import com.nucleiassignment3.HttpServer.entity.Employee;
import com.nucleiassignment3.HttpServer.mapper.EmployeeMapper;
import com.nucleiassignment3.HttpServer.model.UpdateEmployeeRequest;
import com.nucleiassignment3.HttpServer.repository.EmployeeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

  @Autowired
  private EmployeeMapper employeeMapper;

  @Autowired
  private EmployeeRepository employeeRepository;

  @Override
  public EmployeeBo createEmployee(EmployeeBo employeeBo) {

    return employeeMapper.entityToBo(
        employeeRepository.save(employeeMapper.boToEntity(employeeBo)));
  }

  @Override
  public EmployeeBo getEmployee(String id) {
    return employeeMapper.entityToBo(employeeRepository.findByempId(id));
  }

  @Override
  public List<EmployeeBo> listEmployees(int pageSize, int pageNumber) {
    Pageable pageable = PageRequest.of(pageNumber, pageSize);
    Page<Employee> employees = employeeRepository.findAll(pageable);
    List<Employee> employeeList = employees.getContent();
    return employeeMapper.listEntityToListBo(employeeList);
  }

  @Override
  public EmployeeBo updateEmployee(String id, UpdateEmployeeRequest updateEmployeeRequest) {
    Employee employee = employeeRepository.findByempId(id);
    employee.setName(updateEmployeeRequest.getName());
    employee.setGender(updateEmployeeRequest.getGender());
    employee.setDob(updateEmployeeRequest.getDob());
    return employeeMapper.entityToBo(employeeRepository.save(employee));
  }

  @Override
  public void deleteEmployee(String id) {
    employeeRepository.deleteByempId(id);
  }
}
