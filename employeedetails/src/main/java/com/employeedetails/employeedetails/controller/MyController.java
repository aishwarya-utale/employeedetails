package com.employeedetails.employeedetails.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employeedetails.employeedetails.dao.EmployeeDao;
import com.employeedetails.employeedetails.entities.Employee;
import com.employeedetails.employeedetails.services.EmployeeServices;


@RestController
public class MyController {
	@Autowired
	private EmployeeServices employeeservice;
	@Autowired
	private EmployeeDao empDao;
	
	// hello world 
	
	//i am ashutale 
	
	
	//Get all the Employee Details 
	
	@GetMapping("/active")
	public List<Employee> getActiveEmployee(){
		return this.employeeservice.getActiveEmployee();
		
	}
	@GetMapping("/byname")
	public List<Employee> getActiveEmployeeByName(@RequestParam String name){
		return this.employeeservice.getActiveEmployeeByName(name);
		
	}
	
	@GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long employeeId) {
        Optional<Employee> employee = empDao.findById(employeeId);
        if (employee.isPresent()) {
            return ResponseEntity.ok(employee.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	@PostMapping("/employees")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        // Save the employee to the database
        Employee savedEmployee = empDao.save(employee);

        // Return the saved employee with a 201 Created status
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }
//	
//	//Get the Employee detail based on the ID
//	
//	@GetMapping("/employees/{employeeID}")
//	public Employee getEmployee(@PathVariable("employeeID") String employeeID) {
//		return this.employeeservice.getEmployee(Long.parseLong(employeeID));
//	}
////	
//	//Add the employee 
//	@PostMapping("/employees")
//	public Employee addEmployee(@RequestBody Employee employee) {
//		return this.employeeservice.addEmployee(employee);
//	}
//	
	@PutMapping("/employees")
	public Employee updateCourse(@RequestBody Employee employee){
	return this.employeeservice.updateEmployee(employee);
	}
	
//	@DeleteMapping("/employees/{employeeID}")
//	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String employeeID){
//	try{
//	this.employeeservice.deleteEmployee(Long.parseLong(employeeID));
//	return new ResponseEntity<>(HttpStatus.OK);
//	} catch (Exception e) {
//	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//	}
//	}
	

	@GetMapping("/employees/emp/{employeeId}")
	public Employee softDeleteEmployee(@PathVariable Long employeeId) {
		return  this.employeeservice.softDeleteEmployee(employeeId);
	}
	

}
