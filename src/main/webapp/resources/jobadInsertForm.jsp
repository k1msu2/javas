<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구인 게시판 새 글 작성</title>
</head>
<body>

<div>
<form method="post" action="/javas/jobad">
	<input type="hidden" name="action" value="insert">
	<input type="hidden" name="pgNum" value="${sessionScope.pgNum}">
	<input type="hidden" name="post_id" value="1">
	글 제목 : <input type="text" name="post_title"><br>
	내용 : <input type="text" name="post_content"><br>
	위치 : <input type="text" name="post_location"><br>
	시급 : <input type="number" name="post_payment"><br>
	전화번호 : <input type="text" name="post_phone"><br>
	<input type="submit" value="새 글 작성">
</form>
<a href="${header.referer}">작성 취소</a>
</div>

</body>
</html>