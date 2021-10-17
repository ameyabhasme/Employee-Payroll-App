package com.blz.employeepayroll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blz.employeepayroll.dto.EmployeeDTO;
import com.blz.employeepayroll.exceptions.CustomExceptions;
import com.blz.employeepayroll.model.EmployeePayrollData;
import com.blz.employeepayroll.repository.EmployeePayrollRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService {

	@Autowired
	private EmployeePayrollRepository employeeRepository;
	
	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		return employeeRepository.findAll();
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int id) {
		return employeeRepository.findById(id).orElseThrow(() ->  new CustomExceptions("Employee with Id: " + id + " does not exists"));
	}

	@Override
	public List<EmployeePayrollData> getEmployeesByDepartment(String department) {
		return employeeRepository.findEmployeesByDepartment(department);
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeeDTO employeeDTO) {
		EmployeePayrollData empData = null;
		empData = new EmployeePayrollData(employeeDTO);
		log.debug("Emp data: "+ empData.toString());
		return employeeRepository.save(empData);
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int id, EmployeeDTO employeeDTO) {
		EmployeePayrollData empData = this.getEmployeePayrollDataById(id);
		empData.updateEmployeePayrollData(employeeDTO);
		return employeeRepository.save(empData);
	}

	@Override
	public void deleteEmployeePayrollData(int id) {
		EmployeePayrollData empData = this.getEmployeePayrollDataById(id);
		employeeRepository.delete(empData);
	}

}
