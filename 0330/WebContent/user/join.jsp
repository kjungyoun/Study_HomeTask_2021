<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
	$(function(){
		$("#register").click(function(){
			if($("#userid").val() == ""){
				alert("아이디를 입력하시오");
				return;
			}else if($('#userpwd').val() == ""){
			alert("비밀번호를 입력하시오");
			return;
		}else if($('#userpwd_val').val() == ""){
			alert("비밀번호를 입력하시오");
			return;
		}else{
			$("#memberform").attr("action","<%=root%>/main?act=register").submit();
		}
		})
		
	})
</script>

<title>SSAFY Homework 0330</title>
</head>
<body>
	<h1 align="center">회원 가입</h1>
	<div class="container mt-5" align="center">
		<table style="border: 1px solid;">
		<tr>
		<td class="p-5">
		<img alt="사진 입니다." src="../res/book.jpeg" style="width:200px">
		</td>
		<td class="p-5">
		<h4>회원 정보를 입력해주세요</h4>
		<form id="memberform" class="mt-4" method="post" action="">
		<input type="hidden" name="act" value="login">
		<div class="form-inline align-itme-right" align="right">
				<label for="userid" class="mr-sm-2" style="padding-left:115px">ID</label>
				<input type="text" class="form-control" id="userid" name="userid" placeholder="" value="">
			</div>
			<div class="form-inline mt-2" align="right">
				<label for="userpwd" class="mr-sm-2" style="padding-left:42px">PASSWORD</label>
				<input type="password" class="form-control" id="userpwd" name="userpwd" placeholder="" value="">
			</div>
			<div class="form-inline mt-2" align="right">
				<label for="userpwd_val" class="mr-sm-2">PASSWORD Valid</label>
				<input type="password" class="form-control" id="userpwd_val" name="userpwd_val" placeholder="" value="">
			</div>
			<div class="form-group mt-3 pl-5" align="center">
				<button type="button" class="btn btn-primary" id="register">submit</button>
			</div>
		</form>
		</td>
		</tr>
		</table>
		<div class="m-3">
		<a href="" class="m-3">상품 등록</a>
		<a href="" class="m-3">상품 목록</a>
		<a href="" class="m-3">마지막 등록한 상품</a>
		</div>
	</div>
</body>
</html>