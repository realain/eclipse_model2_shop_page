<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Item AJAX관리</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/js/item_ajax_managing.js" defer="defer"></script>
</head>
<body>
	<%@ include file="/header_nav.jsp" %>
	<div class="container">
		<blockquote class="blockquote">
			<h1>아이템 에이작스 관리 페이지</h1>
		</blockquote>
		
		<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
		  <li class="nav-item" role="presentation">
		    <button class="nav-link active" id="pills-list-tab" data-bs-toggle="pill" data-bs-target="#pills-list" type="button" role="tab" aria-controls="pills-list" aria-selected="true">리스트</button>
		  </li>
		  <li class="nav-item" role="presentation">
		    <button class="nav-link" id="pills-insert-tab" data-bs-toggle="pill" data-bs-target="#pills-insert" type="button" role="tab" aria-controls="pills-insert" aria-selected="true">등록</button>
		  </li>
		  <li class="nav-item" role="presentation">
		    <button class="nav-link" id="pills-modify-tab" data-bs-toggle="pill" data-bs-target="#pills-modify" type="button" role="tab" aria-controls="pills-modify" aria-selected="false" disabled>수정</button>
		  </li>
		</ul>
		<div class="tab-content" id="pills-tabContent">
		  <div class="tab-pane fade show active" id="pills-list" role="tabpanel" aria-labelledby="pills-home-tab">
		  	<h2>아이템 리스트</h2>
		  	<table class="table table-dark table-striped">	
		  		<thead>
		  			<tr>
						<th class="col-1">num</th>
						<th class="col-1">main_img</th>
						<th class="col-2">title</th>
						<th class="col-1">count</th>
						<th class="col-1">price</th>
						<th class="col-1">color</th>
<!-- 					<th class="col-2">main_img</th>
						<th class="col-2">detail_img </th>
 -->					<th class="col-2">model_num </th>
						<th class="col-2">member_id </th>
<!-- 						<th class="col-2">post_time </th>
						<th class="col-2">sale_time </th>
						<th class="col-2">sale_end_time</th>
-->						<th class="col-1">state</th>
						<th class="col-1">c_num </th>
					</tr>
		  		</thead>
		  		<tbody id="itemList">
		  			<tr id="itemClone">
						<td class="item_num"></td>  
						<td>
							<img class="main_img" alt="메인" src="">
						</td>     
						<td>
							<a class="title" href="javascript:void(0)" onclick="modifyLoad(event)" data-num="">
							</a>
						</td>    
						<td class="count"></td>    
						<td class="price"></td>    
						<td class="color"></td>     
<!-- 					<td class="main_img"></td>  
						<td class="detail_img"></td>  
 -->					<td class="model_num"></td>
						<td class="member_id"></td>
<!-- 					<td class="post_time"></td>
 						<td class="sale_time"></td>
						<td class="sale_end_time"></td>
