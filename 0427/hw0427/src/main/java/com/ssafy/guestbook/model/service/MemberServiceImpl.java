package com.ssafy.guestbook.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.guestbook.model.MemberDto;
import com.ssafy.guestbook.model.dao.MemberDao;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public MemberDto login(Map<String, String> map) throws Exception {
		
		return memberDao.login(map);
	}

}
