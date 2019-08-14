package com.bit.config;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bit.sts01.model.MemberDao;
import com.bit.sts01.model.entity.Auth;
import com.bit.sts01.model.entity.Member;

public class BitDetailsService implements UserDetailsService {
	Logger log=LoggerFactory.getLogger(getClass());
	@Inject
	SqlSessionFactory sqlSessionFactory;

	public BitDetailsService(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory=sqlSessionFactory;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberDao memberDao = sqlSessionFactory.openSession().getMapper(MemberDao.class);
		Member bean = memberDao.memberChk(username);
		log.debug(bean.toString());
		List<Auth> list = bean.getAuthList();
		Set auths=new HashSet<GrantedAuthority>();
		for(Auth ele:list) {
			auths.add(new GrantedAuthority() {
				
				@Override
				public String getAuthority() {
					return ele.getAuth();
				}
			});
		}
		return new BitUser(bean.getUserid(),bean.getUserpw(),auths);
	}

}















