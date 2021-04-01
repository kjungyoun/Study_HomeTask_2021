<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ssafy.model.dto.MemberDto"%>
<% String root = request.getContextPath(); %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Main</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</head>
<body>
<div align="center">
<h3>로그인</h3>
<jsp:include page="/product/login.jsp"/>
<a href="<%=root %>/main.do?action=mvInsert">상품 등록</a>
<a href="<%=root %>/main.do?action=listProduct">상품 목록</a>
<a href="<%=root %>/main.do?action=searchLastProduct">마지막 등록한 상품 조회</a>

</div>

</div>
</body>
</html>