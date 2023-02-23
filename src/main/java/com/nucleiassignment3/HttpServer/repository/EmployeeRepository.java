package com.nucleiassignment3.HttpServer.repository;

import com.nucleiassignment3.HttpServer.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,String> {
    Employee findByempId(String id);
    @Transactional
    void deleteByempId(String id);
}
