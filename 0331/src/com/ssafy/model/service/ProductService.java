package com.ssafy.model.service;

import com.ssafy.model.dto.Product;

public interface ProductService {
	public int insertProduct(Product productDto) throws Exception;
	public Product getProduct(int productno) throws Exception;
}
