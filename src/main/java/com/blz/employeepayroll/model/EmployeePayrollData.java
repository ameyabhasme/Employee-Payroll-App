package com.blz.employeepayroll.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.blz.employeepayroll.dto.EmployeeDTO;

import lombok.Data;

@Entity
@Table(name = "employee_payroll")
public @Data class EmployeePayrollData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private long salary;
	private String gender;
	private LocalDate startDate;
	private String note;
	private String profilePic;
	
	@ElementCollection
	@CollectionTable(name = "employee_department", joinColumns = @JoinColumn (name = "dep_id"))
	@Column(name = "department")
	private List<String> departments;
	
	public EmployeePayrollData() {}

	public EmployeePayrollData(EmployeeDTO employeeDTO) {
		this.updateEmployeePayrollData(employeeDTO);
	}

	public void updateEmployeePayrollData(EmployeeDTO employeeDTO) {
		this.name = employeeDTO.name;
		this.salary = employeeDTO.salary;
		this.gender = employeeDTO.gender;
		this.startDate = employeeDTO.startDate;
		this.note = employeeDTO.note;
		this.profilePic = employeeDTO.profilePic;
		this.departments = employeeDTO.departments;
	}

}
