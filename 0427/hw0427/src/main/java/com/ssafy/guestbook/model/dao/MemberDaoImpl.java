package com.ssafy.guestbook.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.guestbook.model.MemberDto;
import com.ssafy.util.DBUtil;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Autowired
	private DataSource dataSource;
	
	Logger logger = LoggerFactory.getLogger(MemberDaoImpl.class);
	
	public MemberDto login(Map<String, String> map) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDto memberDto = null;
		try {
			String sql = "select username,userid,email from ssafy_member where userid =? and userpwd = ?";
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, map.get("userid"));
			pstmt.setString(2, map.get("userpwd"));
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				memberDto = new MemberDto();
				memberDto.setUserid(rs.getString("userid"));
				memberDto.setUsername(rs.getString("username"));
				memberDto.setEmail(rs.getString("email"));
				logger.debug(memberDto.toString());
			}
		}catch (Exception e) {
			e.printStackTrace();
			memberDto = null;
		} 
		
		finally {
			DBUtil.close(conn,pstmt,rs);
		}
		return memberDto;
	}
	
	@Override
	public MemberDto login(String userid, String pwd) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDto memberDto = null;
		try {
			String sql = "select username,userid,email from ssafy_member where userid =? and userpwd = ?";
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				memberDto = new MemberDto();
				memberDto.setUserid(rs.getString("userid"));
				memberDto.setUsername(rs.getString("username"));
				memberDto.setEmail(rs.getString("email"));
			}
		}catch (Exception e) {
			e.printStackTrace();
			memberDto = null;
		} 
		
		finally {
			DBUtil.close(conn,pstmt,rs);
		}
		return memberDto;
	}
	
	public static void main(String[] args) {
		MemberDao dao = new MemberDaoImpl();
		try {
			System.out.println(dao.login("ssafy","ssafy"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
