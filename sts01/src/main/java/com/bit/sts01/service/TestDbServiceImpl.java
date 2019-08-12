package com.bit.sts01.service;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bit.sts01.model.TestDbDao;
import com.bit.sts01.model.entity.TestDbVo;

@Service
public class TestDbServiceImpl implements TestDbService {
	@Inject
	TestDbDao testDbDao;
	
	@Override
	public List<TestDbVo> getList() throws SQLException {
		return testDbDao.selectAll();
	}

	@Transactional
	@Override
	public void addDB(TestDbVo bean) throws SQLException {
		testDbDao.insertOne(bean);
//		bean.setName(bean.getName()+1);
//		testDbDao.insertOne(bean);
	}

	@Override
	public TestDbVo oneDB(int num) throws SQLException {
		
		return testDbDao.selectOne(num);
	}

	@Override
	public int editDB(TestDbVo bean) throws SQLException {
		return testDbDao.updateOne(bean);
	}

	@Override
	public int delDB(int num) throws SQLException {
		return testDbDao.deleteOne(num);
	}

}
