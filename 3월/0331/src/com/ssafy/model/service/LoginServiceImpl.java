package com.ssafy.model.service;

import com.ssafy.model.dto.MemberDto;

public class LoginServiceImpl implements LoginService {

	@Override
	public MemberDto login(String userid, String userpwd) throws Exception {
		MemberDto member = new MemberDto();
		member.setUserid("ssafy");
		member.setUserpwd("ssafy");
		
		if(member.getUserid().equals(userid)) {
			if(member.getUserpwd().equals(userpwd)) {
				return member;
			}else {
				throw new Exception("비밀번호 오류입니다.");
			}
		}else {
			throw new Exception("등록되지 않은 아이디입니다.");
		}
	}

}
