<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page
	import="vo.WantadVO, vo.LoginVO, vo.PageVO, vo.WantSearchVO, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
		window.onload = function() {
			document.getElementById("pages").innerHTML += "<a href='/javas/wantad?page=${pageVO.pageBeginNum-1}&searchtype=${searchVO.searchtype}&key=${searchVO.key}'>${pageVO.leftChar}</a>&nbsp&nbsp";

			for (var i = "${pageVO.pageBeginNum}"; i <= "${pageVO.pageEndNum}"; i++) {
				document.getElementById("pages").innerHTML += "<a href='/javas/wantad?page="
						+ i
						+ "&searchtype=${searchVO.searchtype}&key=${searchVO.key}'>"
						+ i + "</a>&nbsp&nbsp";
			}
			document.getElementById("pages").innerHTML += "<a href='/javas/wantad?page=${pageVO.pageEndNum+1}&searchtype=${searchVO.searchtype}&key=${searchVO.key}'>${pageVO.rightChar}</a>&nbsp&nbsp<br><br>";
		};
	</script>
</body>
</html>