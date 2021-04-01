package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.ssafy.model.dto.Product;

public interface ProductDao {

	public void insertProduct(Connection conn,Product productDto) throws SQLException;
	public int getLastNo(Connection conn) throws SQLException;
	public Product getProduct(int productno) throws SQLException;
}
