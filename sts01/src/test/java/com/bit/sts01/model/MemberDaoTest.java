package com.bit.sts01.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bit.config.RootConfig;
import com.bit.config.SecurityConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class,SecurityConfig.class})
public class MemberDaoTest {
	String[] ids= {"user01","user02","user03","user04","user05"};
	Logger log=LoggerFactory.getLogger(getClass());
	@Inject
	DataSource dataSource;
	@Inject
	PasswordEncoder passwordEncoder;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void addMember() throws SQLException {
		String sql="insert into bitmember values (?,?,?)";
		String[] pws= {"1234","1234","1234","1234","1234"};
		for(int i=0; i<ids.length; i++) {
			try(Connection conn=dataSource.getConnection()){
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, ids[i]);
				pstmt.setString(2, passwordEncoder.encode(1234+""));
				pstmt.setString(3, ids[i]);
				log.info((pstmt.executeUpdate()>0)+"");
			}
		}
	}
	
	@Test
	public void addAuth() throws SQLException {
		String sql="insert into bitauth values (?,?) ";
		String[] auths= {"ROLE_ADMIN","ROLE_MAMBER","ROLE_MAMBER","ROLE_MAMBER","ROLE_MAMBER"};
		for(int i=0; i<ids.length; i++) {
			try(Connection conn=dataSource.getConnection()){
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, ids[i]);
				pstmt.setString(2, auths[i]);
				log.info((pstmt.executeUpdate()>0)+"");
			}
		}
	}

}


















