package com.tejait.batch15.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice // spring boot will recognize this is global exception handler class by given this annotation
public class GlobalExceptionHandler {
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ErrorDtls> idNotFoundException(HttpServletRequest request){
		Date date=new Date();
		ErrorDtls error=new ErrorDtls(date,407, "Id Not Fpund", "Given Id Not Available",request.getRequestURI());
				System.out.println(error);
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(MobileAlreadyExists.class)
	public ResponseEntity<ErrorDtls> mobileAlreadyExists(HttpServletRequest request){
		Date date=new Date();
		ErrorDtls error=new ErrorDtls(date, 420, "Mobile Already Exist", "Given Mobile Already Exist" , request.getRequestURI());
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
    @ExceptionHandler(MailAlreadyExists.class)
	public ResponseEntity<ErrorDtls>mailAlreadyExits(HttpServletRequest request){
		Date date=new Date();
		ErrorDtls error=new ErrorDtls(date, 501, "Mail Already Exist", "Given Mail Already Exist", request.getRequestURI());
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDtls>globalExceptionMethod(HttpServletRequest request){
    	ErrorDtls error=new ErrorDtls(new Date(),502,"something went wrong","unknown error occured",request.getRequestURI());
    			return new ResponseEntity<>(error,HttpStatus.ACCEPTED);
    	
    }
}
