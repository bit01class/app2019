package com.bit.sts01.model;

import org.apache.ibatis.annotations.Mapper;

import com.bit.sts01.model.entity.MemberVo;

@Mapper
public interface MemberDao {

//	@Results(id = "memberMap", value = {
//			  @Result(property = "userid", column = "userid", id = true),
//			  @Result(property = "userpw", column = "userpw"),
//			  @Result(property = "name", column = "name"),
//			  @Result(property = "enabled", column = "enabled"),
//			  @Result(property = "age", column = "age"),
//			  @Result(property = "nalja", column = "nalja"),
//			  @Result(property = "auth",many = @Many )
//			})
////	@Results(id = "authMap", value = {
////			@Result(property = "userid", column = "userid"),
////			@Result(property = "auth", column = "auth"),
////	})
//	
//	@Select("select A.userid, userpw, name, enabled, age, nalja, auth from testMember A left outer join testAuth B on A.userid=B.userid where A.userid = #{userid}")
	MemberVo read(String userid);
}
