<%@page import="model2_shop.com.vo.CateVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/header_nav.jsp" %>
	<h1>카테고리 관리 페이지 입니다.</h1>
	<h2>
		<a href="insert.do">
			카테고리 등록
		</a> 
	</h2>
<%
if(session.getAttribute("insert")!=null){
	boolean insert=(boolean)session.getAttribute("insert");
	String msg="";
	if(insert){
		msg="<script>alert(\"등록성공\")</script>";
	}else{
	}
	out.append(msg);
	session.removeAttribute("insert");
}

%>
<%
List<CateVo> cate_list=(List<CateVo>)request.getAttribute("cate_list");
if(session.getAttribute("delete")!=null){
	boolean delete=(boolean)session.getAttribute("delete");
	String msg="";
	if(delete){ 
		msg="<script>alert(\"삭제 성공\");</script>";
	}else{ 
	} 
	out.append(msg);
	session.removeAttribute("delete");
}
%>
	<table>
		<thead>
			<tr>
				<th>CATE_NUM</th>
				<th>NAME</th>
				<th>SUB</th>
				<th>수정하기</th>
			</tr>
		</thead>
		<tbody>
			<%for(CateVo cate:cate_list){ %>
			<tr>
				<td><%=cate.getCate_num() %></td>
				<td><%=cate.getName() %></td>
				<td><%=cate.getSub() %></td>
				<td>
					<a href="./modify.do?cate_num=<%=cate.getCate_num()%>">
						수정
					</a>
				</td>
			</tr>
			<%} %>
		</tbody>
	</table>
</body>
</html>