package com.epam.task2.exceptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception) {
        ErrorDetails details = new ErrorDetails(HttpStatus.NOT_FOUND, exception.getMessage());
        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception exception) {
        ErrorDetails details = new ErrorDetails(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        return new ResponseEntity<>(details, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> customValidationErrorHandling(MethodArgumentNotValidException exception){
		  Map<String,Object> errors= buildValidationErrorResponse(exception);
	    	ErrorDetails details=new ErrorDetails(HttpStatus.BAD_REQUEST, errors.toString());
    	    return new ResponseEntity<>(details,HttpStatus.BAD_REQUEST);
    }
    
    private Map<String, Object> buildValidationErrorResponse(BindingResult bindingResult) {
  	  
  	  List<FieldError> fieldErrors = bindingResult.getFieldErrors();

  	  List<Map<String, String>> errors = new ArrayList<>();

  	  for (FieldError error : fieldErrors) {
  		Map<String, String> errorMap = new HashMap<>();
  	    errorMap.put("field", error.getField());
  	    errorMap.put("message", error.getDefaultMessage());

  	    errors.add(errorMap);
  	  }

  	  Map<String, Object> response = new HashMap<>();
  	  response.put("errors", errors);

  	  return response;
  	}
}

