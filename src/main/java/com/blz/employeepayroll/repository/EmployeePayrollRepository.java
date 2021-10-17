package com.blz.employeepayroll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.blz.employeepayroll.model.EmployeePayrollData;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData, Integer>{
	
	@Query(value = "select * from employee_payroll, employee_depaartment where id = dep_id and department = :department", nativeQuery = true)
	List<EmployeePayrollData> findEmployeesByDepartment(String department);
}
