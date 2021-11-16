package com.demo.student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "no data found or empty")
public class StudentNoContentException extends RuntimeException {

	String message;
	public StudentNoContentException(String message) {
		this.message=message;
	}
	
	public String getMessage() {
		return message;
	}
}
