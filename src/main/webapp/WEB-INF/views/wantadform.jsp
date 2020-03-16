<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>구직 게시판 작성 폼</h1>
	<form id="wantadform" name="wantadform" method="post">
		작성자 <input id="mem_userid" type="text" name="mem_userid"><br>
		<br> 제목 <input id="post_title" type="text" name="post_title"
			required><br> <br> 내용
		<textarea id="post_content" rows="3" cols="30" name="post_content"></textarea>
		<br>
		<br> 구직 희망 지역 <input id="post_location" type="text"
			name="post_location" required> <br>
		<br> 희망 급여 <input id="post_payment" type="number"
			name="post_payment" required> <br>
		<br> <input id="post_id" type="text" name="newsid"
			style="display: none">
		<button onclick="reqInsertWantad()">등록</button>
		<input type="reset" value="재작성">
		<button onclick="location.href='wantad/form'">취소</button>
	</form>
	<script>
		function reqInsertWantad() {
			var request = new XMLHttpRequest();
			var formElement = document.getElementById("wantadform");
			var formdata = new FormData(formElement);

			request.open('post', '/javas/wantad/insert', true);
			request.send(formdata);

			request.onload = function(event) {
				if (request.status == 200) {
					var str = request.responseText;
					if (str == "success") {
						alert("글 등록 성공");
						window.location.href = "/javas/wantad";
					} else {
						alert("글 등록 실패");
					}
				}
			}
		}
	</script>
</body>
</html>