<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Object login=session.getAttribute("login");
	Object id=session.getAttribute("id");
	if(login!=null && !((boolean)login)){
		session.removeAttribute("login");//세션 객체 삭제
		session.removeAttribute("login_msg");
%>
<script>
	alert("아이디와 패스워드를 확인하세요!");
</script>
<%} 
Object login_msg=session.getAttribute("login_msg");
if(login_msg!=null){
	session.removeAttribute("login_msg");
%>
<script>alert("<%=login_msg%>")</script>
<%} %>
	<%@ include file="/header_nav.jsp" %>
	<h1>샵 스프링 로그인 페이지</h1>
	<div class="d-flex justify-content-center align-items-center" style="height:calc(100vh - 200px);">
		<form action="<%=request.getContextPath()%>/login.do" method="post" style="width:400px;">
		 <div class="mb-3 row">
		    <label for="staticEmail" class="col-sm-2 col-form-label">아이디</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="staticEmail" name="id" value="<%=(id!=null)?id:""%>">
		    </div>
		  </div>
		  <div class="mb-3 row">
		    <label for="inputPassword" class="col-sm-2 col-form-label">패스워드</label>
		    <div class="col-sm-10">
		      <input type="password" class="form-control" id="inputPassword" name="pw">
		    </div>
		  </div>
		  <div class="mb-3 row">
		  	<button type="button" class="col-sm-6 btn btn-danger">회원가입</button>
		  	<button type="submit" class="col-sm-6 btn btn-success">로그인</button>
		  </div>
		</form>
	</div>
</body>
</html>