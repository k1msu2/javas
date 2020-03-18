<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.WantadVO, vo.WantReviewVO, java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>잉력시장 : 작성하기[구직]</title>
</head>
<body>
	<h1>구직 게시판 작성 폼</h1>
	<form id="wantadform" name="wantadform" method="post">
		작성자 <input id="mem_userid" type="text" name="mem_userid" value="${listOne.mem_userid}"><br>
		<br> 제목 <input id="post_title" type="text" name="post_title"
			value="${listOne.post_title}"><br> <br> 내용
		<textarea id="post_content" rows="3" cols="30" name="post_content"
			value = "${listOne.post_content}"></textarea>
		<br>
		<br> 구직 희망 지역 <input id="post_location" type="text"
			name="post_location" value= "${listOne.post_location}"> <br>
		<br> 희망 급여 <input id="post_payment" type="number"
			name="post_payment" value = "${listOne.post_payment}"> <br>
		<br> <input id="post_id" type="text" name="post_id" style="display: none" value="${listOne.post_id}">
		<button onclick="reqUpdateWantad()">등록</button>
		<input type="reset" value="재작성">
		<button onclick="location.href='wantad/modify'">취소</button>
	</form>
	<script>
		function reqUpdateWantad() {
			var request = new XMLHttpRequest();
			var formElement = document.getElementById("wantadform");
			var formdata = new FormData(formElement);

			request.open('post', '/javas/wantad/update', true);
			request.send(formdata);

			request.onload = function(event) {
				if (request.status == 200) {
					var str = request.responseText;
					if (str == "success") {
						alert("글 수정 성공");
						window.location.href = "/javas/wantad";
					} else {
						alert("글 수정 실패");
					}
				}
			}
		}
	</script>
</body>
</html>