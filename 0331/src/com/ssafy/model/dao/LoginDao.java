package com.ssafy.model.dao;

import java.sql.SQLException;

import com.ssafy.model.dto.MemberDto;

public interface LoginDao {
	public MemberDto login(String userid, String userpwd) throws SQLException;
}
