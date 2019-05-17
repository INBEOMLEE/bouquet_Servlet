<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOUQUET : 상세 게시글</title>
<style type="text/css">
	section {
		width: 100%;
		height: auto;
	}
	.board_inline {
		width: 1080px;
		height: auto;
		border: 1px solid black;
		margin: 300px auto 30px;
		border-radius: 30px;
		box-shadow: 3px 3px 3px 3px #ccc;
		padding-bottom: 40px;
	}
	.comment_inline {
		width: 1080px;
		height: auto;
		border: 1px solid black;
		margin: 0px auto 30px;
		border-radius: 30px;
		box-shadow: 3px 3px 3px 3px #ccc;
		padding-bottom: 35px;
	}
	.board_topic {
		font-size: 30px;
		font-weight: 700;
		padding: 35px 0 10px 30px;
		color: #363636;
	}
	.font_style {
		font-size: 20px;
		font-weight: 600;
		padding: 20px 30px 10px 40px;
		display: inline-block;
		width: 813px;
	}
	.font_style2 {
		font-size: 20px;
		font-weight: 600;
		padding: 20px 30px 10px 40px;
		display: inline-block;
		width: 200px;
	}
	.input_style {
		width: 800px;
		font-size: 20px;
		margin-left: 19px;
		padding-left: 20px;
		font-weight: 600;
		border: 1px solid #A2A2A2;
		height: 35px;
	}
	.input_style2 {
		width: 216px;
		font-size: 20px;
		margin: 0 19px;
		padding-left: 20px;
		font-weight: 600;
		border: 1px solid #A2A2A2;
		height: 35px;
	}
	.info_table {
		width: 1040px;
		height: 35px;
		margin: 20px 17px;
	}
	.fa-heart {
		color: red;
	}
	#content_title {
		text-align: left;
		padding: 0 25px;
	}
	.info_table th {
		border: 1px solid #A2A2A2;
		height: 35px;
		font-size: 18px;
		width: 173px;
		background-color: #D8ADB6;
		color: white;
	}
	.info_table td {
		border: 1px solid #A2A2A2;
		padding: 0 10px;
		font-size: 17px;
		width: 173px;
		text-align: center;
		font-weight: 600;
		color: #363636;
	}
	.content {
		width: 1040px;
		border: 1px solid #A2A2A2;
		height: 500px; 
		margin: 0 auto;
	}
	.btn_style {
		display: inline-block;
		height: 35px;
		line-height: 35px;
		border-radius: 7px;
		font-size: 16px;
		font-weight: 600;
		margin-top: 20px;
		margin-left: 20px;
		padding: 0 10px;
		background-color: #D8ADB6;
		color: white;
		cursor: pointer;
	}
	.float {
		float: right;
		
	}
	.board_inline div:nth-child(8) {
		margin-right: 20px;
	}
	.comment {
		font-size: 25px;
		font-weight: 700;
		padding: 35px 0px 20px 30px;
		color: #363636;
	}
	.comment span {
		color: #D8ADB6;
	}
	.comment_box {
		border: 1px solid #A2A2A2;
		width: 1040px;
		margin: 0 auto 15px;
		box-shadow: 2px 2px 2px 2px #ccc;
		color: #363636;
		height: 109px;
	}
	.comment_box_name {
		display: inline-block;
		width: 841px;
		font-size: 18px;
		font-weight: 600;
		padding: 15px;
	}
	.comment_box_date {
		display: inline-block;
		width: 192px;
		font-size: 16px;
		font-weight: 600;
		padding: 15px;
	}
	.comment_box_content {
		border: 1px solid #A2A2A2;
		padding: 10px;
		font-size: 16px;
		font-weight: 600;
		width: 1000px;
		margin: 0 auto 15px;
	}
	.comment_not_user {
		line-height: 50px;
		padding: 15px;
		font-size: 25px;
		text-align: center;
		font-weight: 700;
		height: 120px;
		cursor: pointer;
	}
	.comment_not_user i {
		color: #A2A2A2;
	}
	.comment_not_user span {
		color: #D8ADB6;
		font-weight: 900;
	}
	.comment_not_comment {
		line-height: 50px;
		padding: 15px;
		font-size: 25px;
		text-align: center;
		font-weight: 700;
		height: 120px;
	}
	.comment_not_comment i {
		color: #A2A2A2;
		font-size: 40px;
	}
	.line {
		margin: 30px 0;
		border: 1px dashed black;
		width: 100%;
	}
	textarea {
		margin: 0 19px;
		width: 1040px;
		height: 500px;
		font-size: 20px;
		padding-left: 20px;
		padding-top: 10px;
		font-weight: 600;
		border: 1px solid #A2A2A2;
	}
	.font_style {
		font-size: 20px;
		font-weight: 600;
		padding: 20px 30px 10px 40px;
		display: inline-block;
	}
	.input_style {
		width: 1040px;
		font-size: 20px;
		margin: 0 19px;
		padding-left: 20px;
		font-weight: 500;
		border: 1px solid #A2A2A2;
		height: 35px;
		color: #363636;
	}
	.good_btn {
		display: inline-block;
		border: 1px solid #dadada;
		font-size: 20px;
		border-radius: 50%;
		margin-left: 319px;
		padding: 7px;
		color: red;
		cursor: pointer;
	}
	#good_btn_none {
		display: none;
	}
	.fa-heart {
		margin-top: 2px;
		padding: 0 1px;
	}
	
	.comment_inline input:nth-child(11) {
		margin-bottom: 20px;
	}
	
	.comment_inline div:nth-child(14) {
		margin-right: 20px;
	}
	.fa-user {
		font-size: 40px;
	}
