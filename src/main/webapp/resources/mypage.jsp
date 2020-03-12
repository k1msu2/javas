<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="vo.LoginVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>
</head>
<body>
<%
	LoginVO vo = (LoginVO)session.getAttribute("loginVO");
	if(vo==null){
		vo = new LoginVO();
		vo.setMem_username("소중한 나의 고객");
	}
%>
<h1>잉력시장 마이페이지</h1>
<h3><%= vo.getMem_username() %>님 반가워요!</h3>
<hr>
<div>
<button>나의 정보 확인/수정</button>
<button>나의 리뷰 확인하기</button>
</div>
</body>
</html>