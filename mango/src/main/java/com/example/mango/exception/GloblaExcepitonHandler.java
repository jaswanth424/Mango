package com.example.mango.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GloblaExcepitonHandler {

//	@ExceptionHandler(NoCarsFoundException.class)
//	public ResponseEntity<?> handleCustomException(NoCarsFoundException ex) {
//		return new ResponseEntity(ex.getErr(), HttpStatus.NOT_FOUND);
//	}

//	@ExceptionHandler(NoTruksFoundException.class)
//	public ResponseEntity<?> handleNoTrunksException(NoTruksFoundException ex) {
//		return new ResponseEntity(ex.getErr(), HttpStatus.BAD_REQUEST);
//	}

}
