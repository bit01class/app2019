package com.bit.sts01.model.entity;

import java.util.List;

public class Member {
	private String userid,userpw,name;
	private List<Auth> authList;
	
	public Member() {
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

	public List<Auth> getAuthList() {
		return authList;
	}

	public void setAuthList(List<Auth> authList) {
		this.authList = authList;
	}

	@Override
	public String toString() {
		return "Member [userid=" + userid + ", userpw=" + userpw + ", name=" + name + ", authList=" + authList + "]";
	}
	
}
