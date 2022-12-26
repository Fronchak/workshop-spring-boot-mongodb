package com.fronchak.workshopmongodb.domain.exceptions.handler;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.fronchak.workshopmongodb.domain.exceptions.ExceptionResponse;
import com.fronchak.workshopmongodb.domain.exceptions.ResourceNotFoundException;

@RestControllerAdvice
public class CustomizeResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	private ResponseEntity<ExceptionResponse> handlerResourceNotFoundException(
			ResourceNotFoundException e, WebRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		ExceptionResponse response = new ExceptionResponse();
		response.setTimestamp(Instant.now());
		response.setError("Resource not found");
		response.setMessage(e.getMessage());
		response.setStatus(status.value());
		response.setPath(request.getDescription(false));
		return ResponseEntity.status(status).body(response);
	}
	
}
