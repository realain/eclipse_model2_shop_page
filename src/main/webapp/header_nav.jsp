<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="<%=request.getContextPath()%>">eclipse_shop_admin</a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
			<div class="collapse navbar-collapse justify-content-between" id="navbarNavDropdown">
				<ul class="navbar-nav">
<%
Object login_obj=session.getAttribute("login");
if(login_obj!=null && (boolean)login_obj){%>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">
					    	멤버
					    </a>
					    <ul class="dropdown-menu">
					    	<li>
					      		<a class="dropdown-item" href="<%=request.getContextPath()%>/mem/ajax_managing.do">
					      			AJAX 멤버 리스트 관리
				      			</a>
			      			</li>
				     		<li>
				     			<a class="dropdown-item" href="<%=request.getContextPath()%>/mem/list.do">
				     				멤버 리스트 관리
				     			</a>
			     			</li>
					    </ul>
					</li>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">
					    	카테고리
					    </a>
					    <ul class="dropdown-menu">
				     		<li>
				     			<a class="dropdown-item" href="<%=request.getContextPath()%>/cate/list.do">
				     				카테고리 리스트 관리
				     			</a>
			     			</li>
					    </ul>
					</li>
					<li class="nav-item dropdown">
					    <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">
					    	아이템
					    </a>
					    <ul class="dropdown-menu">
					    	<li>
					      		<a class="dropdown-item" href="<%=request.getContextPath()%>/item/ajax_managing.do">
					      			AJAX 아이템관리
				      			</a>
			      			</li>
				     		<li>
				     			<a class="dropdown-item" href="<%=request.getContextPath()%>/item/list.do">
				     				아이템리스트
				     			</a>
			     			</li>
					    </ul>
					</li>
<%} %>
				</ul>
<!-- 				<form class="d-flex">
				    <input class="form-control me-2" type="text" placeholder="id" aria-label="id">
				    <input class="form-control me-2" type="password" placeholder="pw" aria-label="pw">
				    <button class="btn btn-outline-success" type="submit">ajax_login</button>
				</form> -->
<%
	if(login_obj!=null && (boolean)login_obj){
%>
				<div>
					<span><%=session.getAttribute("id") %></span>
					(<span><%=session.getAttribute("name") %></span>)
					님 로그인
					&nbsp;/&nbsp;
					<a href="<%=request.getContextPath()%>/logout.do">
						로그아웃
					</a>
				</div>
<%}else{ %>
				<div class="d-flex">
					<a class="" href="<%=request.getContextPath()%>/login.do">로그인</a>
					&nbsp;/&nbsp;
					<a class="" href="<%=request.getContextPath()%>/signup.do">회원가입</a>
					&nbsp;/&nbsp;
					<a class="" href="<%=request.getContextPath()%>/login.do">ajax_로그인</a>
				</div>
<%} %>
			</div>
		</div>
	</nav>

</body>
</html>