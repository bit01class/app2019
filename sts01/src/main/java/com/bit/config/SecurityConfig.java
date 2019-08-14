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
			.permitAll()//�ƹ��� ����
			.antMatchers("/find")//�˻��� ȸ���� ����
			.access("hasRole('ROLE_MEMBER')")

			.antMatchers("/find")//�˻��� ȸ��,�����ڸ� ����
			.access("hasRole('ROLE_ADMIN')")
			

			.antMatchers("/member")//�˻��� ȸ���� ����
			.access("hasRole('ROLE_MEMBER')")

			.antMatchers("/admin")//�˻��� ȸ���� ����
			.access("hasRole('ROLE_ADMIN')");;
		
		http.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/login")
			.successHandler(successHandler());
		
		http.logout()
			.logoutUrl("/logout")
			.invalidateHttpSession(true)
			.deleteCookies("JSESSION_ID");
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

















