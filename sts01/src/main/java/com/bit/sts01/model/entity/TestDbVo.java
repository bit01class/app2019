package com.bit.sts01.model.entity;

import java.sql.Timestamp;

public class TestDbVo {
//	num INT NOT NULL AUTO_INCREMENT,
//	name VARCHAR(10) NULL,
//	nalja TIMESTAMP NULL,
//	cnt INT NULL,
	
	private int num;
	private String name;
	private Timestamp nalja;
	private int cnt;
	
	public TestDbVo() {
	}

	public TestDbVo(int num, String name, Timestamp nalja, int cnt) {
		super();
		this.num = num;
		this.name = name;
		this.nalja = nalja;
		this.cnt = cnt;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getNalja() {
		return nalja;
	}

	public void setNalja(Timestamp nalja) {
		this.nalja = nalja;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "TestDbVo [num=" + num + ", name=" + name + ", nalja=" + nalja + ", cnt=" + cnt + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cnt;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + num;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestDbVo other = (TestDbVo) obj;
		if (cnt != other.cnt)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (num != other.num)
			return false;
		return true;
	}
	
	
}




















