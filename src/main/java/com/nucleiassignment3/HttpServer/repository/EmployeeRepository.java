package com.nucleiassignment3.HttpServer.repository;

import com.nucleiassignment3.HttpServer.entity.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,String> {
    Employee findByempId(String id);
    void deleteByempId(String id);
}
