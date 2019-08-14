package com.bit.sts01.model.entity;

public class Auth {
	private String userid,auth;
	public Auth() {
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	@Override
	public String toString() {
		return "Auth [userid=" + userid + ", auth=" + auth + "]";
	}
	
}
