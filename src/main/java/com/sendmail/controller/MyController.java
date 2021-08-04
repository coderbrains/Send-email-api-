package com.sendmail.controller;

import java.io.File;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sendmail.entity.EmailStructure;
import com.sendmail.services.EmailService;

@RestController
public class MyController {

	@Autowired
	private EmailService emailService;

	@PostMapping("/demo")
	public String demo() {
		return "demo api";
	}

	@CrossOrigin
	@PostMapping("/sendemail")

	public ResponseModel sendMail(@RequestBody EmailStructure emailStructure) {
//		boolean sendMail = emailService.sendMail(emailStructure.getTo(), emailStructure.getSubject(), emailStructure.getMessage());

		boolean sendMail = emailService.sendAttachedEmail(emailStructure.getTo(), emailStructure.getSubject(),
				emailStructure.getMessage());

		if (sendMail) {
			return new ResponseModel(0, "sent successfully");
		}

		return new ResponseModel(3, "cannot sent message...");
	}

}
