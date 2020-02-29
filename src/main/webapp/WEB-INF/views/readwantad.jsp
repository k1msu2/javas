<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.WantadVO, java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 구직 게시판 글</h1>
<hr>
<c:if test="${!empty listOne}">
<c:out value="${listOne.post_title}"/><br>
<c:out value="${listOne.post_content}"/><br>
<c:out value="${listOne.post_writedate}"/><br>
</c:if>
<button onclick="location.href='wantad'">구직 게시판으로 </button>
</body>
</html>