package com.devsuperior.hrapigatewayzuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class AppConfig {
				
	//Configuração para o jwt
	@Bean
	public JwtAccessTokenConverter  accessTokenConverter() { 
		
		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
		//Configuração do secret key que os tokens são asinados
		tokenConverter.setSigningKey("MY-SECRETE-KEY");
		return tokenConverter;
		
	}
	
//	Essa methodo e responsavel por ler as informações do token
	@Bean
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}
	

}
