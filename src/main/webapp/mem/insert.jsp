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
		msg="<script>alert(\"등록 성공\");</script>";
	}else{ 
		msg="<script>alert(\"등록 실패\");</script>";
	} 
	out.append(msg);
	session.removeAttribute("insert");
}
%>
<body>
	<%@ include file="/header_nav.jsp" %>
<script>
window.onload=function(){
	const MemInsert=document.forms.MemInsert;
	MemInsert.id.addEventListener("input",async(e)=>{
		if(e.target.value.length>3){
			const res=await fetch("./id_check.do?id="+e.target.value); //MemberIdCheck.java
			const json=await res.json();
			if(json.id_check){
				checkId.innerText="사용 가능한 아이디 입니다.";	
				checkId.style.color="green";
			}else{
				checkId.innerText="사용 불가능한 아이디 입니다.";
				checkId.style.color="red";
			}			
		}else{
			checkId.innerText="네 글자 이상 입력하세요"
			checkId.style.color="red";
		}
	});
	MemInsert.email.addEventListener("input",async(e)=>{
		const res=await fetch("./email_check.do?email="+e.target.value);
		const json=await res.json();
		if(json.email_check){
			checkEmail.innerText="사용 가능한 이메일 입니다.";	
			checkEmail.style.color="green";
		}else{
			checkEmail.innerText="사용 불가능한 이메일 입니다.";	
			checkEmail.style.color="red";
		}
	});
	MemInsert.phone.addEventListener("input",async(e)=>{
		const res=await fetch("./phone_check.do?phone="+e.target.value);
		const json=await res.json();
		if(json.phone_check){
			checkPhone.innerText="사용 가능한 번호 입니다.";	
			checkPhone.style.color="green";
		}else{
			checkPhone.innerText="사용 불가능한 번호 입니다.";	
			checkPhone.style.color="red";
		}
	})
	
}
</script>
	<h1>/mem/insert.jsp</h1>
	<h2>멤버 등록 폼</h2>
	<form action="./insert.do" method="Post" name="MemInsert">
		<p>
			<label>아이디:
				<input type="text" name="id" value="" placeholder="아이디를 입력하세요">
			</label>
			<span id="checkId">중복체크중입니다.</span>
		</p>
		<p>
			<label>패스워드:
				<input type="text" name="pw" value="1234">
			</label>
			
			<span id="checkPw">길이가 4자 이상</span>
		</p>
		<p>
			<label>패스워드 확인:
				<input type="text" name="pw_check" value="1234">
			</label>
			
			<span id="checkPwCheck">같은지 확인</span>
		</p>
		<p>
			<label>폰번호:
				<input type="text" name="phone" value="" placeholder="XXX-XXXX-XXXX">
			</label>
			<span id="checkPhone">중복체크중입니다.</span>
		</p>	
		<p>
			<label>이메일:
				<input type="text" name="email" value="" placeholder="email을 입력하세요">
			</label>
			<span id="checkEmail">중복체크중입니다.</span>
		</p>	
		<p>
			<label>이름:
				<input type="text" name="name" value="길동">
			</label>
		</p>	
		<p>
			<label>생일:
				<input type="date" name="birth" value="1111-11-11" pattern="yyyy-mm-dd">
			</label>
		</p>	
		<p>
			<label>주소:
				<input type="text" name="address" value="서울">
			</label>
		</p>	
		<p>
			<label>상세주소:
				<input type="text" name="address_detail" value="종로">
			</label>
		</p>	
		<p>
			<label>등급:
				<select size="1" name="grade">
					<option value="0">총관리자(0)</option>
					<option value="1">관리자(1)</option>
					<option value="2">판매자(2)</option>
					<option value="3" selected>소비자(3)</option>
					<option value="4">탈퇴(4)</option>
					
				</select>
			</label>
		</p>
		<p>
			<button type="reset">리셋</button>
			<button type="submit">제출</button>
		</p>
	</form>
</body>
</html>