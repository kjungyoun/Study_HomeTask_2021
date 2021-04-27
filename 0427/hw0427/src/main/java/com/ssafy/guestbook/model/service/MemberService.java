package com.ssafy.guestbook.model.service;

import java.util.Map;

import com.ssafy.guestbook.model.MemberDto;

public interface MemberService {
	public MemberDto login(Map<String, String> map) throws Exception;
}
