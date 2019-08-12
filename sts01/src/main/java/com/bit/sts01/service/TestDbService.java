package com.bit.sts01.service;

import java.sql.SQLException;
import java.util.List;

import com.bit.sts01.model.entity.TestDbVo;

public interface TestDbService {

	List<TestDbVo> getList() throws SQLException;

	void addDB(TestDbVo bean) throws SQLException;

	TestDbVo oneDB(int num) throws SQLException;
	
	int editDB(TestDbVo bean) throws SQLException;

	int delDB(int num) throws SQLException;
}
