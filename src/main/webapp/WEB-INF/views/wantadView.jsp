<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="vo.WantadVO, vo.LoginVO, vo.PageVO, vo.WantSearchVO, java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>잉력시장 : 구인 게시판</title>
<meta charset="utf-8">

    <link href="https://fonts.googleapis.com/css?family=Do+Hyeon&display=swap" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Do+Hyeon&display=swap" rel="stylesheet">
    
    <link rel="stylesheet" href="/javas/resources/css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="/javas/resources/css/animate.css">
    
    <link rel="stylesheet" href="/javas/resources/css/owl.carousel.min.css">
    <link rel="stylesheet" href="/javas/resources/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="/javas/resources/css/magnific-popup.css">

    <link rel="stylesheet" href="/javas/resources/css/aos.css">
    <link rel="stylesheet" href="/javas/resources/css/ionicons.min.css">
    
    <link rel="stylesheet" href="/javas/resources/css/flaticon.css">
    <link rel="stylesheet" href="/javas/resources/css/icomoon.css">
    <link rel="stylesheet" href="/javas/resources/css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
#delbtn {
	background-color: white;
	color: black;
	border: 2px solid #e7e7e7;
	border-radius: 12px;
}

.checked {
	color: orange;
}
#reviewform{
	padding:20px;
}
#table4{
width:150px;
}
</style>
</head>
<body>
	<div class="bg-top navbar-light d-flex flex-column-reverse">
    	<div class="container py-3">
    		<div class="row no-gutters d-flex align-items-center align-items-stretch">
    			<div class="col-md-4 d-flex align-items-center py-4">
    				<a class="navbar-brand" href="/javas/main" style="font-family: 'Do Hyeon', sans-serif;">잉/력/시/장 <span>Surplus-Power Market</span></a>
    			</div>
	    		<div class="col-lg-8 d-block">
		    		<div class="row d-flex" style="font-family: 'Do Hyeon', sans-serif;">
					    <div class="col-md d-flex topper align-items-center align-items-stretch py-md-4">
					    	<div class="icon d-flex justify-content-center align-items-center"><span class="ion-ios-paper-plane"></span></div>
					    	<div class="text">
					    		<span>Email</span>
						    	<span>surpluspowermarket@gmail.com</span>
						    </div>
					    </div>
					    <div class="col-md d-flex topper align-items-center align-items-stretch py-md-4">
					    	<div class="icon d-flex justify-content-center align-items-center"><span class="ion-ios-call"></span></div>
						    <div class="text">
						    	<span>Call</span>
						    	<span>+123 523 5598</span>
						    </div>
					    </div>
					    <div class="col-md d-flex topper align-items-center align-items-stretch py-md-4">
					    	<div class="icon d-flex justify-content-center align-items-center"><span class="ion-ios-time"></span></div>
						    <div class="text">
						    	<span>Project Period</span>
						    	<span>20200309-20200319</span>
						    </div>
					    </div>
				    </div>
			    </div>
		    </div>
		  </div>
		  <div class="top-social-menu py-2 bg-light" >
		  	<div class="container">
		  		<div class="row">
			    	<div class="col">
			    		<p class="social mb-0">
			    			<a href="#"><i class="ion-logo-facebook"></i><span class="sr-only">Facebook</span></a>
			    			<a href="#"><i class="ion-logo-twitter"></i><span class="sr-only">Twitter</span></a>
			    			<a href="#"><i class="ion-logo-googleplus"></i><span class="sr-only">Googleplus</span></a>
			    		</p>
			    	</div>
			    	<div class="col text-right">
			    		<a href="#" class="btn-link">@JAVAS</a>
			    	</div>
			    </div>
		  	</div>
		  </div>
    </div>
	  <nav class="navbar navbar-expand-lg navbar-dark bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container d-flex align-items-center">
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="oi oi-menu"></span> Menu
	      </button>
	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav mr-auto">
	        	<li class="nav-item"><a href="/javas/main" class="nav-link" style="font-family: 'Do Hyeon', sans-serif; font-size: 20px;">홈</a></li>
	        	<li class="nav-item"><a href="/javas/about" class="nav-link" style="font-family: 'Do Hyeon', sans-serif; font-size: 20px;">소개</a></li>
	        	<li class="nav-item"><a href="/javas/developers" class="nav-link" style="font-family: 'Do Hyeon', sans-serif; font-size: 20px;">개발진</a></li>
	        	<li class="nav-item"><a href="/javas/jobad" class="nav-link" style="font-family: 'Do Hyeon', sans-serif; font-size: 20px;">대타 구인</a></li>
	        	<li class="nav-item active"><a href="/javas/wantad" class="nav-link" style="font-family: 'Do Hyeon', sans-serif; font-size: 20px;">대타 구직</a></li>
				<li class="nav-item">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li class="nav-item">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li class="nav-item">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li class="nav-item">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li class="nav-item">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li class="nav-item">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li class="nav-item">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li class="nav-item">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li class="nav-item">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li class="nav-item">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<li class="nav-item">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				<c:if test="${!empty loginVO}">
					<li class="nav-item"><a href="/javas/mypage" class="nav-link" style="font-family: 'Do Hyeon', sans-serif; font-size: 20px;">마이페이지</a></li>
					<li class="nav-item"><a href="/javas/logout" class="nav-link" style="font-family: 'Do Hyeon', sans-serif; font-size: 20px;">로그아웃</a></li>
				</c:if>         	
				<c:if test="${empty loginVO}">


	          	<li class="nav-item"><a href="/javas/login/form" class="nav-link" style="font-family: 'Do Hyeon', sans-serif; font-size: 20px;">로그인</a></li>
	          	<li class="nav-item"><a href="/javas/meminfo" class="nav-link" style="font-family: 'Do Hyeon', sans-serif; font-size: 20px;">회원가입</a></li>

	          	</c:if>
	        </ul>
	      </div>
	    </div>
	  </nav>
    <!-- END nav -->
    
    
	<section class="hero-wrap hero-wrap-2"
		style="background-image: url('/javas/images/bg_1.jpg');">
		<div class="overlay"></div>
		<div class="container">
			<div
				class="row no-gutters slider-text align-items-center justify-content-center">
				<div class="col-md-9 ftco-animate text-center">
					<h1 class="mb-2 bread">상세 보기</h1>
					<p class="breadcrumbs">
						<span class="mr-2"><a href="/javas/main">홈 <i
								class="ion-ios-arrow-forward"></i></a></span> <span class="mr-2"><a
							href="/javas/wantad">대타 구직<i class="ion-ios-arrow-forward"></i></a></span>
						<span>상세 보기<i class="ion-ios-arrow-forward"></i></span>
					</p>
				</div>
			</div>
		</div>
	</section>

	<section class="ftco-section">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 ftco-animate">
					<!-- 게시글 출력 -->
					<c:if test="${!empty listOne}">
						<div class="about-author d-flex p-4 bg-light">
							<div style = "margin:auto;">
								<img src="/javas/resources/images2/${listOne.mem_userid}.png" width=300>
							</div>
							<div style = "width : 500px; margin-right:100px;">
								<h3>
									<c:out value="${listOne.post_title}" />
								</h3>
							  <table>
								 <tr>
			                        <td id = table4><label for="post_writedate"> 등록일 &nbsp;&nbsp;</label></td><td> <c:out value="${listOne.post_writedate}" /></td>
		                         </tr>
		                         <tr>
			                        <td id = table4><label for="post_content">구직 내용&nbsp;&nbsp;</label></td><td><c:out value="${listOne.post_content}" /></td>
		                         </tr>
		                         <tr>
			                        <td id = table4><label for="post_location">구직 희망 지역&nbsp;&nbsp;</label></td><td><c:out value="${listOne.post_location}" /></td>
		                         </tr>
		                         <tr>
			                        <td id = table4><label for="post_payment">구직 희망 시급&nbsp;&nbsp;</label></td><td><c:out value="${listOne.post_payment}" /></td>
		                         </tr>
							     <tr>
			                        <td id = table4><label for="post_hit">조회수&nbsp;&nbsp;</label></td><td><c:out value="${listOne.post_hit}" /></td>
		                         </tr>
								</table>
								<br>
								<button onclick="location.href='/javas/wantad/modify?id=${listOne.post_id}'" class="btn px-4 btn-primary btn-sm">수정</button>
								<button onclick="delListOne(${listOne.post_id})" class="btn px-4 btn-primary btn-sm">삭제</button>
							</div>
						</div>
					</c:if>

					<!-- 코멘트 출력 -->

					<div class="pt-5 mt-5">
						<div id="reviewlistbox" style="margin:auto 130px;"></div>

						<c:if test="${empty loginVO}">
							<br>
							<br>
							<h4>
								<c:out value="로그인 후, 후기를 남겨주세요" />
							</h4>
						</c:if>

						<c:if test="${!empty loginVO}">
							<!-- 코멘트 입력창 -->
							<div class="comment-form-wrap pt-5" style="width:900px; margin:auto;">
								<div id="reviewformbox">
									<form id="reviewform" name="reviewform" method="post" class="bg-light">

										<label for="review_comment">&nbsp;&nbsp;&nbsp;${loginVO.mem_username}님,
											후기를 남겨주세요!</label>
										<textarea name="review_comment" cols="2" rows="2"
											class="form-control"></textarea>
										<br> <label for="review_rate">&nbsp;&nbsp;&nbsp;만족도&nbsp;&nbsp;&nbsp;</label> 
										<span id= "star1" class="fa fa-star" onclick="star1()"></span> 
										<span id= "star2" class="fa fa-star" onclick="star2()"></span> 
										<span id= "star3" class="fa fa-star" onclick="star3()"></span> 
										<span id= "star4" class="fa fa-star" onclick="star4()"></span> 
										<span id= "star5" class="fa fa-star" onclick="star5()"></span> 
										<input type="hidden" id="review_rate" name="review_rate" value = "0"/>
										<input type="hidden" name="post_id" value="${listOne.post_id}"> 
										<input type="hidden" name="review_id" value="0"> 
										<input type="hidden" name="review_userid" value="${loginVO.mem_userid}"> <br>
										<button onclick="reqInsertReview()" class="btn px-4 btn-primary btn-sm">등록</button>
										<input type="reset" value="재작성" class="btn px-4 btn-primary btn-sm">

									</form>
								</div>
							</div>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- .col-md-8 -->

	<script>

	function delListOne(id){
		var request = new XMLHttpRequest();
		var formdata = new FormData();
		
		formdata.enctype='multipart/form-data';
		formdata.method='post';
		formdata.action='/javas/wantad/deletepost';
		formdata.append('id', id);
		
		request.open('post', '/javas/wantad/deletepost', true);
		request.send(formdata);
		
	 	request.onload = function(event) {
			if (request.status == 200) {
					var str = request.responseText;
					if (str == "success") {
						alert("삭제 성공");
						window.location.href='/javas/wantad';
					} else {
						alert("삭제 실패");
					}
				}
			}
		}
		
		// 리뷰 등록하기
		function reqInsertReview() {
			getTotalStarRate(); // star rate 만..			
			var request = new XMLHttpRequest();
			var formElement = document.getElementById("reviewform");
			var formdata = new FormData(formElement);
			
			request.open('post', '/javas/wantreview/insert', true);
			request.send(formdata);
			
			request.onload = function(event) {
				if (request.status == 200) {
					var str = request.responseText;
					if (str == "success") {
						alert("댓글 등록 성공");
						reqReviewList(); 	
					} else {
						alert("댓글 등록 실패");
					}
				}
			}
		}
		
		function reqDeleteReview(review_id) {
			var request = new XMLHttpRequest();
			var formdata = new FormData();
			
			formdata.enctype='multipart/form-data';
			formdata.method='post';
			formdata.action='/javas/wantreview/delete';
			
			formdata.append('post_id', ${listOne.post_id});
			formdata.append('review_id', review_id);
			console.log(review_id);
			request.open('post', '/javas/wantreview/delete', true);
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
			formdata.action='/javas/wantreview';
			
			formdata.append('post_id', ${listOne.post_id});

			request.open('post', '/javas/wantreview', true);
			request.send(formdata);

			request.onload = function(event) {
				if (request.status == 200) {
					var str = request.responseText;
					var reviewList = JSON.parse(str);
					console.log(reviewList);
					var target = document.getElementById("reviewlistbox");
					target.innerHTML = "";
					for(var i in reviewList){					
					target.innerHTML += "<td width=100>" + reviewList[i].review_userid + "</td> &nbsp; &nbsp;";
					target.innerHTML += "<td width=400>" + reviewList[i].review_comment + "</td> &nbsp; &nbsp;";
					
					var star0 = "<span class='fa fa-star'></span><span class='fa fa-star'></span><span class='fa fa-star'></span><span class='fa fa-star'></span><span class='fa fa-star'></span>";
					var star1 = "<span class='fa fa-star checked'></span><span class='fa fa-star'></span><span class='fa fa-star'></span><span class='fa fa-star'></span><span class='fa fa-star'></span>";   
					var star2 = "<span class='fa fa-star checked'></span><span class='fa fa-star checked'></span><span class='fa fa-star'></span><span class='fa fa-star'></span><span class='fa fa-star'></span>";
					var star3 = "<span class='fa fa-star checked'></span><span class='fa fa-star checked'></span><span class='fa fa-star checked'></span><span class='fa fa-star'></span><span class='fa fa-star'></span>";
					var star4 = "<span class='fa fa-star checked'></span><span class='fa fa-star checked'></span><span class='fa fa-star checked'></span><span class='fa fa-star checked'></span><span class='fa fa-star'></span>";
					var star5 = "<span class='fa fa-star checked'></span><span class='fa fa-star checked'></span><span class='fa fa-star checked'></span><span class='fa fa-star checked'></span><span class='fa fa-star checked'></span>";
											
					if(reviewList[i].review_rate == 0)
						target.innerHTML += "<td width=200>" + star0 + "</td> &nbsp; &nbsp;";
					if(reviewList[i].review_rate == 1)
						target.innerHTML += "<td width=200>" + star1 + "</td> &nbsp; &nbsp;";
					if(reviewList[i].review_rate == 2)
						target.innerHTML += "<td width=200>" + star2 + "</td> &nbsp; &nbsp;";
					if(reviewList[i].review_rate == 3)
						target.innerHTML += "<td width=200>" + star3 + "</td> &nbsp; &nbsp;";
					if(reviewList[i].review_rate == 4)
						target.innerHTML += "<td width=200>" + star4 + "</td> &nbsp; &nbsp;";
					if(reviewList[i].review_rate == 5)
						target.innerHTML += "<td width=200>" + star5 + "</td> &nbsp; &nbsp;";
										
										
					target.innerHTML += "<td width=200>" + reviewList[i].review_date + "</td> &nbsp; &nbsp;";
					if(reviewList[i].review_userid == "${loginVO.mem_userid}"){
						target.innerHTML += "<td><button id='delbtn' onclick='reqDeleteReview("+reviewList[i].review_id+")'>삭제</button></td><br>";
					}
					else {
						target.innerHTML +="<br>";
					}
				}
					target.innerHTML += "</tr></table>";
					
				};
			}
			
		}
		
		window.onload = function(){
			reqReviewList();
		};

		
		function star1(){
			var s1 = document.getElementById("star1").className;
			var s2 = document.getElementById("star2").className;
			var s3 = document.getElementById("star3").className;
			var s4 = document.getElementById("star4").className;
			var s5 = document.getElementById("star5").className;
			

			if(s1=="fa fa-star" && s2 == "fa fa-star" 
			&& s3 == "fa fa-star" && s4 == "fa fa-star" 
			&& s5 == "fa fa-star"){
				document.getElementById("star1").className = "fa fa-star checked";
			} else {
				document.getElementById("star1").className = "fa fa-star";
			}

		}
		
		function star2(){
			var s1 = document.getElementById("star1").className;
			var s2 = document.getElementById("star2").className;
			var s3 = document.getElementById("star3").className;
			var s4 = document.getElementById("star4").className;
			var s5 = document.getElementById("star5").className;
			
			if(s1 == "fa fa-star checked" && s3 == "fa fa-star" 
					&& s4 == "fa fa-star" && s5 == "fa fa-star"){
				if(s2=="fa fa-star"){
					document.getElementById("star2").className = "fa fa-star checked";
				} else {
					document.getElementById("star2").className = "fa fa-star";
				}
			}
			
		}
		
		function star3(){
			var s1 = document.getElementById("star1").className;
			var s2 = document.getElementById("star2").className;
			var s3 = document.getElementById("star3").className;
			var s4 = document.getElementById("star4").className;
			var s5 = document.getElementById("star5").className;
			
			if(s1 == "fa fa-star checked" && s2 == "fa fa-star checked" 
					&& s4 == "fa fa-star" && s5 == "fa fa-star"){
				if(s3=="fa fa-star"){
					document.getElementById("star3").className = "fa fa-star checked";
				} else {
					document.getElementById("star3").className = "fa fa-star";
				}
			}
		}
		
		function star4(){
			var s1 = document.getElementById("star1").className;
			var s2 = document.getElementById("star2").className;
			var s3 = document.getElementById("star3").className;
			var s4 = document.getElementById("star4").className;
			var s5 = document.getElementById("star5").className;

			if(s1 == "fa fa-star checked" && s2 == "fa fa-star checked" 
					&& s3 == "fa fa-star checked" && s5 == "fa fa-star"){
				if(s4=="fa fa-star"){
					document.getElementById("star4").className = "fa fa-star checked";
				} else {
					document.getElementById("star4").className = "fa fa-star";
				}
			}
		}
		
		function star5(){			
			var s1 = document.getElementById("star1").className;
			var s2 = document.getElementById("star2").className;
			var s3 = document.getElementById("star3").className;
			var s4 = document.getElementById("star4").className;
			var s5 = document.getElementById("star5").className;
			
			if(s1 == "fa fa-star checked" && s2 == "fa fa-star checked" 
					&& s3 == "fa fa-star checked" && s4 == "fa fa-star checked"){
				if(s5=="fa fa-star"){
					document.getElementById("star5").className = "fa fa-star checked";
				} else {
					document.getElementById("star5").className = "fa fa-star";
				}
			}
		}
		
		function getTotalStarRate(){
			var s1 = document.getElementById("star1").className;
			var s2 = document.getElementById("star2").className;
			var s3 = document.getElementById("star3").className;
			var s4 = document.getElementById("star4").className;
			var s5 = document.getElementById("star5").className;
			var res = 0;
			if(s1 == "fa fa-star checked") res += 1;
			if(s2 == "fa fa-star checked") res += 1;
			if(s3 == "fa fa-star checked") res += 1;
			if(s4 == "fa fa-star checked") res += 1;
			if(s5 == "fa fa-star checked") res += 1;
			
			//alert(document.getElementById("review_rate").value);
			document.getElementById("review_rate").value=res;
			
			//alert(res);
		}

	</script>
	
  <script src="/javas/resources/js/jquery.min.js"></script>
  <script src="/javas/resources/js/jquery-migrate-3.0.1.min.js"></script>
  <script src="/javas/resources/js/popper.min.js"></script>
  <script src="/javas/resources/js/bootstrap.min.js"></script>
  <script src="/javas/resources/js/jquery.easing.1.3.js"></script>
  <script src="/javas/resources/js/jquery.waypoints.min.js"></script>
  <script src="/javas/resources/js/jquery.stellar.min.js"></script>
  <script src="/javas/resources/js/owl.carousel.min.js"></script>
  <script src="/javas/resources/js/jquery.magnific-popup.min.js"></script>
  <script src="/javas/resources/js/aos.js"></script>
  <script src="/javas/resources/js/jquery.animateNumber.min.js"></script>
  <script src="/javas/resources/js/scrollax.min.js"></script>
  <script src="/javas/resources/js/main.js"></script>
</body>
</html>