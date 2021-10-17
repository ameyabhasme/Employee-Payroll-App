package com.blz.employeepayroll.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.blz.employeepayroll.dto.ResponseDTO;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
class EmployeePayrolExceptionHandler {
	private static final String message = "Exception while processing REST Request";

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(
			MethodArgumentNotValidException exception) {
		List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
		List<String> errMsg = errorList.stream().map(objErr -> objErr.getDefaultMessage()).collect(Collectors.toList());
		ResponseDTO responseDTO = new ResponseDTO(message, errMsg);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ResponseDTO> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception){
		log.error("Invalid Date format", exception);
		ResponseDTO responseDTO = new ResponseDTO(message, "Should have date in the Format dd MMM yyyy");
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(CustomExceptions.class)
	public ResponseEntity<ResponseDTO> handleEmployeePayrollException(CustomExceptions exception) {
		ResponseDTO responseDTO = new ResponseDTO(message, exception.getMessage());
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}
}
