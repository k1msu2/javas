<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.WantadVO, vo.WantReviewVO, java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="searchform">
		<form method="get" action="/javas/wantad">
			<select name='searchtype' size='1'>
				<option value='post_title' selected>제목</option>
				<option value='post_content'>내용</option>
				<option value='all'>제목+내용</option>
			</select> 
			<input id="key" type="text" name="key"> 
			<input type="submit" value="게시글 찾기" class="icon icon-search btn btn-primary">
			<button type="button" onclick="location.href='wantad/form'" class="btn btn-primary">
				작성하기</button>
		</form>
	</div>
</body>
</html>