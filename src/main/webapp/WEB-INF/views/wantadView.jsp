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
	<h1>구직 게시판 글</h1>
	<button onclick="location.href='/javas/wantad/'">구직 게시판으로</button>
	<hr>
	<c:if test="${!empty listOne}">
		<c:out value="${listOne.post_title}" />
		<br>
		<c:out value="${listOne.post_content}" />
		<br>
		<c:out value="${listOne.post_writedate}" />
		<br>
	</c:if>
	<button onclick="location.href='/javas/wantad/modify'">수정</button>
	<button onclick="location.href='/javas/wantad/delete'">삭제</button>
	<hr>
	<%@ include file="reviewform.jsp" %>
</body>
</html>