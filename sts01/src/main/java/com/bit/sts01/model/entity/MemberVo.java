package com.bit.sts01.model.entity;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;

public class MemberVo {
//userid, userpw, name, enabled, age, nalja, auth
	private String userid,userpw,name;
	private int age,enabled;
	private Date nalja;
	private List<AuthVo> authList;
	
	public MemberVo() {
	}
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public Date getNalja() {
		return nalja;
	}

	public void setNalja(Date nalja) {
		this.nalja = nalja;
	}

	public List<AuthVo> getAuthList() {
		return authList;
	}

	public void setAuthList(List<AuthVo> authList) {
		this.authList = authList;
	}

	@Override
	public String toString() {
		return "MemberVo [userid=" + userid + ", userpw=" + userpw + ", name=" + name + ", enabled=" + enabled
				+ ", age=" + age + ", nalja=" + nalja + ", authList=" + authList + "]";
	}
	
	
}
