package com.ssafy.guestbook.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.guestbook.model.GuestBookDto;
import com.ssafy.util.DBUtil;

@Repository
public class GuestBookDaoImpl implements GuestBookDao {
	
	@Autowired
	private DataSource dataSource;

	@Override
	public void writeArticle(GuestBookDto guestBookDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into guestbook (userid, subject, content, regtime) values(?,?,?,now())";
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, guestBookDto.getUserid());
			pstmt.setString(2, guestBookDto.getSubject());
			pstmt.setString(3, guestBookDto.getContent());
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(conn,pstmt);
		}

	}

	@Override
	public List<GuestBookDto> listArticle(Map<String, String> map) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<GuestBookDto> list = new ArrayList<GuestBookDto>();
		
		String key = map.get("key");
		String word = map.get("word");
		int currentPage = Integer.parseInt(map.get("pg"));
		int sizePerPage = Integer.parseInt(map.get("spp"));
		
		
		try {
			String sql = "select articleno, userid, subject, content, regtime \n";
			sql += "from guestbook \n";
			if(!word.isEmpty()) {
				if("subject".equals(key)) {
					sql += "where subject like ? \n";
				}else {
					sql += "where " + key + " = ? \n";
				}
			}
			sql += "order by articleno desc \n";
			sql += "limit ?, ?";
			
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			int idx = 0;
			if(!word.isEmpty()) {
				if("subject".equals(key)) {
					pstmt.setString(++idx, "%" + word + "%");
				}else {
					pstmt.setString(++idx, word);
				}
			}
				pstmt.setInt(++idx, (currentPage-1) * sizePerPage );
				pstmt.setInt(++idx, sizePerPage);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					list.add(new GuestBookDto(
							rs.getInt("articleno"),
							rs.getString("userid"),
							rs.getString("subject"),
							rs.getString("content"),
							rs.getString("regtime")
							));
				}
		} finally {
			DBUtil.close(conn,pstmt,rs);
		}
		return list;
	}

	@Override
	public int getTotalCount(Map<String, String> map) throws SQLException {
		int cnt = 0;
		String key = map.get("key");
		String word = map.get("word");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select count(articleno) from guestbook \n";
			
			if(!word.isEmpty()) {
				if("subject".equals(key)) {
					sql += "where subject like ? \n";
				} else {
					sql += "where " + key + " = ? \n";
				}
			}
			
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			if(!word.isEmpty()) {
				if("subject".equals(key))
					pstmt.setString(1, "%" + word + "%");
				else
					pstmt.setString(1, word);
			}
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
		} finally {
			DBUtil.close(conn,pstmt,rs);
		}
		
		return cnt;
	}

	@Override
	public GuestBookDto getArticle(int articleno) throws SQLException {
		GuestBookDto guestBookDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from guestbook where articleno = ?";
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, articleno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				guestBookDto = new GuestBookDto(
						rs.getInt("articleno"),
						rs.getString("userid"),
						rs.getString("subject"),
						rs.getString("content"),
						rs.getString("regtime")
						);
			}
		}finally {
			DBUtil.close(conn,pstmt,rs);
		}
		return guestBookDto;
	}

	@Override
	public void modifyArticle(GuestBookDto guestBookDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "update guestbook set subject =?, content = ? where articleno = ?";
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, guestBookDto.getSubject());
			pstmt.setString(2, guestBookDto.getContent());
			pstmt.setInt(3, guestBookDto.getArticleno());
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}

	}

	@Override
	public void deleteArticle(int articleno) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "delete from guestbook where articleno = ?";
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,articleno);
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}

	}

}
