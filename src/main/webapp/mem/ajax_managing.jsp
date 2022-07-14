<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member AJAX 관리</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/js/mem_ajax_managing2.js" defer="defer"></script>
</head>
<body>
	<%@ include file="/header_nav.jsp" %>
	<div class="container">
		<blockquote class="blockquote">
			<h1>멤버 관리 페이지</h1>		
		</blockquote>
		<ul class="nav nav-tabs" id="myTab" role="tablist">
		  <li class="nav-item" role="presentation">
		    <button class="nav-link active" id="list-tab" data-bs-toggle="tab" data-bs-target="#list" type="button" role="tab" aria-controls="list" aria-selected="true" style="color:black; font-weight : bold;">리스트</button>
		  </li>
		  <li class="nav-item" role="presentation">
		    <button class="nav-link" id="insert-tab" data-bs-toggle="tab" data-bs-target="#insert" type="button" role="tab" aria-controls="insert" aria-selected="true" style="color:black; font-weight : bold;">등록</button>
		  </li>
		  <li class="nav-item" role="presentation">
		    <button class="nav-link" id="modify-tab" data-bs-toggle="tab" data-bs-target="#modify" type="button" role="tab" aria-controls="modify" aria-selected="false" style="color:gray; font-weight : bold;" disabled>수정</button>
		  </li>
		</ul>
		
		<div class="tab-content">
		  <div class="tab-pane active" id="list" role="tabpanel" aria-labelledby="list-tab">
		  	<h2>멤버 리스트</h2>
		  	<table class="table table-sm">
			  <thead class="table-light">
			    <tr>
			      <th scope="col">id</th>
			      <th scope="col">pw</th>
			      <th scope="col">phone</th>
			      <th scope="col">email</th>
			      <th scope="col">name</th>
			      <th scope="col">address</th>
			      <th scope="col">address_detail</th>
			      <th scope="col">signup_time</th>
			      <th scope="col">birth</th>
			      <th scope="col">grade</th>
			    </tr>
			  </thead>
			  <tbody id="memList">
			    <tr id="memClone">
			      <td>
			      	<a class="id"  style="text-decoration:none; color:gray; font-weight : bold;" href="javascript:void(0)" onclick="modifyLoad(event)" data-str=""></a>
			      </td>
			      <td class="pw"></td>
			      <td class="phone"></td>
			      <td class="email"></td>
			      <td class="name"></td>
			      <td class="address"></td>
			      <td class="address_detail"></td>
			      <td class="signup_time"></td>
			      <td class="birth"></td>
			      <td class="grade"></td>
			    </tr>
			  </tbody>
			</table>
		  </div>
		  <div class="tab-pane" id="insert" role="tabpanel" aria-labelledby="insert-tab">
			  <div class="modal" id="insertModar" tabindex="-1">
				  <div class="modal-dialog">
				    <div class="modal-content">
				      <div class="modal-header">
				        <h5 class="modal-title">멤버 등록</h5>
				        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				      </div>
				      <div class="modal-body">
				        <p id="insertMsg"></p>
				      </div>
				      <div class="modal-footer">
				        <button type="button" id="listReloadBtn" class="btn btn-primary">리스트로</button>
				        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
				      </div>
				    </div>
				  </div>
				</div>
		  	<h2>멤버 신규 등록</h2>
				<form name="memForm">
				  <div class="row mb-2">
				    <label for="inputId" class="form-label">아이디</label>
				    <input name="id" type="text" class="form-control" value="아이디">
				    <span id="idCheckMsg"></span>
				  </div>
				  <div class="row mb-2">
				    <label for="inputPw" class="form-label">암호</label>
				    <input name="pw" type="password" class="form-control" value="1234">
				    <span id="pwCheckMsg"></span>
				  </div>
				  <div class="row mb-2">
				    <label for="inputPw" class="col-form-label">암호체크</label>
				    <input name="pwCheck" type="password" class="form-control" value="1234">
				    <span id="pwCheckMsg2"></span>
				  </div>
				  <div class="row mb-2">
				    <label for="inputPhone" class="form-label">폰번호</label>
				    <input name="phone" type="text" class="form-control" value="010-1112-1234">
				    <span id="phoneCheck"></span>
				  </div>
				  <div class="row mb-2">
				    <label for="inputEmail" class="form-label">이메일</label>
				    <input name="email" type="text" class="form-control" value="email@eamil.com">
				    <span id="emailCheck"></span>
				  </div>
				  <div class="row mb-2">
				    <label for="inputName" class="form-label">이름	</label>
				    <input name="name" type="text" class="form-control" value="이름">
				  </div>
				  <div class="row mb-2">
				    <label for="inputAddress" class="form-label">주소</label>
				    <input name="address" type="text" class="form-control" value="집주소">
				  </div>
				  <div class="row mb-2">
				    <label for="inputAddressDetail" class="form-label">상세 주소</label>
				    <input name="address_detail" type="text" class="form-control" value="상세집주소">
				  </div>
				  <div class="row mb-2">
				    <label for="inputBirth" class="form-label">생일</label>
				    <input name="birth" type="date" class="form-control" value="2020-12-12">
				  </div>
				  <div class="row mb-2">
				    <label for="inputGrade" class="form-label">등급</label>
				    <input name="grade" type="number" min=0 max=4 class="form-control" value="0">
				  </div>
				  <button class="btn btn-secondary" type="submit">등록</button>
				  <button class="btn btn-dark" type="reset">리셋</button>
				</form>
		  </div>
		  <div class="tab-pane" id="modify" role="tabpanel" aria-labelledby="modify-tab">
		  		<div class="modal" id="updateModar" tabindex="-1">
				  <div class="modal-dialog">
				    <div class="modal-content">
				      <div class="modal-header">
				        <h5 class="modal-title">멤버 수정</h5>
				        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				      </div>
				      <div class="modal-body">
				        <p id="updateMsg"></p>
				      </div>
				      <div class="modal-footer">
				        <button type="button" id="listReloadBtn2" class="btn btn-primary">리스트로</button>
				        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
				      </div>
				    </div>
				  </div>
				</div>
				<div class="modal" id="deleteModar" tabindex="-1">
				  <div class="modal-dialog">
				    <div class="modal-content">
				      <div class="modal-header">
				        <h5 class="modal-title">멤버 삭제</h5>
				        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				      </div>
				      <div class="modal-body">
				        <p id="deleteMsg"></p>
				      </div>
				      <div class="modal-footer">
				        <button type="button" id="listReloadBtn3" class="btn btn-primary">리스트로</button>
				        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
				      </div>
				    </div>
				  </div>
				</div>
		  	<h2>멤버 수정</h2>
		  		<form name="memModifyForm">
				  <div class="row mb-2">
				    <label for="inputId" class="col-sm-1 col-form-label">아이디</label>
				    <div class="col-sm-5">
				      <input name="id" id="id" type="text" class="form-control"  value="">
				    </div>
				  </div>
				  <div class="row mb-2">
				    <label for="inputPw" class="col-sm-1 col-form-label">암호</label>
				    <div class="col-sm-5">
				      <input name="pw" type="password" class="form-control" value="">
				    </div>
				  </div>
				  <div class="row mb-2">
				    <label for="inputPhone" class="col-sm-1 col-form-label">전화번호</label>
				    <div class="col-sm-5">
				      <input name="phone" type="text" class="form-control"  value="">
				    </div>
				  </div>
				  <div class="row mb-2">
				    <label for="inputEmail" class="col-sm-1 col-form-label">이메일</label>
				    <div class="col-sm-5">
				      <input name="email" type="text" class="form-control"  value="">
				    </div>
				  </div>
				  <div class="row mb-2">
				    <label for="inputName" class="col-sm-1 col-form-label">이름	</label>
				    <div class="col-sm-5">
				      <input name="name" type="text" class="form-control" value="">
				    </div>
				  </div>
				  <div class="row mb-2">
				    <label for="inputAddress" class="col-sm-1 col-form-label">주소</label>
				    <div class="col-sm-5">
				      <input name="address" type="text" class="form-control" value="">
				    </div>
				  </div>
				  <div class="row mb-2">
				    <label for="inputAddressDetail" class="col-sm-1 col-form-label">상세 주소</label>
				    <div class="col-sm-5">
				      <input name="address_detail" type="text" class="form-control" value="">
				    </div>
				  </div>
				  <div class="row mb-2">
				    <label for="inputBirth" class="col-sm-1 col-form-label">생일</label>
				    <div class="col-sm-5">
				      <input name="birth" type="date" class="form-control" value="">
				    </div>
				  </div>
				  <div class="row mb-2">
				    <label for="inputSignupTime" class="col-sm-1 col-form-label">등록일</label>
				    <div class="col-sm-5">
				      <input name="signup_time" type="date" class="form-control" value="">
				    </div>
				  </div>
				  <div class="row mb-2">
				    <label for="inputGrade" class="col-sm-1 col-form-label">등급</label>
				    <div class="col-sm-5">
				      <input name="grade" type="number" min=0 max=4 class="form-control" value="">
				    </div>
				  </div>
				  <button type="submit" class="btn  btn-secondary">수정</button>
				  <button class="btn btn-dark" type="reset">리셋</button>
				  <a class="btn btn-danger" href="javascript:void(0)" onclick="memDelete(event)">삭제</a>
				</form>
		  </div>
		</div>
	</div>
</body>
</html>