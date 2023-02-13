package com.nucleiassignment3.HttpServer.service;

import com.nucleiassignment3.HttpServer.bo.EmployeeBo;
import com.nucleiassignment3.HttpServer.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService
{

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public EmployeeBo createEmployee(EmployeeBo employeeBo)
    {
        return employeeDao.createEmployee(employeeBo);
    }

    @Override
    public EmployeeBo getEmployee(int id)
    {
        return employeeDao.getEmployee(id);
    }

    @Override
    public List<EmployeeBo> listEmployees(int pageSize, int pageNumber)
    {
        return employeeDao.listEmployees(pageSize,pageNumber);
    }

    @Override
    public EmployeeBo updateEmployee(int id,EmployeeBo employeeBo)
    {
        return employeeDao.updateEmployee(id,employeeBo);
    }

    @Override
    public void deleteEmployee(int id)
    {
        employeeDao.deleteEmployee(id);
    }

}
