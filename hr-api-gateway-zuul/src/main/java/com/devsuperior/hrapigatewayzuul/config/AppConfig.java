package com.devsuperior.hrapigatewayzuul.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

//Essa anotação vem do actuator
@RefreshScope
@Configuration
public class AppConfig {
	
	
	//Lendo a propriedade do arquivo properties do GIT
	//Nome da chave criada no application properties do git
	@Value("${jwt.secret}")
	private String jwtSecret;
	
				
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
