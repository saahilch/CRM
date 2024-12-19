package com.crm.service;



import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.dto.ForgotPasswordRequest;
import com.crm.dto.LoginRequest;
import com.crm.dto.LoginResponse;
import com.crm.dto.RegistrationRequest;
import com.crm.entities.Role;
import com.crm.entities.User;
import com.crm.repository.RoleRepository;
import com.crm.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public String register(RegistrationRequest request) {
        Optional<Role> role = roleRepository.findByName(request.getRole());

        if (role.isEmpty()) {
            return "Role Not Found Kindly Check..!";
        }

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return "Email Has Already Registered..!";
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); 
        user.setRole(role.get());

        userRepository.save(user);
        return "Registration Successful...! You Can Login Now..";
    }

    public LoginResponse login(LoginRequest request) {
        Optional<User> user = userRepository.findByEmail(request.getEmail());

        if (user.isEmpty() || !user.get().getPassword().equals(request.getPassword())) {
            return new LoginResponse("Invalid Email Or Password", null);
        }

        return new LoginResponse("Login Successful...", user.get().getRole().getName());
    }
    
    public String forgotPassword(ForgotPasswordRequest request) {
        Optional<User> user = userRepository.findByEmail(request.getEmail());

        if (user.isPresent()) {
            // Generate a reset token
            String resetToken = UUID.randomUUID().toString();
            User existingUser = user.get();
            existingUser.setResetToken(resetToken);

            userRepository.save(existingUser);

            return "Reset token generated. Use this token to reset your password: " + resetToken;
        } else {
            return "Email not registered!";
        }
    }

    public String resetPassword(String resetToken, String newPassword) {
        Optional<User> user = userRepository.findByResetToken(resetToken);

        if (user.isPresent()) {
            User existingUser = user.get();
            existingUser.setPassword(newPassword); // Update password directly
            existingUser.setResetToken(null); // Clear the reset token

            userRepository.save(existingUser);
            return "Password reset successful!";
        } else {
            return "Invalid or expired reset token!";
        }
    }
    
}
