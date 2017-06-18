package com.spring.boot.captcha.api.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.boot.captcha.api.exception.PasswordMismatchException;
import com.spring.boot.captcha.api.model.RegistrationModel;
import com.spring.boot.captcha.api.util.VerifyRecaptchaUtils;

@Controller
public class RegistrationController {

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerNow(
			Model model,
			@ModelAttribute("registrationModel") RegistrationModel registrationModel,
			HttpServletRequest request) throws PasswordMismatchException {
		String message = "";
		boolean verify;
		String gRecaptchaResponse = request
				.getParameter("g-recaptcha-response");
		System.out.println(gRecaptchaResponse);
		try {
			verify = VerifyRecaptchaUtils.verify(gRecaptchaResponse);
			if (registrationModel.getPassword().equals(
					registrationModel.getConfirmPassword())
					&& verify) {
				message = "Registration Successfully";
				model.addAttribute("message", message);
			} else {
				String ErrorMessage = "OOPS !! Password Mismatch.!";
				throw new PasswordMismatchException(ErrorMessage);
			}
		} catch (IOException e) {
			model.addAttribute("message", "Service Gateway Failed.");
		}
		System.out.println(message);
		System.out.println(registrationModel);
		return "registration";

	}
}
