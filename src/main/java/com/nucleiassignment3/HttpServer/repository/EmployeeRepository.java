package com.nucleiassignment3.HttpServer.repository;

import com.nucleiassignment3.HttpServer.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}