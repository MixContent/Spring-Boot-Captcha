package com.spring.boot.captcha.api.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.spring.boot.captcha.api.exception.PasswordMismatchException;

@ControllerAdvice
public class ExceptionHandlerAdvice {
	@ExceptionHandler(PasswordMismatchException.class)
	public ModelAndView handleException(PasswordMismatchException e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("ErrorMessage", e.getMessage());
		mav.setViewName("registration");
		return mav;
	}
}
