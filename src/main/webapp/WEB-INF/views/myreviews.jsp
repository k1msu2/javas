<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.WantReviewVO, java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
table {
 width : 900px;
 height: 40px;
 text-align : center;
}
tr,th {
  border-bottom: 1px solid #444444;
  border-light: 1px solid #444444;
  text-align : center;
}
</style>
<body>
	<table class="head">
		<tr>
			<th width=100>글번호</th>
			<th width=100>리뷰번호</th>
			<th width=300>내용</th>
			<th width=100>작성자</th>
			<th width=200>날짜</th>
			<th width=100>별점</th>
		</tr>
	</table>

	<c:if test="${!empty listReviewAll}">
		<c:forEach var="vo" items="${listReviewAll}" varStatus="status">
			<table>
				<tr>
					<td width=100><c:out value="${vo.post_id}" /></td>
					<td width=100><c:out value="${vo.review_id}" /></td>
					<th width=100><c:out value="${vo.review_userid}" /></th>
					<th width=400><c:out value="${vo.review_comment}" /></th>
					<th width=200><c:out value="${vo.review_date}" /></th>
					<th width=100><c:out value="${vo.review_rate}" /></th>
				</tr>
			</table>
		</c:forEach>
	</c:if>
</body>
</html>