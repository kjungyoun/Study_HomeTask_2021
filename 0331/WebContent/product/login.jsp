<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ssafy.model.dto.MemberDto"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<%
String root = request.getContextPath();
%>

<script type="text/javascript">
function login() {
	if(document.getElementById("userid").value == "") {
		alert("아이디 입력!!!");
		return;
	} else if(document.getElementById("userpwd").value == "") {
		alert("비밀번호 입력!!!");
		return;
	} else {
		document.getElementById("loginform").action = "<%= root %>/main.do";
		document.getElementById("loginform").submit();
	}
}

</script>
</head>
<body>


<div class="container" align="center">

<c:if test="${not empty msg}"></c:if>

<div class="col-lg-6" align="center">
	<span class="text-danger">${msg}</span>
</div>
	<c:choose>
	<c:when test="${empty userinfo}">

	<div class="col-lg-6" align="center">
		<form id="loginform" method="post" action="post">
		<input type="hidden" name="action" id="action" value="login">
			<div class="form-group" align="left">
				<label for="">아이디</label>
				<input type="text" class="form-control" id="userid" name="userid" placeholder="">
			</div>
			<div class="form-group" align="left">
				<label for="">비밀번호</label>
				<input type="password" class="form-control" id="userpwd" name="userpwd" placeholder="" onkeydown="javascript:if(event.keyCode == 13) {login();}">
			</div>
			<div class="form-group" align="center">
				<button type="button" class="btn btn-warning" onclick="javascript:login();">로그인</button>
				<!-- <button type="button" class="btn btn-primary" onclick="javascript:moveJoin();">회원가입</button>  -->
			</div>
		</form>
	</div>
	</c:when>
<c:otherwise>
	<div class="col-lg-6" align="center">
		${userinfo.userid } 님 환영합니다. <a href="<%=root %>/main.do?action=logout">로그아웃</a>
	</div>
</c:otherwise>
	</c:choose>
</div>