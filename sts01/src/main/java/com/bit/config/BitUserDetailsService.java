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
import com.bit.sts01.model.entity.AuthVo;
import com.bit.sts01.model.entity.MemberVo;

public class BitUserDetailsService implements UserDetailsService {
	SqlSessionFactory sqlSessionFactory;
//	MemberDao memberDao;
	private Logger logger=LoggerFactory.getLogger(getClass());

	public BitUserDetailsService(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory=sqlSessionFactory;
	}

	@Override
	public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
		MemberDao memberDao=null;
		memberDao=sqlSessionFactory.openSession().getMapper(MemberDao.class);
		MemberVo bean = memberDao.read(userid);
		logger.info("queried by member mapper: " + bean);
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		List<AuthVo> list = bean.getAuthList();
		for(AuthVo ele:list) {
			setAuths.add(new SimpleGrantedAuthority(ele.getAuth()));
			logger.info(ele.getAuth());
		}
		return new BitUser(bean,setAuths);
	}

}
