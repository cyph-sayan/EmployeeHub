package com.nucleiassignment3.HttpServer.controller;
import com.nucleiassignment3.HttpServer.bo.EmployeeBo;
import com.nucleiassignment3.HttpServer.entity.Employee;
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

    @PostMapping("/Employee")
    public Employee addEmployee(@RequestBody EmployeeBo employeeBo){
        return  employeeService.createEmployee(employeeBo);
    }

    @PutMapping("/Employee/{id}")
    public Employee updateEmployee(@PathVariable int id,@RequestBody EmployeeBo employeeBo)
    {
        return employeeService.updateEmployee(id,employeeBo);
    }

    @GetMapping("/Employees")
    public List<Employee> listEmployees(){
        return employeeService.listEmployees();
    }

    @GetMapping("/Employee/{id}")
    public Employee getEmployee(@PathVariable int id)
    {
        return employeeService.getEmployee(id);
    }

    @DeleteMapping("/Employee/{id}")
    public void deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
    }


}
