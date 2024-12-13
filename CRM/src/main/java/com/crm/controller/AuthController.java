package com.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.dto.LoginRequest;
import com.crm.entities.User;
import com.crm.service.AuthService;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class AuthController {

	@Autowired
	private AuthService authService;

	@PostMapping("/login")
	public String login(@RequestBody LoginRequest request) {
		return authService.login(request);
	}

}
