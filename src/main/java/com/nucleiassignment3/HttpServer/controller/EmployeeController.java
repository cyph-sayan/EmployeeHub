package com.nucleiassignment3.HttpServer.controller;

import com.nucleiassignment3.HttpServer.bo.EmployeeBo;
import com.nucleiassignment3.HttpServer.entity.Employee;
import com.nucleiassignment3.HttpServer.model.CreateEmployeeRequest;
import com.nucleiassignment3.HttpServer.model.ListPageRequest;
import com.nucleiassignment3.HttpServer.model.UpdateEmployeeRequest;
import com.nucleiassignment3.HttpServer.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    private final Logger LOG = LoggerFactory.getLogger(getClass());
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/employees")
    public EmployeeBo addEmployee(@RequestBody CreateEmployeeRequest createEmployeeRequest){
        return employeeService.createEmployee(createEmployeeRequest);
    }

    @CachePut(value = "employees", key = "#id")
    @PutMapping("/employees/{id}")
    public EmployeeBo updateEmployee(@PathVariable String id,@RequestBody UpdateEmployeeRequest updateEmployeeRequest)
    {
        return employeeService.updateEmployee(id,updateEmployeeRequest);
    }

    @GetMapping("/employees")
    public List<EmployeeBo> listEmployees(@RequestBody ListPageRequest listPageRequest)
    {
        LOG.info("Listing Employees");
        return employeeService.listEmployees(listPageRequest.getPageSize(),listPageRequest.getPageNumber());
    }

    @Cacheable(value = "employees", key="#id")
    @GetMapping("/employees/{id}")
    public EmployeeBo getEmployee(@PathVariable String id)
    {
        LOG.info("Getting User:"+id);
        return employeeService.getEmployee(id);
    }

    @CacheEvict(value = "employees", key="#id")
    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable String id)
    {
         employeeService.deleteEmployee(id);
    }

}
