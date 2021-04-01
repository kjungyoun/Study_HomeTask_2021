package com.ssafy.model.service;

import com.ssafy.model.dto.MemberDto;

public interface LoginService {
	public MemberDto login(String userid, String userpwd) throws Exception;
}
