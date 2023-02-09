package com.nucleiassignment3.HttpServer;

import com.nucleiassignment3.HttpServer.bo.EmployeeBo;
import com.nucleiassignment3.HttpServer.entity.Employee;
import com.nucleiassignment3.HttpServer.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;

@SpringBootTest
class HttpServerApplicationTests {

	private EmployeeMapper employeeMapper= Mappers.getMapper(EmployeeMapper.class);
	@Test
	void contextLoads() {
	}

	@Test
	void testMapper(){
		Employee employee=new Employee();
		employee.setName("Sayan");
		employee.setDate(Date.valueOf("2000-08-11"));
		employee.setGender("M");

		EmployeeBo employeeBo=employeeMapper.employeeToEmployeeBo(employee);
		assertEquals(employee.getName(), employeeBo.getName());
	}

}
