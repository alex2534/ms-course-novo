package com.devsuperior.hroauth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class AppConfig {

	
	@Value("${jwt.secret}")
	private String jwtSecret;
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new  BCryptPasswordEncoder(); 
	}
	
	
	//Configuração para o jwt
	@Bean
	public JwtAccessTokenConverter  accessTokenConverter() { 
		
		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
		//Configuração do secret key que os tokens são asinados
		tokenConverter.setSigningKey(jwtSecret);
		return tokenConverter;
		
	}
	
//	Essa methodo e responsavel por ler as informações do token
	@Bean
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}
	
	
	
}
