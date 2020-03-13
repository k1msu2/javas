<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.MeminfoVO, java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>잉력시장</title>
<link rel="stylesheet" href="./css/bootstrap.min.css"> 
<link rel="stylesheet" href="./css/bootstrap-theme.min.css">

</head>
<body>
<h1>잉력시장</h1>
<hr>
<button onclick="location.href='/javas/resources/meminfo.jsp'">회원가입</button>

<c:if test="${mem_userid == null">
&nbsp;&nbsp;&nbsp;<button onclick="location.href='loginForm.html'">로그인</button>
</c:if>
<c:if test="${mem_userid != null">
&nbsp;&nbsp;&nbsp;<button>마이페이지</button>
</c:if>
<!-- 잉력시장 메인 화면을 제 나름대로 만들었습니다. 여기서 회원가입 버튼을 클릭하면 회원가입으로 넘어갑니다. -->
<!-- 마이 페이지는 로그인이 먼저 된 뒤 활성화 되었으면 좋겠습니다.  -->

</body>
</html>

