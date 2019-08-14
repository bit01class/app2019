package com.bit.config;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	Logger log=LoggerFactory.getLogger(getClass());
	
	@Inject
	SqlSessionFactory sqlSessionFactory;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/")
			.permitAll()//아무나 접근
//			.antMatchers("/find")//검색은 관리자만 접근
//			.access("hasRole('ROLE_ADMIN')")
//			.antMatchers("/find")//검색은 회원만 접근
//			.access("hasRole('ROLE_MEMBER')")
			.antMatchers("/find")//검색은 회원만 접근
			.access("hasAnyRole('ROLE_MEMBER','ROLE_ADMIN')")

			

			.antMatchers("/member")//검색은 회원만 접근
			.access("hasRole('ROLE_MEMBER')")

			.antMatchers("/admin")//검색은 회원만 접근
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
		/*
		 * auth.inMemoryAuthentication().passwordEncoder(passwordEncoder())
		 * .withUser("user01").password(
		 * "$10$WT91y/KCply0/YJI6Rfye.lw3uVKqOog71DUZXCtwrkgCtDGWz8ee").roles("MEMBER");
		 * auth.inMemoryAuthentication().passwordEncoder(passwordEncoder())
		 * .withUser("admin").password("1234").roles("ADMIN");
		 */
		log.debug("db configure...");
		auth.userDetailsService(userDetailsService())
			.passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected UserDetailsService userDetailsService() {
		log.debug("BitDetailsService...");
		return new BitDetailsService(sqlSessionFactory);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

















