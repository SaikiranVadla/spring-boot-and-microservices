package com.example.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservice.dto.AuthRequest;
import com.example.microservice.entity.UserCredential;
import com.example.microservice.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	  @Autowired
	    private AuthService service;

	    @Autowired
	    private AuthenticationManager authenticationManager;

	    @PostMapping("/register")
	    public String addNewUser(@RequestBody UserCredential user) {
	        return service.saveUser(user);
	    }

	    @GetMapping("/token")
	    public String getToken(@RequestBody AuthRequest authRequest) {
	    	System.out.println("helo");
	    	System.out.println(authRequest.getPassword());
			Authentication authenticate =
					authenticationManager.authenticate(
//					new UsernamePasswordAuthenticationToken( authRequest.getUsername(), authRequest.getPassword()));
			new UsernamePasswordAuthenticationToken( authRequest.getEmail(), authRequest.getUsername()));

			System.out.println("AuthController.getToken()------"+authenticate.isAuthenticated());
			
//			if (authenticate.isAuthenticated()) {
//	        	System.out.println(authRequest.getUsername());
	            return 
	            		service.generateToken(authRequest.getUsername());
//	        } else {
//	        	System.out.println("failing");
//	            throw new RuntimeException("invalid access");
//	        }
	    }

	    @GetMapping("/validate")
	    public String validateToken(@RequestParam("token") String token) {
	        service.validateToken(token);
	        return "Token is valid";
	    }
	
	

}
