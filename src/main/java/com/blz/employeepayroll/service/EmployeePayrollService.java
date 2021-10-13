package com.blz.employeepayroll.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.blz.employeepayroll.dto.EmployeeDTO;
import com.blz.employeepayroll.model.EmployeePayrollData;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

	private List<EmployeePayrollData> empList = new ArrayList<>();
	
	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		return empList;
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int id) {
		return empList.get(id-1);
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeeDTO employeeDTO) {
		EmployeePayrollData empData = null;
		empData = new EmployeePayrollData(empList.size()+1, employeeDTO);
		empList.add(empData);
		return empData;
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int id, EmployeeDTO employeeDTO) {
		EmployeePayrollData empData = this.getEmployeePayrollDataById(id);
		empData.setName(employeeDTO.name);
		empData.setTech(employeeDTO.tech);
		empData.setSalary(employeeDTO.salary);
		empList.set(id-1, empData);
		return empData;
	}

	@Override
	public void deleteEmployeePayrollData(int id) {
		empList.remove(id-1);
	}

}
