<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="vo.WantadVO, vo.LoginVO, vo.PageVO, vo.WantSearchVO, java.util.List"%>
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
<title>Negotiate - Free Bootstrap 4 Template by Colorlib</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link
	href="https://fonts.googleapis.com/css?family=Do+Hyeon&display=swap"
	rel="stylesheet">

<link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
<link rel="stylesheet" href="css/animate.css">

<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">
<link rel="stylesheet" href="css/magnific-popup.css">

<link rel="stylesheet" href="css/aos.css">

<link rel="stylesheet" href="css/ionicons.min.css">

<link rel="stylesheet" href="css/flaticon.css">
<link rel="stylesheet" href="css/icomoon.css">
<link rel="stylesheet" href="css/style.css">

<body>
	<div class="bg-top navbar-light d-flex flex-column-reverse">
		<div class="container py-3">
			<div
				class="row no-gutters d-flex align-items-center align-items-stretch">
				<div class="col-md-4 d-flex align-items-center py-4">
					<a class="navbar-brand" href="index.html"
						style="font-family: 'Do Hyeon', 'sans-serif'">잉/력/시/장 <span>surpluspower
							market</span></a>
				</div>
				<div class="col-lg-8 d-block">
					<div class="row d-flex">
						<div
							class="col-md d-flex topper align-items-center align-items-stretch py-md-4">
							<div
								class="icon d-flex justify-content-center align-items-center">
								<span class="ion-ios-paper-plane"></span>
							</div>
							<div class="text">
								<span>Email</span> <span>surpluspowermarket@gmail.com</span>
							</div>
						</div>
						<div
							class="col-md d-flex topper align-items-center align-items-stretch py-md-4">
							<div
								class="icon d-flex justify-content-center align-items-center">
								<span class="ion-ios-call"></span>
							</div>
							<div class="text">
								<span>Call</span> <span>+123 523 5598</span>
							</div>
						</div>
						<div
							class="col-md d-flex topper align-items-center align-items-stretch py-md-4">
							<div
								class="icon d-flex justify-content-center align-items-center">
								<span class="ion-ios-time"></span>
							</div>
							<div class="text">
								<span>Project Period</span> <span>20200309-20200319</span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="top-social-menu py-2 bg-light">
			<div class="container">
				<div class="row">
					<div class="col">
						<p class="social mb-0">
							<a href="#"><i class="ion-logo-facebook"></i><span
								class="sr-only">Facebook</span></a> <a href="#"><i
								class="ion-logo-twitter"></i><span class="sr-only">Twitter</span></a>
							<a href="#"><i class="ion-logo-googleplus"></i><span
								class="sr-only">Googleplus</span></a>
						</p>
					</div>
					<div class="col text-right">
						<a href="#" class="btn-link">@JAVAS</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<nav
		class="navbar navbar-expand-lg navbar-dark bg-dark ftco-navbar-light"
		id="ftco-navbar">
		<div class="container d-flex align-items-center">
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#ftco-nav" aria-controls="ftco-nav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="oi oi-menu"></span> Menu
			</button>
			<div class="collapse navbar-collapse" id="ftco-nav">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a href="/javas/main"
						class="nav-link">홈</a></li>
					<li class="nav-item"><a href="about.html" class="nav-link">소개</a></li>
					<li class="nav-item"><a href="team.html" class="nav-link">팀원</a></li>
					<li class="nav-item"><a href="/javas/jobad" class="nav-link">대타
							구인</a></li>
					<li class="nav-item"><a href="/javas/wantad" class="nav-link">대타
							구직</a></li>

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
					<li class="nav-item">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
					<li class="nav-item">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
					<c:if test="${!empty loginVO}">
						<li class="nav-item"><a href="/javas/mypage" class="nav-link">마이페이지</a></li>
						<li class="nav-item"><a href="/javas/logout" class="nav-link">로그아웃</a></li>
					</c:if>
					<c:if test="${empty loginVO}">
						<li class="nav-item"><a href="/javas/login/form"
							class="nav-link">로그인</a></li>
						<li class="nav-item"><a href="/javas/resources/meminfo.jsp"
							class="nav-link">회원가입</a></li>
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
					<c:if test="${!empty loginVO}">
						<h3 class="mb-2 bread">
							<c:out value="${loginVO.mem_userid}" />
							님 환영합니다!
						</h3>
					</c:if>
					<p class="breadcrumbs">
						<span class="mr-2"><a href="/javas/main">Home <i
								class="ion-ios-arrow-forward"></i></a></span>
					</p>
				</div>
			</div>
		</div>
	</section>

	<section class="ftco-section">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 ftco-animate">
					<c:if test="${!empty listAll}">
						<c:forEach var="vo" items="${listAll}" varStatus="status">
							<!-- <div class="col-md-6 col-lg-4 ftco-animate"> -->
							<div class="blog-entry">
								<a href="wantad/view?id=${vo.post_id}">
								</a>
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
									<%@ include file="wantadpage.jsp"%>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- .col-md-8 -->


				<div class="col-lg-6 sidebar ftco-animate">
					<div class="sidebar-box">
						<form action="#" class="search-form">
							<div class="form-group">
								<span class="icon icon-search"></span> <input type="text"
									class="form-control" placeholder="xx동을 입력하세요">
							</div>
						</form>
						<p id="demo">현재 위치에서 검색하려면 버튼을 누르세요</p>
						<button onclick="getLocation()">실행</button>
						<br>
						<br>
					</div>
					<div class="sidebar-box ftco-animate">
						<div id="mapid"></div>
					</div>
				</div>
			</div>
	</section>

	<!-- loader -->
	<div id="ftco-loader" class="show fullscreen">
		<svg class="circular" width="48px" height="48px">
			<circle class="path-bg" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke="#eeeeee" />
			<circle class="path" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke-miterlimit="10" stroke="#F96D00" /></svg>
	</div>

	<script>
		var x = document.getElementById("demo");
		function getLocation() {
			if (navigator.geolocation) {
				navigator.geolocation.getCurrentPosition(showPosition,
						showError);
			} else {
				x.innerHTML = " 이 브라우저는 geolocation을 지원하지 않습니다.";
			}
		}
		function showPosition(position) {
			x.innerHTML = "위도: " + position.coords.latitude + "<br />경도: "
					+ position.coords.longitude;

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
		var googleApiUrl = "https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyD8k2DWC_7yFHCrH6LDR3RfITsmWMEqC8c&address=";

		var greenIcon = L
				.icon({
					iconUrl : 'http://70.12.115.164:8000/d3edu/images/leaf-green.png',
					shadowUrl : 'http://70.12.115.164:8000/d3edu/images/leaf-shadow.png',

					iconSize : [ 38, 95 ],
					shadowSize : [ 50, 64 ],
					iconAnchor : [ 22, 94 ],
					shadowAnchor : [ 4, 62 ],
					popupAnchor : [ -3, -76 ]
				});

		var redIcon = L
				.icon({
					iconUrl : 'http://70.12.115.164:8000/d3edu/images/leaf-red.png',
					shadowUrl : 'http://70.12.115.164:8000/d3edu/images/leaf-shadow.png',

					iconSize : [ 38, 95 ],
					shadowSize : [ 50, 64 ],
					iconAnchor : [ 22, 94 ],
					shadowAnchor : [ 4, 62 ],
					popupAnchor : [ -3, -76 ]
				});

		var xhr = new XMLHttpRequest();
		xhr.open("GET", googleApiUrl + encodeURIComponent("청주시"), true);
		xhr.send();
		xhr.onload = function() {
			if (xhr.status == 200) {
				var data = JSON.parse(xhr.responseText);
				console.log(data);
				lat = data.results[0].geometry.location.lat;
				lng = data.results[0].geometry.location.lng;
				console.log(mymap);
				if (mymap)
					mymap.remove();
				mymap = L.map('mapid').setView([ lat, lng ], 8)
				L
						.tileLayer(
								'https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpejY4NXVycTA2emYycXBndHRqcmZ3N3gifQ.rJcFIG214AriISLbB6B5aw',
								{
									maxZoom : 18,
									attribution : 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, '
											+ '<a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, '
											+ 'Imagery <a href="https://www.mapbox.com/">Mapbox</a>',
									id : 'mapbox.streets'
								}).addTo(mymap);

				L.marker([ lat, lng ], {
					icon : greenIcon
				}).addTo(mymap).bindPopup("<b>" + "test").openPopup();

			}
		};
	</script>
</body>
</html>