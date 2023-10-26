package com.ssafy.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionController {
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e, Model model) {
		log.error("exception handler: {}", e);
		model.addAttribute("errormsg", e.getMessage());
		return "error/commonerr";
	}
	
//	@ExceptionHandler(BindException.class)
//	public String handleBindException(Exception e, Model model) {
//		log.error("exception handler: {}", e);
//		model.addAttribute("errormsg", "파라미터가 잘 전달되었는지 확인하세요");
//		return "error/commonerr";
//	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String handle404Exception(NoHandlerFoundException e, Model model) {
		log.error("exception handler(404): {}", e);
		model.addAttribute("errormsg", e.getMessage());
		return "error/404";
	}
}
