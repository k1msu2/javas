<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="vo.WantadVO, vo.WantadLocVO, vo.LoginVO, vo.PageVO, vo.WantSearchVO, java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>잉력시장</title>
<link rel="stylesheet"
	href="https://unpkg.com/leaflet@1.5.1/dist/leaflet.css"
	integrity="sha512-xwE/Az9zrjBIphAcBb3F6JVqxf46+CDLwfLMHloNu6KEQCAWi6HcDUbeOfBIptF7tcCzusKFjFw2yuvEpDL9wQ=="
	crossorigin="" />
<script src="https://unpkg.com/leaflet@1.5.1/dist/leaflet.js"
	integrity="sha512-GffPMF3RvMeYyc1LWMHtK8EbPv0iNZ8/oTtHPx9/cc2ILxQ+u905qIwdpULaqDkyBKgOaB57QTMg7ztg8Jm2Og=="
	crossorigin=""></script>
<style>
#mapid {
	width: 500px;
	height: 1200px;
	margin: auto;
}
</style>
</head>
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
		style="background-image: url('images/bg_1.jpg');">
		<div class="overlay"></div>
		<div class="container">
			<div
				class="row no-gutters slider-text align-items-center justify-content-center">
				<div class="col-md-9 ftco-animate text-center">
					<h1 class="mb-2 bread">대타 구직</h1>
						  <p class="breadcrumbs"><span class="mr-2"><a href="/javas/main">홈 <i class="ion-ios-arrow-forward"></i></a></span> <span>구직 게시판 <i class="ion-ios-arrow-forward"></i></span></p>
				</div>
			</div>
		</div>
	</section>
	
	  <br><br>
           <c:if test="${!empty loginVO}">
             <div class="icon d-flex justify-content-center align-items-center"><span><img width=80px src="/javas/resources/images/none.PNG"></span></div>
			<div class="text" style="text-align : center; font-family: 'Do Hyeon', sans-serif;">
			       <h4><c:out value="${loginVO.mem_username}" />님 환영합니다!</h4>
		         </c:if>
		    </div>
     <br>
   <hr style="width : 85%;">
   
	<section class="ftco-section">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 ftco-animate">
					<c:if test="${!empty listAll}">
						<c:forEach var="vo" items="${listAll}" varStatus="status">
							<!-- <div class="col-md-6 col-lg-4 ftco-animate"> -->
							<div class="blog-entry">
								<a href="wantad/view?id=${vo.post_id}"> </a>
								<div class="text border border-top-0 p-4">
									<h3 class="heading">
										<a href="wantad/view?id=${vo.post_id}"> 
										<c:out value="${vo.post_title}" /></a>
									</h3>
									<p>
										<c:out value="${vo.post_content}" />
									</p>
									<div class="d-flex align-items-center mt-4">
										<p class="mb-0">
											<button
												onclick="location.href='/javas/wantad/view?id=${vo.post_id}'"
												class="btn btn-primary">
												더보기.. <span class="ion-ios-arrow-round-forward"></span>
											</button>
										</p>
										<p class="ml-auto mb-0">
											<a href="#" class="mr-2"><c:out value="${vo.mem_userid}" />
												님</a> <a href="#" class="meta-chat"><span class="icon-chat"></span>
												<c:out value="${vo.post_review_count}" /></a>
										</p>
									</div>
								</div>
								<!-- 	</div> -->
							</div>
						</c:forEach>
					</c:if>
					<div class="row mt-5">
						<div class="col text-center">
							<div class="block-27">
								<div id="pages">
									<%-- <%@ include file="wantadpage.jsp"%> --%>
								</div>
								<%@ include file="wantsearchform.jsp"%>
							</div>
						</div>
					</div>
				</div>
				<!-- .col-md-8 -->


				<div class="col-lg-6 sidebar ftco-animate">
	                                                                  <div class="sidebar-box ftco-animate">
						<div id="mapid"></div>
					</div>
				</div>
			</div>
		</div>
	</section>


