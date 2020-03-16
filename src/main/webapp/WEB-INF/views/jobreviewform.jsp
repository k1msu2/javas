<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.JobadVO, vo.JobReviewVO,vo.LoginVO, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% LoginVO loginVO2 = (LoginVO)session.getAttribute("loginVO"); 
if(loginVO2==null){
	loginVO2 = new LoginVO();
}
%>
	<div class="container">
		<div id="reviewlistbox"></div>
	</div>
	
	<div class="container">
		<div id="reviewformbox">
			<form id="reviewform" name="reviewform" method="post">
				<input type="hidden" id="post_id" name="post_id" value="${vo.post_id}"><br> 
				<input type="hidden" id="review_userid" name="review_userid" value="<%= loginVO2.getMem_userid() %>">
				<input type="hidden" id="action" name="action" value="insert"> 
				알바후기 <textarea id="review_comment" name="review_comment"></textarea>
				알바 평점<input id="review_rate" name="review_rate"> 
				<input type="hidden" id="review_id" name="review_id" value="0">
				<input type="button" value="등록" onclick="reqInsertReview();">
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
			console.log(formdata);
			request.open('post', '/javas/jobreviewinsert', true);
			request.send(formdata);
			
			request.onload = function(event) {
				var str = request.responseText;
				reqReviewList();	
			}
		}
		function reqUpdateReview(review_id) {
			var request = new XMLHttpRequest();
			var formElement = document.getElementById("reviewform");
			var formdata = new FormData(formElement);
			
			formdata.enctype='multipart/form-data';
			formdata.method='post';
			formdata.action='/javas/jobreviewupdate';
			
			formdata.append('review_id', review_id);
			console.log(review_id);
			request.open('post', '/javas/jobreviewupdate', true);
			request.send(formdata);

			request.onload = function(event) {
				if (request.status == 200) {
					var str = request.responseText;
					reqReviewList();
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
					reqReviewList();	
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
					target.innerHTML += "<td><button onclick='reqUpdateReview("+reviewList[i].review_id+")'>수정</button></td> &nbsp;";
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