package com.bit.sts01.model;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bit.sts01.model.entity.TestDbVo;

public interface TestDbDao {
	@Select("SELECT * FROM TESTDB")
	List<TestDbVo> selectAll() throws SQLException;

	@Insert("INSERT INTO TESTDB (NAME,NALJA,CNT) VALUES (#{name},NOW(),0)")
	void insertOne(TestDbVo bean) throws SQLException;

	@Select("SELECT * FROM TESTDB WHERE NUM=#{val}")
	TestDbVo selectOne(int num) throws SQLException;
	
	@Update("UPDATE TESTDB SET NAME=#{name} WHERE NUM=#{num}")
	int updateOne(TestDbVo bean) throws SQLException;

	@Delete("DELETE FROM TESTDB WHERE NUM=#{val}")
	int deleteOne(int num) throws SQLException;
}
