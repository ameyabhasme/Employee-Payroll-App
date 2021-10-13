package com.blz.employeepayroll.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.blz.employeepayroll.dto.EmployeeDTO;

public class EmployeePayrollData {
	
	private int id;
	private String name;
	private String tech;
	private long salary;
	
	public EmployeePayrollData(int id, EmployeeDTO employeeDTO) {
		this.id = id;
		this.name = employeeDTO.name;
		this.tech = employeeDTO.tech;
		this.salary = employeeDTO.salary;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getTech() {
		return tech;
	}

	public long getSalary() {
		return salary;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTech(String tech) {
		this.tech = tech;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}
	
	
}
