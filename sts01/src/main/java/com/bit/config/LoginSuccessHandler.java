package com.bit.config;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication auth) throws IOException, ServletException {
		System.out.println("onAuthenticationSuccess...");
		Collection<? extends GrantedAuthority> collection = auth.getAuthorities();
		Iterator<? extends GrantedAuthority> ite = collection.iterator();
		while(ite.hasNext()) {
			GrantedAuthority ele = ite.next();
			if(ele.getAuthority().equals("ROLE_ADMIN")) {
				response.sendRedirect("admin");
				return;
			}else if(ele.getAuthority().equals("ROLE_MEMBER")) {
				response.sendRedirect("member");				
				return;
			}
		}
		response.sendRedirect("./");
		return;
	}

}
