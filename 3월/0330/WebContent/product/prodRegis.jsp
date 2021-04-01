<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ssafy.dto.*" %>
    
<% 
String root = request.getContextPath(); 

MemberDto mem = (MemberDto) session.getAttribute("logininfo");

if(mem == null) response.sendRedirect(root+"/index.jsp");

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
			if($("#prodid").val() == ""){
				alert("상품번호를 입력하시오");
				return;
			}else if($('#prodname').val() == ""){
			alert("상품이름을 입력하시오");
			return;
		}else if($('#price').val() == ""){
			alert("가격을 입력하시오");
			return;
		}else if($('#desc').val() == ""){
			alert("상품설명을 입력하시오");
			return;
		}else{
			$("#memberform").attr("action","<%=root%>/main").submit();
		}
		})
		
	})
</script>

<title>SSAFY Homework 0330</title>
</head>
<body>
	<h1 align="center">상품 등록</h1>
	<div class="container mt-5" align="center">
		<table style="border: 1px solid;">
		<tr>
		<td class="p-5">
		<h4></h4>
		<form id="memberform" class="mt-4 " method="post" action="">
		<input type="hidden" name="act" value="registerprod">
		<div class="form-inline align-itme-right" align="right">
				<label for="prodid" class="mr-sm-2">상품 번호</label>
				<input type="text" class="form-control" id="prodid" name="prodid" placeholder="" value="">
			</div>
			<div class="form-inline mt-2" align="right">
				<label for="prodname" class="mr-sm-2" >상품 이름</label>
				<input type="text" class="form-control" id="prodname" name="prodname" placeholder="" value="">
			</div>
			<div class="form-inline mt-2" align="right">
				<label for="price" class="mr-sm-2">상품 가격</label>
				<input type="text" class="form-control" id="price" name="price" placeholder="" value="">
			</div>
			<div class="form-inline mt-2" align="right">
				<label for="desc" class="mr-sm-2">상품 설명</label>
				<input type="text" class="form-control" id="desc" name="desc" placeholder="" value="">
			</div>
			<div class="form-group mt-3 pl-5" align="center">
				<button type="button" class="btn btn-primary" id="register">submit</button>
			</div>
		</form>
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