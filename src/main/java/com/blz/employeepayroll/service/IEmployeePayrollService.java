package com.blz.employeepayroll.service;

import java.util.List;

import com.blz.employeepayroll.dto.EmployeeDTO;
import com.blz.employeepayroll.model.EmployeePayrollData;

public interface IEmployeePayrollService {

	List<EmployeePayrollData> getEmployeePayrollData();

	EmployeePayrollData getEmployeePayrollDataById(int id);

	EmployeePayrollData createEmployeePayrollData(EmployeeDTO employeeDTO);

	EmployeePayrollData updateEmployeePayrollData(int id, EmployeeDTO employeeDTO);

	void deleteEmployeePayrollData(int id);
}
