<%@page import="java.util.ArrayList"%>
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
<body>
	<%@ include file="/header_nav.jsp" %>
	<h1>상품 관리 페이지입니다</h1>
	<%List<ItemVo> item_list=(ArrayList<ItemVo>)request.getAttribute("item_list"); %>
	<table>
		<thead>
			<tr>
				<th>item_num</th>
				<th>name</th>
				<th>title</th>
				<th>count</th>
				<th>price</th>
				<th>color</th>
				<th>main_img</th>
				<th>detail_img</th>
				<th>model_num</th>
				<th>member_id</th>
				<th>post_time</th>
				<th>sale_time</th>
				<th>sale_end_time</th>
				<th>state</th>
				<th>cate_num</th>
				<th>수정하러 가기</th>
			</tr>
		</thead>
		<tbody>
			<%for(ItemVo item:item_list) {%>
			<tr>
				<td><%=item.getItem_num() %></td>
				<td><%=item.getName() %></td>
				<td><%=item.getTitle() %></td>
				<td><%=item.getCount() %></td>
				<td><%=item.getPrice() %></td>
				<td><%=item.getColor() %></td>
				<td><%=item.getMain_img() %></td>
				<td><%=item.getDetail_img() %></td>
				<td><%=item.getModel_num() %></td>
				<td><%=item.getMember_id() %></td>
				<td><%=item.getPost_time() %></td>
				<td><%=item.getSale_time() %></td>
				<td><%=item.getSale_end_time() %></td>
				<td><%=item.getState() %></td>
				<td><%=item.getCate_num() %></td>
				<td>
					<a href="./modify.do?item_num=<%=item.getItem_num() %>">수정</a>
				</td>
			</tr>
			<%} %>
		</tbody>
	</table>
</body>
</html>