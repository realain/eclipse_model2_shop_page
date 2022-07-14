<%@page import="model2_shop.com.vo.CateVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
String updateConfirm=request.getParameter("updateConfirm"); 
if(session.getAttribute("delete")!=null){
	boolean delete=(boolean)session.getAttribute("delete");
	String msg="";
	if(delete){ 
	}else{ 
		msg="<script>alert(\"삭제 실패\");</script>";
	} 
	out.append(msg);
	session.removeAttribute("delete");
}
%>
<script>
let updateConfirm=<%=updateConfirm%>;
if(updateConfirm!=null){
	alert("수정실패")
}
</script>
<%CateVo cate=(CateVo)request.getAttribute("cate"); %>
<body>
	<%@ include file="/header_nav.jsp" %>
	<h1>modify.jsp</h1>
	<h2><%=cate.toString() %></h2>
	<h2>카테고리 수정 폼</h2>
	<form action="./update.do" method="Post">
		<p>
			<label>카테고리 넘버:
				<input type="number" name="cate_num" value="<%=cate.getCate_num()%>"  readonly>
			</label>
		</p>
		<p>
			<label>카테고리 이름:
				<input type="text" name="name" value="<%=cate.getName()%>">
			</label>
		</p>
		<p>
			<label>카테고리 서브:
				<input type="number" name="sub" value="<%=cate.getSub()%>" readonly>
			</label>
		</p>
		<p>
			<button type="reset">리셋</button>
			<button type="submit">제출</button>
			<a href="./delete.do?cate_num=<%=cate.getCate_num()%>">삭제</a>
		</p>
	</form>
</body>
</html>