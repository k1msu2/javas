<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.WantadVO, vo.PageVO, vo.WantSearchVO, java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#writebtn {
	text-align: right;
	margin-right: 100px;
}

#pages {
	text-align: center;
}

a {
	text-decoration: none;
}
</style>
</head>
<body>
	<h1>구직게시판</h1>
	<div id="writebtn">
		<button type="button" onclick="location.href='wantadform'">기사
			작성하기</button>
	</div>
	<hr>
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
					<td width=100><c:out value="${vo.post_id}" /></td>
					<th width=400><a href="/javas/readwantad?id=${vo.post_id}">
							<c:out value="${vo.post_title}" />
					</a></th>
					<th width=100><c:out value="${vo.mem_userid}" /></th>
					<th width=200><c:out value="${vo.post_writedate}" /></th>
					<th width=200><c:out value="${vo.post_hit}" /></th>
				</tr>
			</table>
		</c:forEach>
	</c:if>
	<hr>
	<br>
	<div id="pages">
	</div>
	<%@ include file="wantsearchform.jsp" %>
	<script>
		window.onload = function(){
			// post로 변경하기
			document.getElementById("pages").innerHTML += 
				"<a href='/javas/wantad?page=${pageVO.pageBeginNum-1}&searchtype=${searchVO.searchtype}&key=${searchVO.key}'>${pageVO.leftChar}</a>&nbsp&nbsp";
			for(var i = "${pageVO.pageBeginNum}"; i <= "${pageVO.pageEndNum}"; i++){
				document.getElementById("pages").innerHTML += "<a href='/javas/wantad?page=" + i + "&searchtype=${searchVO.searchtype}&key=${searchVO.key}'>"+ i + "</a>&nbsp&nbsp";				
			}
			document.getElementById("pages").innerHTML += 
				"<a href='/javas/wantad?page=${pageVO.pageEndNum+1}&searchtype=${searchVO.searchtype}&key=${searchVO.key}'>${pageVO.rightChar}</a>&nbsp&nbsp";
		};
	</script>
	
</body>
</html>