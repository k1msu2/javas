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
	<div class="container">
		<div id="reviewlistbox"></div>
	</div>
	
	<div class="container">
		<div id="reviewformbox">
			<form id="reviewform" name="reviewform" method="post">
				<input type="hidden" id="post_id" name="post_id" value="${vo.post_id}"><br> 
				<input type="hidden" id="review_userid" name="review_userid" value="mem01"> 
				알바후기 <textarea id="review_comment" name="review_comment"></textarea>
				알바 평점<input id="review_rate" name="review_rate"> 
				<input type="hidden" id="review_id" name="review_id" value="0">
				<button onclick="reqInsertReview()">등록</button>
				<input type="reset" value="재작성">
			</form>
		</div>
	</div>
	
	<script>
		// 리뷰 등록하기
		function reqInsertReview() {
			var request = new XMLHttpRequest();
			var formElement = document.getElementById("reviewform");
			var formdata = new FormData(formElement);
			
			request.open('post', '/javas/jobreviewinsert', true);
			request.send(formdata);
			
			request.onload = function(event) {
				var str = request.responseText;
				if (str == "success") {
					alert("댓글 등록 성공");
					reqReviewList();
				} else {
					alert("댓글 등록 실패");
				}
			}
		}
		
		function reqDeleteReview(review_id) {
			var request = new XMLHttpRequest();
			var formdata = new FormData();
			
			formdata.enctype='multipart/form-data';
			formdata.method='post';
			formdata.action='/javas/jobreviewdelete';
			
			formdata.append('review_id', review_id);
			console.log(review_id);
			request.open('post', '/javas/jobreviewdelete', true);
			request.send(formdata);

			request.onload = function(event) {
				if (request.status == 200) {
					var str = request.responseText;
					if (str == "success") {
						alert("댓글 삭제 성공");
						reqReviewList();

					} else {
						alert("댓글 삭제 실패");
					}
				}
			}
		}
		function reqReviewList() {
			var request = new XMLHttpRequest();
			var formdata = new FormData();
			
			formdata.enctype='multipart/form-data';
			formdata.method='post';
			formdata.action='/javas/jobreview';
			
			formdata.append('post_id', ${vo.post_id});

			request.open('post', '/javas/jobreview', true);
			request.send(formdata);
			
			request.onload = function(event) {
				if (request.status == 200) {
					var str = request.responseText;
					var reviewList = JSON.parse(str);
					console.log(reviewList);
					var target = document.getElementById("reviewlistbox");
					target.innerHTML = "<table><tr>";
					for(var i in reviewList){					
					target.innerHTML += "<td width=100>" + reviewList[i].review_userid + "</td> &nbsp; &nbsp;";
					target.innerHTML += "<td width=400>" + reviewList[i].review_comment + "</td> &nbsp; &nbsp;";
					target.innerHTML += "<td width=200>" + reviewList[i].review_rate + "</td> &nbsp; &nbsp;";
					target.innerHTML += "<td width=200>" + reviewList[i].review_date + "</td> &nbsp; &nbsp;";
					target.innerHTML += "<td><button>수정</button></td> &nbsp;";
					target.innerHTML += "<td><button onclick='reqDeleteReview("+reviewList[i].review_id+")'>삭제</button></td><br>";
					}
					target.innerHTML += "</tr></table>"
					
				}
			}
			
		}

		// 초기 페이지 로딩 시 댓글 불러오기
		window.onload = function() {
			reqReviewList();
		}
	</script>

</body>
</html>