package com.bit.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/")
			.permitAll()//아무나 접근
			.antMatchers("/find")//검색은 회원만 접근
			.access("hasRole('ROLE_MEMBER')");
		
		http.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/login")
			.successHandler(successHandler());
	}
	
	private AuthenticationSuccessHandler successHandler() {
		return new LoginSuccessHandler();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("tester1").password("{noop}1234").roles("MEMBER");
		auth.inMemoryAuthentication()
			.withUser("admin").password("{noop}1234").roles("ADMIN");
	}
}

















