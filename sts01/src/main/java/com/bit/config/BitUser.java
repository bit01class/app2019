package com.bit.config;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.bit.sts01.model.entity.MemberVo;

public class BitUser extends User{


	public BitUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		// TODO Auto-generated constructor stub
	}

	public BitUser(MemberVo bean, Set<GrantedAuthority> setAuths) {
		this(bean.getUserid()
				, bean.getUserpw(),setAuths);
	}

	
	
}