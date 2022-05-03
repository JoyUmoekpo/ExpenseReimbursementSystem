package com.joy.ers.dao;

import java.util.List;

import com.joy.ers.entities.Employee;

public interface EmployeeDAO {
	Employee login(Employee employeeObject);

	List<Employee> getAllEmployees();

	List<Employee> getEmployeeById(int Emp);
}
