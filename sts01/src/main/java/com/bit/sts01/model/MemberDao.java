package com.bit.sts01.model;

import com.bit.sts01.model.entity.Member;

public interface MemberDao {
	Member memberChk(String userid);
}
