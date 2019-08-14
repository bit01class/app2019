package com.bit.config;

import static org.junit.Assert.assertTrue;

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

import junit.framework.Assert;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class,SecurityConfig.class})
public class BitUserDetailsServiceTest {
	@Inject
	DataSource dataSource;
	@Inject
	PasswordEncoder passwordEnoder;
	
	Logger log=LoggerFactory.getLogger(getClass());

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void addDummyMember(){
//		log.info(dataSource.getConnection().toString());
		String sql="insert into testmember (userid,userpw,name) values (?,?,?)";
		for(int i=1; i<10; i++) {
			try(Connection conn=dataSource.getConnection()){
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "user"+i);
				pstmt.setString(2, passwordEnoder.encode("user"));
				pstmt.setString(3, "tester"+i);
				assertTrue(pstmt.executeUpdate()>0);
				log.info(dataSource.getConnection().toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Assert.fail("Not yet implemented");
			}
		}
	}
	
	@Test
	public void testLoadUserByUsername() {
		String sql="insert into testauth (userid,auth) values (?,?)";
		String[] params= {"ROLE_USER","ROLE_MEMBER","ROLE_ADMIN"};
		for(int i=1; i<10; i++) {
			try(Connection conn=dataSource.getConnection()){
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "user"+i);
				pstmt.setString(2, params[i/4]);
				assertTrue(pstmt.executeUpdate()>0);
				log.info(dataSource.getConnection().toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Assert.fail("Not yet implemented");
			}
		}
	}
//	@Test
//	public void testLoadUserByUsername() {
//		fail("Not yet implemented");
//	}

}















