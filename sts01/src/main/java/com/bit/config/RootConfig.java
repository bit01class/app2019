package com.bit.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = {"com.bit.sts01.service","com.bit.sts01.model","com.bit.sts01.aop"})
@EnableAspectJAutoProxy
@EnableTransactionManagement
@MapperScan(basePackages = {"com.bit.sts01.model"})
//@MapperScan(basePackages = "classpath:/securityMapper.xml")
public class RootConfig {

	@Bean
	public DataSource getDataSource() {
		DataSource dataSource=null;
		HikariConfig config=null;
		config=new HikariConfig();
//		config.setDriverClassName("org.gjt.mm.mysql.Driver");
//		config.setJdbcUrl("jdbc:mysql://localhost:3306/xe");
		config.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		config.setJdbcUrl("jdbc:log4jdbc:mysql://localhost:3306/xe");
		config.setUsername("scott");
		config.setPassword("tiger");
		dataSource=new HikariDataSource(config);
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFoFactory() throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(getDataSource());
		return bean.getObject();
	}
	
	@Bean
	public DataSourceTransactionManager txManager() {
		return new DataSourceTransactionManager(getDataSource());
	}
}




















