package com.nucleiassignment3.HttpServer.dao;

import com.nucleiassignment3.HttpServer.bo.EmployeeBo;
import com.nucleiassignment3.HttpServer.entity.Employee;
import com.nucleiassignment3.HttpServer.mapper.EmployeeMapper;
import com.nucleiassignment3.HttpServer.model.UpdateEmployeeRequest;
import com.nucleiassignment3.HttpServer.repository.EmployeeRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    private EmployeeMapper employeeMapper= Mappers.getMapper(EmployeeMapper.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeBo createEmployee(EmployeeBo employeeBo)
    {

        return employeeMapper.entityToBo(employeeRepository.save(employeeMapper.boToEntity(employeeBo)));
    }

    @Override
    public EmployeeBo getEmployee(String id)
    {
        return employeeMapper.entityToBo(employeeRepository.findById(id).orElse(null));
    }

    @Override
    public List<EmployeeBo> listEmployees(int pageSize, int pageNumber)
    {
        Pageable pageable=PageRequest.of(pageNumber,pageSize);
        return employeeMapper.listEntityToListBo(employeeRepository.findAll(pageable).getContent());
    }

    @Override
    public EmployeeBo updateEmployee(String  id, UpdateEmployeeRequest updateEmployeeRequest)
    {
          Optional<Employee> optionalEmployee=employeeRepository.findById(id);
          Employee employee=optionalEmployee.get();
          employee=employeeMapper.updateRequestToEntity(updateEmployeeRequest);
          return employeeMapper.entityToBo(employeeRepository.save(employee));
    }

    @Override
    public void deleteEmployee(String id)
    {
        employeeRepository.deleteById(id);
    }
}
