<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.WantadVO, java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#writebtn{
	text-align:right;
	margin-right: 100px;
}
</style>
</head>
<body>
<h1>구직게시판</h1>
<div id="writebtn">
	<button type="button" onclick="location.href='wantadform'">기사 작성하기</button>
</div>

<table class="head">
	<tr>
		<th width=100>번호</th>
		<th width=400>제목</th>
		<th width=100>작성자</th>
		<th width=200>날짜</th>
		<th width=200>조회수</th>
	</tr>
</table>

<c:if test="${!empty listAll}">
<c:forEach var="vo" items="${listAll}" varStatus="status">
<table>
<tr>
<td width=100><c:out value="${vo.post_id}"/></td>
<th width=400>
<a href="/javas/wantad?action=read">
<c:out value="${vo.post_title}"/>
</a>
</th>
<th width=100><c:out value="${vo.mem_userid}"/></th>
<th width=200><c:out value="${vo.post_writedate}"/></th>
<th width=200><c:out value="${vo.post_hit}"/></th>
</tr>
</table>
</c:forEach>
</c:if>

</body>
</html>