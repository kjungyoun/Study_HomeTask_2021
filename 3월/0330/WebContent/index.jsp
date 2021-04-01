<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ssafy.dto.*" %>
    
<% 
String root = request.getContextPath(); 

String msg = (String) request.getAttribute("msg");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function login(){
		if(document.getElementById("userid").value==""){
			alert("아이디를 입력하시오");
			return;
		}else if(document.getElementById("userpwd").value == ""){
			alert("비밀번호를 입력하시오");
			return;
		}else{
			document.getElementById("loginform").action = "<%=root%>/main";
			document.getElementById("loginform").submit();
		}
	}
	
	function join(){
		document.location.href = "<%=root%>/main?act=join";
	}
	
	function prod(){
		
		<%
MemberDto mem = (MemberDto) session.getAttribute("logininfo");

if(mem == null){
	%>
	alert("로그인부터 해주세요!");
	<%
};
%>
	}
</script>

<title>SSAFY Homework 0330</title>
</head>
<body>
	<h1 align="center">메인 페이지</h1>
	<div class="container mt-5" align="center">
		<table style="border: 1px solid;">
		<tr>
		<td class="p-5">
		<img alt="사진 입니다." src="./res/book.jpeg" style="width:200px">
		</td>
		<td class="p-5">
		<h4>로그인 하여 주세요</h4>
		<span class="err text-danger"><%= msg == null ? "" : msg %></span>
		<form id="loginform" class="mt-4" method="post" action="">
		<input type="hidden" name="act" value="login">
		<div class="form-inline align-itme-right" align="right">
				<label for="userid" class="mr-sm-2" style="padding-left:73px">ID</label>
				<input type="text" class="form-control" id="userid" name="userid" placeholder="" value="">
			</div>
			<div class="form-inline mt-2" align="right">
				<label for="userpwd" class="mr-sm-2">PASSWORD</label>
				<input type="password" class="form-control" id="userpwd" name="userpwd" placeholder="" value="">
			</div>
			<div class="form-group mt-3 pl-5" align="center">
				<button type="button" class="btn btn-success" onclick="javascript:login();">login</button>
				<button type="button" class="btn btn-primary" onclick="javascript:join();">join</button>
			</div>
		</form>
		</td>
		</tr>
		</table>
		<div class="m-3">
		<a href="<%=root %>/product/prodRegis.jsp" class="m-3" onclick="javascript:prod()">상품 등록</a>
		<a href="" class="m-3">상품 목록</a>
		<a href="" class="m-3" onclick="javascript:prod()">마지막 등록한 상품</a>
		</div>
	</div>
</body>
</html>