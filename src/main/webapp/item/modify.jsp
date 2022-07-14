<%@page import="model2_shop.com.vo.ItemVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%ItemVo item=(ItemVo)request.getAttribute("item"); %>
<body>
	<%@ include file="/header_nav.jsp" %>
	<h1>아이템 수정 페이지</h1>
	<form action="./update.do" method="Post">
		<p>
			<label>아이템 넘버:
				<input type="number" name="item_num" value="<%=item.getItem_num()%>"  readonly>
			</label>
		</p>
		<p>
			<label>아이템 이름:
				<input type="text" name="name" value="<%=item.getName()%>">
			</label>
		</p>
		<p>
			<label>아이템 타이틀:
				<input type="text" name="title" value="<%=item.getTitle()%>">
			</label>
		</p>
		<p>
			<label>아이템 수:
				<input type="number" name="count" value="<%=item.getCount()%>">
			</label>
		</p>
		<p>
			<label>아이템 가격:
				<input type="number" name="price" value="<%=item.getPrice()%>">
			</label>
		</p>
		<p>
			<label>아이템 색깔:
				<input type="text" name="color" value="<%=item.getColor()%>">
			</label>
		</p>
		<p>
			<label>아이템 메인이미지:
				<input type="text" name="main_img" value="<%=item.getMain_img()%>">
			</label>
		</p>
		<p>
			<label>아이템 상세이미지:
				<input type="text" name="detail_img" value="<%=item.getDetail_img()%>">
			</label>
		</p>
		<p>
			<label>아이템 모델번호:
				<input type="text" name="model_num" value="<%=item.getModel_num()%>">
			</label>
		</p>
		<p>
			<label>아이템 멤버 아이디:
				<input type="text" name="member_id" value="<%=item.getMember_id()%>">
			</label>
		</p>
		<p>
			<label>아이템 포스트타임:
				<input type="datetime" name="post_time" value="<%=item.getPost_time()%>">
			</label>
		</p>
		<p>
			<label>아이템 판매시간:
				<input type="datetime" name="sale_time" value="<%=item.getSale_time()%>">
			</label>
		</p>
		<p>
			<label>아이템 판매 종료시간:
				<input type="datetime" name="sale_end_time" value="<%=item.getSale_end_time()%>">
			</label>
		</p>
		<p>
			<label>아이템 스테이트:
				<input type="number" name="state" value="<%=item.getState()%>">
			</label>
		</p>
		<p>
			<label>아이템 카테고리 넘버:
				<input type="number" name="cate_num" value="<%=item.getCate_num()%>" readonly>
			</label>
		</p>
		<p>
			<button type="reset">리셋</button>
			<button type="submit">제출</button>
		</p>
	</form>
</body>
</html>