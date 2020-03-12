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
</head>
<body>
	<h1>잉력시장</h1>
	<hr>
	<button onclick="logout();">로그아웃</button>
	<h2>마이페이지</h2>
	<div>
		<img width=200px src="/javas/resources/images/none.PNG">
		<c:if test="${!empty loginVO}">
			<h4>
				<c:out value="${loginVO.mem_userid}" />
				님 환영합니다!
			</h4>
		</c:if>
	</div>
	
	<hr>
	<button onclick="location.href='/javas/meminfomodify'">정보수정</button>&nbsp;&nbsp;&nbsp;
	<button>리뷰관리</button><br><br>
	<button>구인게시</button>&nbsp;&nbsp;&nbsp;
	<button>구직게시</button><br>
	<script>
		function logout() {
			location.href = '/javas/resources/logout.jsp';
		};
	</script>
</body>
</html>
