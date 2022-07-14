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
<%
if(session.getAttribute("insert")!=null){
	boolean insert=(boolean)session.getAttribute("insert");
	String msg="";
	if(insert){
	}else{
		msg="<script>alert(\"등록실패\")</script>";
	}
	out.append(msg);
	session.removeAttribute("insert");
}
%>
<body>
	<%@ include file="/header_nav.jsp" %>
<script>
window.onload=function(){
	const CateInsert=document.forms.CateInsert;
	CateInsert.name.addEventListener("input",async(e)=>{
		const res=await fetch("./name_check.do?name="+e.target.value);
		const json=await res.json();
		if(json.name_check){
			checkName.innerText="사용 가능한 이름 입니다.";	
			checkName.style.color="green";
		}else{
			checkName.innerText="사용 불가능한 이름 입니다.";
			checkName.style.color="red";
		}
	});
}

</script>
	<h1>카테고리 등록 페이지 insert.jsp</h1>
	<form action="./insert.do" method="Post" name="CateInsert">
		<p>
			<label>카테고리 이름:
				<input type="text" name="name" value="" placeholder="카테고리 이름 입력">
			</label>
			<span id="checkName">이름 중복체크</span>
		</p>
		<p>
			<label>카테고리 서브:
				<input type="text" name="sub" value="1">
			</label>
		</p>
		<p>
			<button type="reset">리셋</button>
			<button type="submit">제출</button>
		</p>
		
				

	</form>
</body>
</html>