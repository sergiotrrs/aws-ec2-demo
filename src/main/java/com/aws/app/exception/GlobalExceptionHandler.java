package com.aws.app.exception;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice 
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	private ErrorDetails errorDetails;
	
	@Autowired
	public GlobalExceptionHandler(ErrorDetails errorDetails) {
		this.errorDetails = errorDetails;
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
							MethodArgumentNotValidException ex,
							HttpHeaders headers, 
							HttpStatusCode status, 
							WebRequest request
							) {

		List<ObjectError> errorList = ex.getBindingResult().getAllErrors();
		
		String errorMessage = errorList.stream()
				.map( error-> error.getDefaultMessage())
				.collect(Collectors.joining(", "));
				
		errorDetails.setTimestamp(LocalDateTime.now());
		errorDetails.setMessage(errorMessage);
		errorDetails.setPath(request.getDescription(false));
		errorDetails.setErrorCode("INVALID_FIELD_VALUE");

		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(IllegalStateException.class)
	ResponseEntity<ErrorDetails> handleIllegalStateException(Exception exception, WebRequest webRequest) {
		errorDetails.setTimestamp(LocalDateTime.now());
		errorDetails.setMessage(exception.getMessage());
		errorDetails.setPath(webRequest.getDescription(false));
		errorDetails.setErrorCode("INVALID_STATE");

		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
}
