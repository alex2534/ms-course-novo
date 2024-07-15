package com.devsuperior.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.devsuperior.hroauth.entities.User;
import com.devsuperior.hroauth.feignclients.UserFeignClient;

@Service
public class UserService {

	
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
	
}
