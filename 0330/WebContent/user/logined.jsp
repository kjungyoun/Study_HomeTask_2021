<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ssafy.dto.*"%>
    <% 
String root = request.getContextPath();
MemberDto member = (MemberDto) session.getAttribute("logininfo");
if(member == null){
	response.sendRedirect(root+"/index.jsp");
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
<script type="text/javascript">
function logout(){
	document.location.href="<%=root%>/main?act=logout"
}
</script>
</head>
<body>
	<h1 align="center">메인 페이지</h1>
	<div class="container mt-5" align="center">
		<table style="border: 1px solid;">
		<tr>
		<td class="p-5">
		<img alt="사진 입니다." src="../res/book.jpeg" style="width:200px">
		</td>
		<td class="p-5">
		<h4 class="text-primary"><%=member.getId() %> <p class="text-dark">님 환영합니다.<p></h4>
		<button type="button" class="btn btn-danger" onclick="javascript:logout();">logout</button>
		</td>
		</tr>
		</table>
		<div class="m-3">
		<a href="<%=root %>/product/prodRegis.jsp" class="m-3">상품 등록</a>
		<a href="" class="m-3">상품 목록</a>
		<a href="<%=root %>/product/lastprod.jsp" class="m-3">마지막 등록한 상품</a>
		</div>
	</div>
</body>
</html>