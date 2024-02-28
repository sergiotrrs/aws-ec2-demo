package com.aws.app.exception;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class ErrorDetails {
	
    private LocalDateTime timestamp;
    private String message;
    private String path;
    private String errorCode;
    
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
    
    
}
