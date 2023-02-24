package com.nucleiassignment3.HttpServer.service;

import com.nucleiassignment3.HttpServer.bo.EmployeeBo;
import com.nucleiassignment3.HttpServer.dao.EmployeeDao;
import com.nucleiassignment3.HttpServer.entity.Employee;
import com.nucleiassignment3.HttpServer.mapper.EmployeeMapper;
import com.nucleiassignment3.HttpServer.model.CreateEmployeeRequest;
import com.nucleiassignment3.HttpServer.model.UpdateEmployeeRequest;
import com.nucleiassignment3.HttpServer.utility.IdGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    EmployeeDao employeeDao;

    @Override
    public EmployeeBo createEmployee(CreateEmployeeRequest createEmployeeRequest)
    {
        final EmployeeBo employeeBo=employeeMapper.createRequestToBo(createEmployeeRequest,IdGenerator.generateEmployeeId());
        return employeeDao.createEmployee(employeeBo);
    }

    @Cacheable(value = "employees", key="#id")
    @Override
    public EmployeeBo getEmployee(String id)
    {
        return employeeDao.getEmployee(id);
    }

    @Override
    public List<EmployeeBo> listEmployees(int pageSize, int pageNumber)
    {
        return employeeDao.listEmployees(pageSize,pageNumber);
    }

    @CachePut(value = "employees", key = "#id")
    @Override
    public EmployeeBo updateEmployee(String id, UpdateEmployeeRequest updateEmployeeRequest)
    {
        return employeeDao.updateEmployee(id,updateEmployeeRequest);
    }

    @CacheEvict(value = "employees", key="#id")
    @Override
    public void deleteEmployee(String id)
    {
        employeeDao.deleteEmployee(id);
    }

}
