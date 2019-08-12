package com.bit.sts01.model;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bit.config.RootConfig;
import com.bit.sts01.model.entity.TestDbVo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class} )
public class TestDbDaoTest {
	Logger logger=LoggerFactory.getLogger(getClass());
	@Inject
	SqlSessionFactory sqlSessionFactory;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetList() throws SQLException {
		assertNotNull(sqlSessionFactory.openSession().getMapper(TestDbDao.class).selectAll());
//		for(TestDbVo bean:sqlSessionFactory.openSession().getMapper(TestDbDao.class).selectAll()) {
//			logger.debug(bean.toString());
//		}
//		jdk 1.8~
//		sqlSessionFactory.openSession()
//		.getMapper(TestDbDao.class).selectAll()
//		.forEach(action->logger.debug(action.toString()));
	}

}











