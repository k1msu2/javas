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
	<hr>
	<c:if test="${!empty listOne}">
		<c:out value="${listOne.post_title}" />
		<br>
		<c:out value="${listOne.post_content}" />
		<br>
		<c:out value="${listOne.post_writedate}" />
		<br>
	</c:if>
	
	<button onclick="location.href='wantad'">구직 게시판으로</button>
	<button onclick="displayReviewForm()">리뷰작성하기</button>
	<script>
		function displayReviewForm() {
			document.getElementById("review_form").style.display = "block";
		}
		function nondisplayReviewForm(){
			document.getElementById("review_form").style.display = "none";
		}
	</script>
	<!-- 
		private int review_id;
	private int post_id;
	private String review_userid;
	private String review_comment;
	private String review_date;
	private float review_rate;
	 -->
	<section id="review_form_box">
		<div id="review_form" style="display: none">
			<h3>리뷰작성하기</h3>
			<form method="get" action="wantreviewinsert">
			<input id="post_id" name="post_id" value="${listOne.post_id}"><br>
			알바생 아이디<input id="review_userid" name="review_userid"><br>
			알바 후기<textarea id="review_comment" name="review_comment"></textarea><br>
			알바 평점<input id="review_rate" name="review_rate"><br>
			<input type="submit" value="등록">
			<input type="reset" value="재작성">
			<button onclick="nondisplayReviewForm">취소</button>
			</form>
		</div>
	</section>

</body>
</html>