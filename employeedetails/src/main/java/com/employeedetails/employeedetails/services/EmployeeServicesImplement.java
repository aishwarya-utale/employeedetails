package com.employeedetails.employeedetails.services;

//import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeedetails.employeedetails.dao.EmployeeDao;
import com.employeedetails.employeedetails.entities.Employee;


@Service
public class EmployeeServicesImplement implements EmployeeServices{
	@Autowired
	private EmployeeDao empDao;
	
	//List<Employee> list;
	
	//public EmployeeServicesImplement() {
//		list = new ArrayList<>();
//		list.add(new Employee(101 ,"Aishwarya Utale","Computer Science"));
//		list.add(new Employee(102 ,"Divya ","Java Developer"));
//		list.add(new Employee(103 ,"Suhas","HOD"));
		
	//}

//	@Override
//	public List<Employee> getEmployees() {
//		// TODO Auto-generated method stub
//		return list;
//	}

//	@Override
//	public Employee getEmployee(long employeeID) {
//		Employee emp = null;
//		for(Employee employee : list) {
//			if(employee.getId()==employeeID) {
//				emp = employee;
//			}
//		}
//		return emp;
//	}

	
//	@Override
//	public Employee addEmployee(Employee employee) {
//		list.add(employee);
//		return employee;
//	}

//	@Override
//	public Employee updateEmployee(Employee employee) {
//		list.forEach(e  -> {
//			if(e.getId() == employee.getId()) {
//		e.setName(employee.getName());
//		e.setDepartmentName(employee.getDepartmentName());
//			}
//			});
//		
//
//			return employee;
//	}

//	@Override
//	public void deleteEmployee(Long employeeID) {
//		list = list.stream().filter(employee -> employee.getId()!= employeeID ).collect(Collectors.toList());
//		
//	}

	// Mysql Configuration
	
	//get all emp
	
//	@Override
//	public List<Employee> getEmployees(long employeeId) {
//		Employee employee = empDao.findById(employeeId).orElse(null);
//		if(employee != null&&employee.isDeleted()==0) {
//            return (List<Employee>) employee;
//			
//		}
//		return null;
//	}

//	@Override
//	public Employee getEmployee(long employeeID) {
//		return empDao.getOne(employeeID);
//	}

//	@Override
//	public Employee addEmployee(Employee employee) {
//		
//		 empDao.save(employee);
//		 return employee;
//	}

	@Override
	public Employee updateEmployee(Employee employee) {
		
		empDao.save(employee);
		 return employee;
	}

	@Override
	public Employee softDeleteEmployee(Long employeeId) {
		//Optional<Employee> employee = empDao.findById(employeeId);
		//Employee emp1 = employee.get();
//     if (emp1 != null) {         
//    	 emp1.setDeleted(1);
//    	 return emp1;
//          
//      }
//		return null;
		Employee employee = empDao.findById(employeeId).orElse(null);
            if (employee != null) {
                    employee.setDeleted(1);
                empDao.save(employee);
          
      }
		return employee;
	}

	@Override
	public List<Employee> getActiveEmployee() {
//		List<Employee> emp = empDao.findAll();
//		for(Employee n : emp) {
//			if(n.is_deleted() == emp.)
//		}
		List<Employee> emp = empDao.findEmployeeByIsDeleted(0);
		return emp;
	
		 
		
	}

	@Override
	public List<Employee> getActiveEmployeeByName(String name) {
		// TODO Auto-generated method stub
		List<Employee> emp2 = empDao.findEmployeeByNameAndIsDeleted(name, 0);
		return emp2;
	}
		

//	@Override
//	public void deleteEmployee(Long employeeID) {
//		// TODO Auto-generated method stub
//		Employee entity = empDao.getOne(employeeID);
//		empDao.delete(entity);
//		
//	}

//	@Override
//	public Employee softDeleteEmployee(Long employeeId) {
//		Employee employee = empDao.findById(employeeId).orElse(null);
//        if (employee != null) {
//            employee.setDeleted(true);
//            empDao.save(employee);
//            
//        }
//		return employee;
//    }
		
	}

	
	


