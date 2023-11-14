package com.employeedetails.employeedetails.services;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.employeedetails.employeedetails.entities.Employee;


public interface EmployeeServices {
	
	//public List<Employee> getEmployees(long employeeId);
	
	public List<Employee> getActiveEmployee();
	
	public List<Employee> getActiveEmployeeByName(String name);
	//public Employee getEmployee(long employeeID);

	
  // public Employee addEmployee(Employee employee);
   
   public Employee updateEmployee( Employee employee);
   
   //public void deleteEmployee(  Long employeeID);
   
   public Employee softDeleteEmployee(Long employeeId);
}
