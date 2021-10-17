package com.blz.employeepayroll.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blz.employeepayroll.dto.EmployeeDTO;
import com.blz.employeepayroll.dto.ResponseDTO;
import com.blz.employeepayroll.model.EmployeePayrollData;
import com.blz.employeepayroll.service.IEmployeePayrollService;

@RestController
@RequestMapping("/payroll")
public class EmployeePayrollController {

	@Autowired
	private IEmployeePayrollService employeePayollService;

	/**
	 * GET API for getting all the entries in the database/list.
	 * 
	 * @return empDataList List of entries
	 */
	@RequestMapping(value = { " ", "/", "/get" })
	public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
		List<EmployeePayrollData> empDataList = null;
		empDataList = employeePayollService.getEmployeePayrollData();
		ResponseDTO responseDTO = new ResponseDTO("Get call successful", empDataList);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
	
	/**
	 * GET API for one entry by Id
	 * @param id
	 * @return entry by id
	 */
	@GetMapping("/get/{id}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable int id) {
		EmployeePayrollData empData = null;
		empData = employeePayollService.getEmployeePayrollDataById(id);
		ResponseDTO responseDTO = new ResponseDTO("Get call for Id successful", empData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
	
	@GetMapping("/department/{department}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable ("department") String department){
		List<EmployeePayrollData> empDataList = null;
		empDataList = employeePayollService.getEmployeesByDepartment(department);
		ResponseDTO responseDTO = new ResponseDTO("Get call for department successful", empDataList);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);		
	}

	/**
	 * Post API to add a new entry
	 * @param employeeDTO
	 * @return
	 */
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployeePayrolllData(@Valid @RequestBody EmployeeDTO employeeDTO) {
		EmployeePayrollData empData = null;
		empData = employeePayollService.createEmployeePayrollData(employeeDTO);
		ResponseDTO responseDTO = new ResponseDTO("Created successfully", empData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	/**
	 * Update API to update an entry
	 * @param id
	 * @param employeeDTO
	 * @return
	 */
	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> updateEmployeePayrolllData(@Valid @PathVariable("id") int id,
			@RequestBody EmployeeDTO employeeDTO) {
		EmployeePayrollData empData = null;
		empData = employeePayollService.updateEmployeePayrollData(id, employeeDTO);
		ResponseDTO responseDTO = new ResponseDTO("Updated successfully", empData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);

	}

	/**
	 * Delete API to delete by id 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayrolllData(@PathVariable("id") int id) {
		employeePayollService.deleteEmployeePayrollData(id);
		ResponseDTO responseDTO = new ResponseDTO("Deleted successfully", " Deleted Id: " + id);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

}
