package br.com.alura.forum.config.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
@Configuration
@Profile("dev") // VM Arguments : Dspring.profiles.active=dev
public class DevSecurityConfigurations extends WebSecurityConfigurerAdapter {


	
	
	//configurações de autorizações
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http
		.authorizeRequests()
		.antMatchers("/**").permitAll()
		.and().csrf().disable();
	}
	

	
	
}
