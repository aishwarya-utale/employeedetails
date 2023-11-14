package com.employeedetails.employeedetails.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
	@Id
	private long id ;
	private String name;
	private String departmentName;
	
	@Column(name="is_deleted")
	private int isDeleted = 0;
	
	
	
	public int isDeleted() {
		return isDeleted;
	}


	public void setDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}


	public Employee(long id, String name, String departmentName) {
		super();
		this.id = id;
		this.name = name;
		this.departmentName = departmentName;
	}


	public Employee(int isDeleted) {
		super();
		this.isDeleted = isDeleted;
	}


	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", departmentName=" + departmentName + "]";
	}
	
	

}
