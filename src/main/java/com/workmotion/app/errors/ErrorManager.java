package com.workmotion.app.errors;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

@ControllerAdvice
public class ErrorManager{
	
	
	@ExceptionHandler(Exception.class)
	public String handler1() {
		
		return "/error/error404";
	}

	
	
	
}
