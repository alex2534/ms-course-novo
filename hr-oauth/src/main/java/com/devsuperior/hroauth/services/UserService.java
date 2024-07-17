package com.devsuperior.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.devsuperior.hroauth.entities.User;
import com.devsuperior.hroauth.feignclients.UserFeignClient;

@Service
public class UserService implements UserDetailsService {

	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	public User findByEmail(String email) {
		// Essa instancia faz a comunicação com o micro serviço de usuário
		
		User user = userFeignClient.fidByEmail(email).getBody();
		
		if(user == null) {
			logger.error("Email not found: " + email);
			throw new IllegalArgumentException("Email not found");
			
		}
		logger.info("Email found: " + email);
		
		return user;
		
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userFeignClient.fidByEmail(username).getBody();
		
		if(user == null) {
			logger.error("Email not found: " + username);
			throw new UsernameNotFoundException("Email not found");
			
		}
		logger.info("Email found: " + username);
		
		return user;
	}
	
}
