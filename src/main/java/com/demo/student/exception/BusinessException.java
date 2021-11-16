package com.demo.student.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "some reason")
public class BusinessException extends RuntimeException {

	public BusinessException(String message) {
		super(message);
	}
}
