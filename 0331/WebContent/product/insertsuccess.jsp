<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ssafy.model.dto.Product"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
  <title>상품 등록 성공</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" align="center">
	<jsp:include page="/product/login.jsp"/>
	<c:choose>
	<c:when test="${not empty product}">
	<div class="col-lg-6">
	  <div class="jumbotron">
	    <h1>상품 등록 성공</h1>      
	  </div>
	  <div>
	  <h3>최근 등록한 상품 정보</h3>
	  	<div class="container" align="center">
			<div class="col-lg-6" align="center">
				<div class="form-group" align="left">
					<label for="">상품번호</label>
					<input type="text" class="form-control" id="userid" name="userid" placeholder=""  value="${product.productno}">
				</div>
				<div class="form-group" align="left">
					<label for="">상품이름</label>
					<input type="text" class="form-control" id="userid" name="userid" placeholder="" value="${product.name }" >
				</div>
				<div class="form-group" align="left">
					<label for="">상품가격</label>
					<input type="text" class="form-control" id="userid" name="userid" placeholder="" value="${product.price}" >
				</div>
				<div class="form-group" align="left">
					<label for="">상품설명</label>
					<input type="text" class="form-control" id="userid" name="userid" placeholder="" value="${product.info}" >
				</div>
			</div>
		</div>
	 
	  </div>  
	</div>
	</c:when>
	<c:otherwise>
	<div class="col-lg-6"><span>${msg}</span></div>
	</c:otherwise>
	</c:choose>
</div>
</body>
</html>
