package com.bit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/")
			.permitAll()
			.antMatchers("/find")
			.access("hasRole('ROLE_MEMBER')")

			.antMatchers("/member")
			.access("hasRole('ROLE_MEMBER')")

			.antMatchers("/admin")
			.access("hasRole('ROLE_ADMIN')");
		
		http.formLogin()
			.loginPage("/mylogin")
			.loginProcessingUrl("/login")
			.successHandler(loginSuccessHandler());
		
		http.logout()
			.logoutUrl("/mylogout")
			.invalidateHttpSession(true)
			.deleteCookies("remember-me","JSESSION_ID");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("user1").password("{noop}1234").roles("MEMBER");
		auth.inMemoryAuthentication()
			.withUser("admin").password("{noop}1234").roles("ADMIN");
	}
	
	@Bean
	public AuthenticationSuccessHandler loginSuccessHandler() {
		return new LoginSuccessHandler();
	}
}
