package com.zee.zee5app.controlleradvice;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.zee.zee5app.Exception.AlreadyExistsException;
import com.zee.zee5app.Exception.IdNotFoundException;

@ControllerAdvice
public class ExceptionAdvice {

	@ExceptionHandler(AlreadyExistsException.class)
	public ResponseEntity<?> alreadyRecordExistsExceptionHandler(AlreadyExistsException e){
		
		HashMap<String, String> map = new HashMap<>();
		map.put("message", "Record already exists"+e.getMessage());
		return ResponseEntity.badRequest().body(map);
	}
	
	
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<?> exceptionHandler(Exception e){
//		
//		HashMap<String, String> map = new HashMap<>();
//		map.put("message", "Unknown exception : "+e.getMessage());
//		return ResponseEntity.badRequest().body(map);
//	}
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<?>idNotFoundExceptionHandler(Exception e){
		
		HashMap<String, String> map = new HashMap<>();
		map.put("message", "Id not found exception : "+e.getMessage());
		return ResponseEntity.badRequest().body(map);
	}
	
}
