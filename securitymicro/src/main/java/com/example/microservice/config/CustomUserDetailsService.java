package com.example.microservice.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.microservice.entity.UserCredential;
import com.example.microservice.repository.UserCredentialRepository;
 @Component
public class CustomUserDetailsService implements UserDetailsService {

	  @Autowired
	    private UserCredentialRepository repository;
	  
	  
	  
		
	  @Override
	 public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		        Optional<UserCredential> credential = repository.findByEmail(email);
		        return credential.map(CustomUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("user not found with name :" + email));
		    
		
	}

}