-->						<td class="state"></td>     
						<td class="cate_num"></td> 
					</tr>
		  		</tbody>
		  	</table>
		  </div>
		  <div class="tab-pane fade container-sm" id="pills-insert" role="tabpanel" aria-labelledby="pills-insert-tab">
		  	<div class="modal" id="insertModar" tabindex="-1">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title">아이템 등록</h5>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      <div class="modal-body">
			        <p id="insertMsg"></p>
			      </div>
			      <div class="modal-footer">
			        <button type="button" id="listReloadBtn" class="btn btn-primary">ITEM 리스트로 GO!</button>
			        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
			      </div>
			    </div>
			  </div>
			</div>
			
		  	
		  	<h2>아이템 등록</h2>
		  	<!-- 
		  	form-data 는 js 객체인 FormData를 의미하고 append 된 객체를 자동으로 바이너리 코드로 보내준다.
		  	multipart는 바이너리 코드를 보내는 기술
		  	input type="file"은 files라는 필드가 존재하는데 전송하려는 파일의 바이너리코드가 포함된다. 
		  	바이너리 코드로 보내는 요청정보를 서버에서 받기 위해서는 별도의 라이브러리를 추가해야한다. 우리는(cos) lib를 사용한다.
		  	
		  	-->
		  	
		  	<form action="" name="itemForm" enctype="multipart/form-data">
		  		<p class="input-group">
				  <label for="itemFormName" class="input-group-text">상품 이름</label>
				  <input name="name" type="text" class="form-control" id="itemFormName" value="광 마우스">
		  		</p>
		  		<p class="input-group">
				  <label for="itemFormTitle" class="input-group-text">게시 제목</label>
				  <input name="title" type="text" class="form-control" id="itemFormTitle" value="게이밍 마우스 판매">
		  		</p>
		  		<p class="input-group">
				  <label for="itemFormName" class="input-group-text">상품 모델</label>
				  <input name="model_num" type="text" class="form-control" id="itemFormName" value="MX1322F3">
		  		</p>
		  		<p class="input-group">
				  <label for="itemFormMemberId" class="input-group-text">게시자</label>
				  <input name="member_id" type="text" class="form-control" id="itemFormMemberId" value="admin" readonly>
		  		</p>
		  		<p class="input-group">
				  <label for="itemFormPrice" class="input-group-text">상품 가격</label>
				  <input name="price" type="number" class="form-control" id="itemFormPrice" value="60000">
		  		</p>
		  		<p class="input-group">
				  <label for="itemFormCateNum" class="input-group-text">카테고리</label>
				  <select name="cate_num" class="form-control" id="itemFormCateNum">
				  	<option value="1">가전</option>
				  	<option value="2">컴퓨터</option>
				  	<option value="3">아웃도어</option>
				  </select>
		  		</p>
		  		<p class="input-group">
				  <label for="itemFormMainImg" class="input-group-text">상품 메인이미지</label>
				  <input name="main_img" type="file" class="form-control" id="itemFormMainImg" value="">
		  		</p>
		  		<p class="input-group">
				  <label for="itemFormDetailImg" class="input-group-text">상품 상세이미지</label>
				  <input name="detail_img" type="file" class="form-control" id="itemFormDetailImg" value="">
		  		</p>
		  		<p class="input-group">
				  <label for="itemFormSaleTime" class="input-group-text">상품 판매 시작일</label>
				  <input name="sale_time" type="datetime-local" class="form-control" id="itemFormSaleTime" value="">
		  		</p>
		  		<p class="input-group">
				  <label for="itemFormSaleEndTime" class="input-group-text">상품 판매 종료일</label>
				  <input name="sale_end_time" type="datetime-local" class="form-control" id="itemFormSaleEndTime" value="">
		  		</p>
		  		<p class="input-group">
			  		<label for="itemFormColor" class="input-group-text">상품 색깔</label>
					<input name="color" type="color" class="form-control form-control-color" id="itemFormColor" value="#ffaaaa" title="Choose your color">
		  			<label for="itemFormState" class="input-group-text">상품 상태</label>
		  			<select name="state" class="form-control" id="itemFormState">
		  				<option value="0" selected>공개</option>
		  				<option value="1">비공개</option>
		  			</select>
		  			<label for="itemFormCount" class="input-group-text">판매수</label>
		  			<input name="count" type="number" class="form-control" id="itemFormCount" value="100">
		  		</p>
		  		<p class="d-grid gap-2 d-md-flex justify-content-md-end">
		  			<button class="btn btn-outline-warning" type="reset">리셋</button>
		  			<button class="btn btn-outline-primary" type="submit">등록</button>
		  		</p>
		  		
		  	</form>
		  </div>
		  <div class="tab-pane fade" id="pills-modify" role="tabpanel" aria-labelledby="pills-modify-tab">
		  	<div class="modal" id="updateModar" tabindex="-1">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title">아이템 수정</h5>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      <div class="modal-body">
			        <p id="updateMsg"></p>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-primary" id="listReloadBtn2">ITEM 리스트로 GO!</button>
			        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
			      </div>
			    </div>
			  </div>
			</div>
		  	<h2>아이템 수정</h2>
		  	<form action="" name="itemModifyForm">
		  		<p class="input-group">
				  <label for="itemModifyFormItemNum" class="input-group-text">상품 번호</label>
				  <input name="item_num" type="text" class="form-control" id="itemModifyItemNum" value="" readonly>
		  		</p>
		  		<p class="input-group">
				  <label for="itemModifyFormName" class="input-group-text">상품 이름</label>
				  <input name="name" type="text" class="form-control" id="itemModifyFormName" value="광 마우스">
		  		</p>
		  		<p class="input-group">
				  <label for="itemModifyFormTitle" class="input-group-text">게시 제목</label>
				  <input name="title" type="text" class="form-control" id="itemModifyFormTitle" value="게이밍 마우스 판매">
		  		</p>
		  		<p class="input-group">
				  <label for="itemModifyFormName" class="input-group-text">상품 모델</label>
				  <input name="model_num" type="text" class="form-control" id="itemModifyFormName" value="MX1322F3">
		  		</p>
		  		<p class="input-group">
				  <label for="itemModifyFormMemberId" class="input-group-text">게시자</label>
				  <input name="member_id" type="text" class="form-control" id="itemModifyFormMemberId" value="admin" readonly>
		  		</p>
		  		<p class="input-group">
				  <label for="itemModifyFormPrice" class="input-group-text">상품 가격</label>
				  <input name="price" type="number" class="form-control" id="itemModifyFormPrice" value="60000">
		  		</p>
		  		<p class="input-group">
				  <label for="itemModifyFormCateNum" class="input-group-text">카테고리</label>
				  <select name="cate_num" class="form-control" id="itemModifyFormCateNum">
				  	<option value="1">가전</option>
				  	<option value="2">컴퓨터</option>
				  	<option value="3">아웃도어</option>
				  </select>
		  		</p>
		  		<p class="input-group">
				  <label for="itemModifyFormMainImg" class="input-group-text">상품 메인이미지</label>
				  <input name="main_img" type="text" class="form-control" id="itemModifyFormMainImg" value="">
		  		</p>
		  		<p class="input-group">
				  <label for="itemModifyFormDetailImg" class="input-group-text">상품 상세이미지</label>
				  <input name="detail_img" type="text" class="form-control" id="itemModifyFormDetailImg" value="">
		  		</p>
		  		<p class="input-group">
				  <label for="itemModifyFormPostTime" class="input-group-text">상품 게시일</label>
				  <input name="post_time" type="datetime-local" class="form-control" id="itemModifyFormPostTime" value="" readonly>
		  		</p>
		  		<p class="input-group">
				  <label for="itemModifyFormSaleTime" class="input-group-text">상품 판매 시작일</label>
				  <input name="sale_time" type="datetime-local" class="form-control" id="itemModifyFormSaleTime" value="">
		  		</p>
		  		<p class="input-group">
				  <label for="itemModifyFormSaleEndTime" class="input-group-text">상품 판매 종료일</label>
				  <input name="sale_end_time" type="datetime-local" class="form-control" id="itemModifyFormSaleEndTime" value="">
		  		</p>
		  		<p class="input-group">
			  		<label for="itemModifyFormColor" class="input-group-text">상품 색깔</label>
					<input name="color" type="color" class="form-control form-control-color" id="itemModifyFormColor" value="#ffaaaa" title="Choose your color">
		  			<label for="itemModifyFormState" class="input-group-text">상품 상태</label>
		  			<select name="state" class="form-control" id="itemModifyFormState">
		  				<option value="0" selected>공개</option>
		  				<option value="1">비공개</option>
		  			</select>
		  			<label for="itemModifyFormCount" class="input-group-text">판매수</label>
		  			<input name="count" type="number" class="form-control" id="itemModifyFormCount" value="100">
		  		</p>
		  		<p class="d-grid gap-2 d-md-flex justify-content-md-end">
		  			<a class="btn btn-outline-danger" href="javascript:void(0)" id="itemDelA">삭제</a>
		  			<button type="button" class="btn btn-outline-danger" id="itemDelBtn">삭제</button>
		  			<button class="btn btn-outline-warning" type="reset">리셋</button>
		  			<button class="btn btn-outline-primary" type="submit">수정</button>
		  		</p>
		  		<p>
		  			<img alt="메인이미지" height="200px" src="" name="main_img_output">
	  			</p>
	  			<p>
		  			<img alt="상세이미지" height="100px" src="" name="detail_img_output">
		  		</p>
		  	</form>
		  </div>
		</div>
	</div>
</body>
</html>