<br><br><br>
     <footer class="ftco-footer ftco-bg-dark ftco-section">
    <h2 style = "color : #ffffff; text-align : center;">Have a Questions?</h2>
    <div style = "text-align : center;">
    <span class="icon icon-map-marker"></span><span class="text">212 Teheran-ro, Gangnam-gu, Seoul, Republic of Korea (06220)</span>
	              <br><a href="#"><span class="icon icon-phone"></span><span class="text">+2 392 3929 210</span></a>
	              <br><a href="#"><span class="icon icon-envelope"></span><span class="text">surpowermarket@gmail.com</span></a>
    </div>
    <br><br><br>
 <p style = "text-align : center;"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
  Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">@JAVAS</a>
  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
    </footer>


	<script src="js/jquery.min.js"></script>
	<script src="js/jquery-migrate-3.0.1.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.easing.1.3.js"></script>
	<script src="js/jquery.waypoints.min.js"></script>
	<script src="js/jquery.stellar.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/aos.js"></script>
	<script src="js/jquery.animateNumber.min.js"></script>
	<script src="js/scrollax.min.js"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
	<script src="js/google-map.js"></script>
	<script src="js/main.js"></script>
	<script>
	
		var mymap;
		var lat;
		var lng;
		var googleApiUrlToLatlng = "https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyD8k2DWC_7yFHCrH6LDR3RfITsmWMEqC8c&address=";
		var googleApiUrlToAddr = "http://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyD8k2DWC_7yFHCrH6LDR3RfITsmWMEqC8c&latlng="; //+ latitude + "," + longitude
		var xhr = new XMLHttpRequest();

 	 	window.onload = function(){
 			// 페이징
 			document.getElementById("pages").innerHTML += "<a href='/javas/wantad?page=${pageVO.pageBeginNum-1}&searchtype=${searchVO.searchtype}&key=${searchVO.key}'>${pageVO.leftChar}</a>&nbsp&nbsp";

			for (var i = "${pageVO.pageBeginNum}"; i <= "${pageVO.pageEndNum}"; i++) {
				document.getElementById("pages").innerHTML += "<a href='/javas/wantad?page="
						+ i
						+ "&searchtype=${searchVO.searchtype}&key=${searchVO.key}'>"
						+ i + "</a>&nbsp&nbsp";
			}
			document.getElementById("pages").innerHTML += "<a href='/javas/wantad?page=${pageVO.pageEndNum+1}&searchtype=${searchVO.searchtype}&key=${searchVO.key}'>${pageVO.rightChar}</a>&nbsp&nbsp<br><br>";
			
			// 0. 현재 위치로 set
			getLocation();

			// 1. 서버에 리스트 데이터를 json 파일로 요청
			// 이거 하고나면 paging 이 이상해짐..
			// window.onload 를 주석 처리하면 정상적으로 나옴.
			// -> windowload 가 두번 사용됨;;
			xhr.open('post', '/javas/wantad/json', true);
			xhr.send();

			xhr.onload = function(event) {
				if (xhr.status == 200) {
					var str = xhr.responseText;
					var wantadList = JSON.parse(str);
					console.log(wantadList);
					// 2. 구글 맵을 for문으로 돌려서 출력
					for ( var i in wantadList) {
						showGoogleMap(wantadList[i].post_location);
					}
				}
			}
		};  

		function showGoogleMap(addr) {
			var xhr2 = new XMLHttpRequest();
			xhr2.open("GET", googleApiUrlToLatlng + encodeURIComponent(addr), true);
			xhr2.send();
			xhr2.onload = function() {
				if (xhr2.status == 200) {
					var data = JSON.parse(xhr2.responseText);
					//console.log(data);
					lat = data.results[0].geometry.location.lat;
					lng = data.results[0].geometry.location.lng;
					//console.log(mymap);
					
					/* 지역 추가가 정상 적으로 되었을 경우 다시 주석 풀기 */
					//L.marker([ lat, lng ]).addTo(mymap);
				}
			}
		}
		
		function getLocation(){
			var x = document.getElementById("demo");
			if (navigator.geolocation) {
				navigator.geolocation.getCurrentPosition(showPosition,
						showError);
			} else {
				x.innerHTML = " 이 브라우저는 geolocation을 지원하지 않습니다.";
			}
		}
		
		function showPosition(position) {

			lat = position.coords.latitude;
			lng = position.coords.longitude;

			mymap = L.map('mapid').setView([ lat, lng ], 12)
			L.tileLayer(
					'https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpejY4NXVycTA2emYycXBndHRqcmZ3N3gifQ.rJcFIG214AriISLbB6B5aw',
					{
						maxZoom : 18,
						attribution : 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, '
								+ '<a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, '
								+ 'Imagery <a href="https://www.mapbox.com/">Mapbox</a>',
						id : 'mapbox.streets'
					}).addTo(mymap);
			L.marker([ lat, lng ]).addTo(mymap);
		}
		function showError(error) {
			switch (error.code) {
			case error.PERMISSION_DENIED:
				x.innerHTML = "사용자가 위치 기능 사용을 거부했습니다."
				break;

			case error.POSITION_UNAVAILABLE:
				x.innerHTML = "위치를 구할 수 없습니다.";
				break;

			case error.TIMEOUT:
				x.innerHTML = "사용자가 위치 기능 사용을 거부했습니다.";
				break;

			case error.UNKNOWN_ERROR:
				x.innerHTML = "기타 에러";
				break;
			}
		}
	</script>
</body>
</html>