package com.eureka.exceptionhandling;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class ExceptionInfo {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
    	//MethodArgumentNotValidException-----Exception to be thrown when validation on an argument annotated with @Valid fails.Extends BindException as of 5.3.
        BindingResult bindingResult = ex.getBindingResult();
//        BindingResult-------General interface that represents binding results. Extends the Errors interface for error registration capabilities,allowing for a Validator to be applied, and addsbinding-specific analysis and model building. 
//
//Serves as result holder for a DataBinder, obtained viathe DataBinder.getBindingResult() method. BindingResultimplementations can also be used directly, for example to invokea Validator on it (e.g. as part of a unit test).
       // getFieldErrors()----- Get all errors associated with a field.
        Map<String, String> errors = new HashMap<>();
        bindingResult.getFieldErrors().forEach(fieldError -> errors.put(fieldError.getField(), fieldError.getDefaultMessage()));
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(errors);
    }
}
