<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.LoginVO, java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보</title>
<script src="/javas/resources/juso.js"></script>
</head>
<style>
b {
	color: red;
}

table {
	width: 400px;
	height: 200px;
	margin-left: auto;
	margin-right: auto;
}

</style>
<body>
	<h1>내 정보</h1>
	<hr>
	<br>
	<br>
	<form method="post" action="/javas/meminfoupdate">
		<input type="hidden" name="action" value="update">
		<table>
			<input type="hidden" id="mem_userid" name="mem_userid"
				value="${loginVO.mem_userid}">
			<tr>
				<td><b>*</b> 아이디</td>
				<td>${loginVO.mem_userid}</td>

			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td><b>*</b> 비밀번호</td>
				<td><input id="password"
					style="width: 200px; text-align: left;" type="password"
					name="mem_password" value="${loginVO.mem_password}"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td><b>*</b> 이름</td>
				<td>${loginVO.mem_username}</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td><b>*</b> 이메일</td>
				<td><input id="email" style="width: 200px; text-align: left;"
					type="email" name="mem_email" value="${loginVO.mem_email}"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td><b>*</b> 생일</td>
				<td>${loginVO.mem_birthday}</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td><b>*</b> 성별</td>
				<td>
				<c:if test="${loginVO.mem_sex == 'male'}">
				         남자
				</c:if>
				<c:if test="${loginVO.mem_sex == 'female'}">
					  여자	
				</c:if>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td><b>*</b> 핸드폰 번호</td>
				<td><input id="phone" style="width: 200px; text-align: left;"
					type="number" name="mem_phone" value="${loginVO.mem_phone}"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td><b>*</b> 주소</td>
				<td> <input type="button" value="주소 검색" onclick="goPopup();"><input id="address" style="width: 200px; text-align: left;"
					type="text" name="mem_address" value="${loginVO.mem_address}" class="form-control" required="true" readonly="true"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>구인/구직 일시</td>
				<td><input id="register"
					style="width: 200px; text-align: left;" type="date"
					name="mem_register_date" value="${loginVO.mem_register_date}"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>프로필 사진</td>
				<td><input id="photo" style="width: 200px; text-align: left;"
					type="text" name="mem_photo" value="${loginVO.mem_photo}"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td><b>*</b> 직업</td>
				<td><SELECT name='mem_is_employer'
					value="${loginVO.mem_is_employer}">
						<c:if test="${loginVO.mem_is_employer == 2}">
							<OPTION value='1'>사업자</OPTION>
							<OPTION value='2' selected>파트타이머</OPTION>
						</c:if>
						<c:if test="${loginVO.mem_is_employer == 1}">
							<OPTION value='1' selected>사업자</OPTION>
							<OPTION value='2' >파트타이머</OPTION>
						</c:if>

				</SELECT></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td style="text-align: center;" width="500px">
				<input  onclick="f();" type="submit" value="정보수정"> 
				<input type="reset" value="재작성"> 
				<input onclick="location.href='/javas/mypage'" type="button" value="취소">
				</td>
			</tr>
		</table>
	</form>
</body>
<script>
function f() {
	alert('${ msg1 }');
}
</script>
</html>