</style>
</head>
<body>
	<section>
		<div class="board_inline">
			<div class="board_topic">질문 게시판</div>
			<table class="info_table">
				<tr>
					<th>제목</th>
					<td colspan="5" id="content_title">안녕하세요.</td>
				</tr>
				<tr>
					<th>글번호</th>
					<td>000</td>
					<th>작성자</th>
					<td>이인범</td>
					<th>작성일</th>
					<td>2019-05-17</td>
				</tr>
				<tr class="table_width">
					<th>첨부파일</th>
					<td>첨부된 파일 없음</td>
					<th>좋아요</th>
					<td><i class="fas fa-heart"></i> 0</td>
					<th>조회수</th>
					<td><i class="fas fa-eye"></i> 1</td>
				</tr>
			</table>
			<div class="content"></div>
			<div class="btn_style">게시글 목록</div>
			<div class="btn_style">답변</div>
			<div class="good_btn"><i class="far fa-heart"></i></div>
			<div class="good_btn" id="good_btn_none"><i class="fas fa-heart"></i></div>
			<div class="btn_style float">게시글 수정</div>
			<div class="btn_style float">게시글 삭제</div>
		</div>
		<div class="comment_inline">
			<div class="comment">댓글 <span>5</span></div>
			<div class="comment_box">
				<div class="comment_box_name">USER01</div>
				<div class="comment_box_date">2019-05-16 08:49:17</div>
				<div class="comment_box_content">반갑습니다.</div>
			</div>
			<div class="comment_box">
				<div class="comment_box_name">USER02</div>
				<div class="comment_box_date">2019-05-16 08:50:17</div>
				<div class="comment_box_content">반갑습니다.</div>
			</div>
			<div class="comment_box">
				<div class="comment_box_name">USER03</div>
				<div class="comment_box_date">2019-05-16 09:51:17</div>
				<div class="comment_box_content">반갑습니다.</div>
			</div>
			<div class="comment_box">
				<div class="comment_box_name">USER04</div>
				<div class="comment_box_date">2019-05-16 11:49:20</div>
				<div class="comment_box_content">반갑습니다.</div>
			</div>
			<div class="comment_box">
				<div class="comment_box_name">USER05</div>
				<div class="comment_box_date">2019-05-16 11:57:47</div>
				<div class="comment_box_content">반갑습니다.</div>
			</div>
			<div class="comment_box comment_not_user">
				<i class="fas fa-user"></i>
				<br>
				<span>로그인</span> 후에 이용해주세요.
			</div>
			<div class="comment_box comment_not_comment">
				<i class="fas fa-exclamation-triangle"></i>
				<br>
				등록된 댓글이 없습니다.
			</div>
			<div class="line"></div>
			<div class="font_style">작성자</div>
			<input type="text" class="input_style">
			<textarea></textarea>
			<div class="btn_style">게시글 목록</div>
			<div class="btn_style float">댓글 등록</div>
		</div>
	</section>
	<script type="text/javascript">
		$(document).ready(function(){
			var flag = 0;
			$('.good_btn').click(function(){
				if(flag == 0) {
					$(this).css('display', 'none');
					$('#good_btn_none').css('display', 'inline-block');
					flag = 1;
				} else {
					$('.good_btn').eq(0).css('display', 'inline-block');
					$('#good_btn_none').css('display', 'none');
					flag = 0;
				}
			});
		});
	</script>
</body>
</html>