package com.employeedetails.employeedetails.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.employeedetails.employeedetails.entities.Employee;

public interface EmployeeDao extends JpaRepository<Employee,Long>{
	
	List<Employee> findEmployeeByIsDeleted(int isDeleted);
	List<Employee> findEmployeeByNameAndIsDeleted( String name, int isDeleted);
	
	
	
		
	

}
