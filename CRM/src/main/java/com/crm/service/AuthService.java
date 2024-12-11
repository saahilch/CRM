package com.crm.service;

import java.util.Optional;

import com.crm.dto.LoginRequest;
import com.crm.entities.User;
import com.crm.repository.UserRepository;

public class AuthService {

	private UserRepository userRepository;

	public String login(LoginRequest request) {
		Optional<User> user = userRepository.findByEmail(request.getEmail());

		if (user.isPresent() && user.get().getPassword().equals(request.getPassword())) {
			return "Login Successfull... ";
		} else if (user.isPresent()) {
			return "Invalid Password ";
		} else {
			return "Email Is Not Registerd";
		}

	}

}
