<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${path}/css/common.css?v=1">
<link rel="stylesheet" href="${path}/css/header.css?v=1">
<title>BOUQUET</title>
</head>
<body>
	<div id="modal">
		<div id="modal_login">
			<header>
			<div class="header_logo">L O G I N</div>
		</header>
		<section>
			<div class="input_tag">
				<input type="text" class="idpw" id="login_id" name="" placeholder="아이디를 입력해주세요"></input>
				<span class="err_code">아이디를 입력해주세요.</span>
			</div>
			<div class="input_tag">
				<input type="password" class="idpw" id="login_pw" name="" placeholder="비밀번호를 입력해주세요"></input>
				<span class="err_code">비밀번호를 입력해주세요.</span>
			</div>
			<div class="idpw_find">
				<span class="id_find">아이디 찾기</span>
				<span>|</span>
				<span class="pw_find">비밀번호 찾기</span>
			</div>
			<div class="login_btn">
				<button id="btn_login">로그인</button>
			</div>
			<div class="flatform_log">
				<div>
					<i class="fab fa-google"></i>
					<span class="google_log">구글 로그인</span>
				</div>
				<div>
					<img src="${path}/img/facebook.png">
					<span class="facebook_log">페이스북 로그인</span>
				</div>
			</div>
		</section>
		<button id="modal_close"><i class="fas fa-times"></i></button>
		</div>
	</div>
	<header>
		<div class="header_outline">
			<div class="header_inline">
				<div class="header_icon">
					<a href="https://www.instagram.com/" target="_blank"><i class="fab fa-instagram"></i></a>
					<a href="https://www.facebook.com/" target="_blank"><i class="fab fa-facebook"></i></a>
					<a href="https://twitter.com/" target="_blank"><i class="fab fa-twitter"></i></a>
					<a href="https://www.google.co.kr/" target="_blank"><i class="fab fa-google"></i></a>
				</div>
				<div class="header_menu">
					<a href="#" id="modal_open">로그인</a>
					<a href="${path}/constract.bouquet">회원가입</a>
					<a href="#">고객센터</a>
				</div>
			</div>
		</div>
		<div class="logo_outline">
			<div class="logo_inline">
				<a href="file:///D:/sublime_workspace/bouquet/bouquet.html"><img src="${path}/img/free_horizontal_on_white_by_logaster.png"></a>
			</div>
		</div>
	</header>
	<nav>
		<div class="nav_outline">
			<div class="nav_inline">
				<ul>
					<li><a href="#">천천히봄</a>
						<div class="dropdown01">
							<a href="file:///D:/sublime_workspace/bouquet/bouquet_sel.html">BEST</a>
							<a href="file:///D:/sublime_workspace/bouquet/bouquet_sel.html">SPECIAL</a>
							<a href="file:///D:/sublime_workspace/bouquet/bouquet_sel.html">LUXURY</a>
							<a href="file:///D:/sublime_workspace/bouquet/bouquet_sel.html">NOBLESS</a>
						</div>
					</li>
					<li><a href="#">여름다운</a>
						<div class="dropdown01">
							<a href="file:///D:/sublime_workspace/bouquet/bouquet_sel.html">BEST</a>
							<a href="file:///D:/sublime_workspace/bouquet/bouquet_sel.html">SPECIAL</a>
							<a href="file:///D:/sublime_workspace/bouquet/bouquet_sel.html">LUXURY</a>
							<a href="file:///D:/sublime_workspace/bouquet/bouquet_sel.html">NOBLESS</a>
						</div>
					</li>
					<li><a href="#">색색가을</a>
						<div class="dropdown01">
							<a href="file:///D:/sublime_workspace/bouquet/bouquet_sel.html">BEST</a>
							<a href="file:///D:/sublime_workspace/bouquet/bouquet_sel.html">SPECIAL</a>
							<a href="file:///D:/sublime_workspace/bouquet/bouquet_sel.html">LUXURY</a>
							<a href="file:///D:/sublime_workspace/bouquet/bouquet_sel.html">NOBLESS</a>
						</div>
					</li>
					<li><a href="#">겨울눈꽃</a>
						<div class="dropdown01">
							<a href="file:///D:/sublime_workspace/bouquet/bouquet_sel.html">BEST</a>
							<a href="file:///D:/sublime_workspace/bouquet/bouquet_sel.html">SPECIAL</a>
							<a href="file:///D:/sublime_workspace/bouquet/bouquet_sel.html">LUXURY</a>
							<a href="file:///D:/sublime_workspace/bouquet/bouquet_sel.html">NOBLESS</a>
						</div>
					</li>
					<div class="nav_search">
						<input type="search" name="search">
						<a href="#"><i class="fas fa-search"></i></a>
					</div>
				</ul>
			</div>
		</div>
	</nav>

</body>
</html>