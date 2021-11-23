package com.demo.student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Student Records not exists")
public class StudentNotFoundException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public StudentNotFoundException(String message) {
		super(message);
	}
}
