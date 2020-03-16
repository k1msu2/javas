<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="vo.WantadVO, vo.LoginVO, vo.PageVO, vo.WantSearchVO, java.util.List"%>
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
	<br>
	<h5><a href="/javas/resources/form.html">메인페이지로...</a></h5>
	<c:if test="${empty loginVO}">
		<button onclick="location.href='/javas/login/form'">로그인 하기</button>
	</c:if>
	<c:if test="${!empty loginVO}">
		<h4>
			<c:out value="${loginVO.mem_userid}" />
			님 환영합니다!
		</h4>
		<button onclick="location.href='/javas/logout'">로그아웃</button>
	</c:if>
	<div id="writebtn">
		<button type="button" onclick="location.href='wantad/form'">
			작성하기</button>
	</div>
	<hr>
	<table class="head">
		<tr>
			<th width=100>번호</th>
			<th width=100>작성자</th>
			<th width=400>제목</th>
			<th width=100>내용</th>
			<th width=200>날짜</th>
			<th width=200>조회수</th>
			<th width=200>구직희망지역</th>
			<th width=100>구직희망급여</th>
			<th width=100>리뷰수</th>
		</tr>
	</table>

	<c:if test="${!empty listAll}">
		<c:forEach var="vo" items="${listAll}" varStatus="status">
			<table>
				<tr
					style="table-layout: fixed; text-overflow: ellipsis; overflow: hidden; white-space: nowrap;"
					onmouseover="this.style.background='Gainsboro'"
					onmouseout="this.style.background='white'"
					onclick="location.href='/javas/wantad/view?id=${vo.post_id}'">

					<td width=100><c:out value="${vo.post_id}" /></td>
					<th width=100><c:out value="${vo.mem_userid}" /></th>
					<th width=400><c:out value="${vo.post_title}" /></th>
					<th width=100><c:out value="${vo.post_content}" /></th>
					<th width=200><c:out value="${vo.post_writedate}" /></th>
					<th width=200><c:out value="${vo.post_hit}" /></th>
					<th width=200><c:out value="${vo.post_location}" /></th>
					<th width=100><c:out value="${vo.post_payment}" /></th>
					<th width=100><c:out value="${vo.post_review_count}" /></th>

				</tr>
			</table>
		</c:forEach>
	</c:if>
	<hr>
	<br>
	<div id="pages"></div>
	<%@ include file="wantsearchform.jsp"%>
	<%@ include file="wantadpage.jsp"%>
</body>
</html>