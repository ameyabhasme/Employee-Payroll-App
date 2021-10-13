package com.blz.employeepayroll.dto;

public class EmployeeDTO {
	
	public String name;
	public String tech;
	public long salary;
	
	public EmployeeDTO(String name, String tech, long salary) {
		this.name = name;
		this.tech = tech;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [name=" + name + ", tech=" + tech + ", salary=" + salary + "]";
	}
	
	
}
