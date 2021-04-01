<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ssafy.model.dto.MemberDto"%>
<%String root =request.getContextPath();

System.out.print(root);
%>    
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>SSAFY-글작성</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
  <script type="text/javascript">
  function insertProduct() {
	if(document.getElementById("name").value == "") {
		alert("품목 필수 입력!");
		return;
	} else if(document.getElementById("price").value == "") {
		alert("가격 필수 입력!");
		return;
	} else if(document.getElementById("info").value == "") {
		alert("설명 필수 입력!");
		return;
	} else {
	  	document.getElementById("insertform").action = "<%= root %>/main.do";
	  	document.getElementById("insertform").submit();
	}
  }
  </script>
</head>
<body>
	<div class="col-lg-6" align="center">
		<h2>상품 등록하기</h2>
		<form id="insertform" method="post" action="">
		<input type="hidden" name="action" id="action" value="insertProduct">
			<div class="form-group" align="left">
				<label for="no">품목 번호:</label>
				<input type="text" class="form-control" id="no" name="no">
			</div>
			<div class="form-group" align="left">
				<label for="type">품목(phone, tv, fridge..):</label>
				<input type="text" class="form-control" id="name" name="name">
			</div>
			<div class="form-group" align="left">
				<label for="type">가격:</label>
				<input type="number" class="form-control" id="price" name="price" min="0">
			</div>
			<div class="form-group" align="left">
				<label for="desc">설명(200자 이내 설명):</label>
				<input type="text" class="form-control" id="info" name="info">
			</div>
			<button type="button" class="btn btn-primary" onclick="javascript:insertProduct();">상품 등록</button>
			<button type="reset" class="btn btn-warning">초기화</button>
		</form>
	</div>
</div>

</body>
</html>
