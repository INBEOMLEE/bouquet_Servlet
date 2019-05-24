<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOUQUET : 게시글 수정</title>
<style type="text/css">
	section {
		width: 100%;
		height: auto;
	}
	.board_inline {
		width: 1080px;
		height: auto;
		border: 1px solid black;
		margin: 300px auto 200px;
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
	.board_insert {
		display: inline-block;
		height: 35px;
		line-height: 35px;
		border-radius: 7px;
		font-size: 16px;
		font-weight: 600;
		margin-top: 20px;
		margin-right: 20px;
		margin-left: 20px;
		padding: 0 10px;
		background-color: #D8ADB6;
		color: white;
		cursor: pointer;
	}
	.float {
		float: right;
		width: 150px;
		text-align: center;
		font-size: 20px;
	}
	.file_name {
		display: inline-block;
		height: 35px;
		line-height: 35px;
		font-size: 16px;
		font-weight: 500;
	}
	#input_none {
		display: none;
	}
	#file_cancle_btn {
		display: none;
		position: relative;
		top: 2px;
		cursor: pointer;
	}
</style>
</head>
<body>
	<section>
		<div class="board_inline">
			<div class="board_topic">질문 게시판</div>
			<div class="font_style">제목</div>
			<input type="text" class="input_style">
			<div class="font_style">내용</div>
			<textarea></textarea>
			<div class="font_style">작성자</div>
			<input type="text" class="input_style">
			<div class="board_insert float">게시글 수정</div>
			<label for="input_none" class="board_insert">첨부파일 등록</label>
			<input type="file" class="board_insert" id="input_none">
			<div class="file_name">선택된 파일 없음</div>
			<div id="file_cancle_btn"><i class="fas fa-times"></i></div>
		</div>
	</section>
	<script type="text/javascript">
	$(document).ready(function(){
		$('#input_none').on('change', function(){
			if(window.FileReader){
				var filename = $(this)[0].files[0].name;
			} else {
				var filename = $(this).val().split('/').pop().split('\\').pop();
			}
			
			$('.file_name').text(filename);
			
			if($(this).val() != null) {
				$('#file_cancle_btn').css('display', 'inline-block');
			} else {
				$('#file_cancle_btn').css('display', 'none');
			}
		});
		
		$('#file_cancle_btn').click(function(){
			$('#input_none').val("");
			$('.file_name').text("선택된 파일 없음");
			$(this).css('display', 'none');
		});
		
	});
	</script>
</body>
</html>