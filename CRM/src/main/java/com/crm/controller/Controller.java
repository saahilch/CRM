package com.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.dto.LoginRequest;
import com.crm.service.AuthService;



@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class Controller {

	 @Autowired
	public AuthService authService;

	 @PostMapping("/login")
	public String login(@RequestBody LoginRequest request) {
		return authService.login(request);
	}
}
