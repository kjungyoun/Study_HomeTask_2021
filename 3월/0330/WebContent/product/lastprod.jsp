<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ssafy.dto.*" %>
    
<% 
String root = request.getContextPath(); 

MemberDto mem = (MemberDto) session.getAttribute("logininfo");

if(mem == null) response.sendRedirect(root+"/index.jsp");

String id = "";
String name = "";
String price = "";
String desc = "";

Cookie cookies[] = request.getCookies();
if(cookies == null){
	%>
<script type="text/javascript">
$(function(){
	alert("등록된 상품이 없습니다.");
	
})
</script>
<% 	
	response.sendRedirect(root+"/user/logined.jsp");
}else{
	for(Cookie cookie : cookies){
		if(cookie.getName().equals("id")) id = cookie.getValue();
		else if(cookie.getName().equals("name")) name = cookie.getValue();
		else if(cookie.getName().equals("price")) price = cookie.getValue();
		else if(cookie.getName().equals("desc")) desc = cookie.getValue();
	}	
}


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>

<title>SSAFY Homework 0330</title>
</head>
<body>
	<h1 align="center">마지막 등록한 상품</h1>
	<div class="container mt-5" align="center">
		<table style="border: 1px solid; width: 40%; height:300px; font-size: 20px">
		<tr>
		<td style="font-weight: bold; text-align: center">상품 번호
		</td>
		<td style="text-align:left"><%=id %></td>
		</tr>
		<tr>
		<td style="font-weight: bold; text-align: center">상 품 명
		</td>
		<td style="text-align:left"><%=name %></td>
		</tr>
		<tr>
		<td style="font-weight: bold; text-align: center">상품 가격
		</td>
		<td style="text-align:left"><%=price %></td>
		</tr>
		<tr>
		<td style="font-weight: bold; text-align: center">상품 설명
		</td>
		<td style="text-align:left"><%=desc %></td>
		</tr>
		</table>
		<div class="m-3">
		<a href="" class="m-3">상품 수정</a>
		<a href="" class="m-3">상품 삭제</a>
		<a href="" class="m-3">상품 목록</a>
		</div>
	</div>
</body>
</html>