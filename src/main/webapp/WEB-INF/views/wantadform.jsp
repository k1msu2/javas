<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 구직 게시판 작성 폼</h1>
<form method="post" action="/javas/wantad">
<input id="hidden1" type="hidden" name="action" value="insert">
작성자 <input id="news_writer" type="text" name="writer"><br>
<br> 제목 <input id="news_title" type="text" name="title" required><br>
<br> 내용
<textarea id="news_content" rows="3" cols="30" name="content"></textarea> <br>
구직 희망 지역  <input id="news_title" type="text" name="title" required> <br>
희망 급여  <input id="news_title" type="text" name="title" required > <br>
<input id="news_id" type="text" name="newsid" style="display: none"> 
<input type="submit" value="등록">
<input type="reset" value="재작성">
<button type="button" onclick="location.href='wantad'">취소</button>
</form>
</body>
</html>