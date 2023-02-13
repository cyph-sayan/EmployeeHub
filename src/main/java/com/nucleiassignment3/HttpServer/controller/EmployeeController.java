package com.nucleiassignment3.HttpServer.controller;

import com.nucleiassignment3.HttpServer.bo.EmployeeBo;
import com.nucleiassignment3.HttpServer.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/employee")
    public EmployeeBo addEmployee(@RequestBody EmployeeBo employeeBo){
        return employeeService.createEmployee(employeeBo);
    }

    @PutMapping("/employee/{id}")
    public EmployeeBo updateEmployee(@PathVariable int id,@RequestBody EmployeeBo employee)
    {
        return employeeService.updateEmployee(id,employee);
    }

    @GetMapping("/employees")
    public List<EmployeeBo> listEmployees(int pageSize, int pageNumber){
        return employeeService.listEmployees(pageSize,pageNumber);
    }

    @GetMapping("/employee/{id}")
    public EmployeeBo getEmployee(@PathVariable int id)
    {
        return employeeService.getEmployee(id);
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable int id){
         employeeService.deleteEmployee(id);
    }

}
