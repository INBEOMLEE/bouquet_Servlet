<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOUQUET : 게시판</title>
<style type="text/css">
	section {
		width: 100%;
		height: auto;
	}
	.board_inline {
		width: 1080px;
		height: 675px;
		margin: 300px auto 200px;
		border-radius: 30px;
		box-shadow: 3px 3px 3px 3px #ccc;
		border: 1px solid black;
	}
	.board_topic {
		font-size: 30px;
		font-weight: 700;
		padding: 35px 0 20px 30px;
		color: #363636;
	}
	.board_sort {
		height: 30px;
		/*border: 1px solid red;*/
		padding-left: 20px;
		display: block;
		text-align: right;
		font-weight: 600;
		font-size: 16px;
		letter-spacing: -1;
		margin-right: 23px;
		line-height: 30px;
		margin-bottom: 5px;
		color: #242424;
	}
	.board_sort span {
		margin-left: 10px;
		cursor: pointer;
		transition: 0.5s;
	}
	.board_sort span:nth-child(1) {
		font-size: 18px;
		color: #D8ADB6;
	}
	.board {
		width: 1040px;
		margin: 0 auto;
		height: 418px;
		/*border: 1px solid orange;*/
	}
	.board_column {
		width: 100%;
		height: 38px;
		color: white;
	}
	#board_column {
		background-color: #D8ADB6;
	}
	.board td {
		text-align: center;
		font-weight: 600;
		color: #242424;
	}
	.board tr:nth-child(odd) {
		background-color: #EAEAEA;
	}
	.board_column th:nth-child(1) {
		width: 30px;
	}
	.board_column th:nth-child(2){
		width: 100px;
	}
	.board_column th:nth-child(3) {
		width: 50px;
	}
	.board_column th:nth-child(4) {
		width: 68px;
	}
	.board_column th:nth-child(5) {
		width: 40px;
	}
	.board_column th:nth-child(6) {
		width: 39px;
	}
	.board_column th:nth-child(7) {
		width: 30px;
	}
	.board tr td:nth-child(2) {
		text-align: left;
		padding-left: 15px;
	}
	.fa-heart {
		color: red;
	}
	.fa-file-alt {
		color: #242424;
	}
	.board_insert {
		display: inline-block;
		height: 35px;
		line-height: 35px;
		border-radius: 7px;
		font-size: 16px;
		font-weight: 600;
		margin-top: 25px;
		margin-left: 20px;
		padding: 0 10px;
		background-color: #D8ADB6;
		color: white;
		cursor: pointer;
	}
	.board_search {
		display: flex;
		float: right;
		margin-top: 25px;
		margin-right: 20px;
		line-height: 35px;
	}
	.board_search select {
		width: 100px;
		height: 35px;
		border: 1px solid #ddd;
		border-radius: 7px;
		line-height: 35px;
		outline: none;
		margin-right: 2px;
	}
	.board_search input {
		height: 35px;
		border: 1px solid #ddd;
		border-radius: 7px;
		margin-right: 2px;
		width: 200px;
		transition: 0.7s;
		line-height: 35px;
		padding: 0 10px;
	}
	.board_search i {
		line-height: 35px;
		height: 35px;
		width: 30px;
		border: 1px solid #ddd;
		text-align: center;
		border-radius: 7px;
		background-color: #D8ADB6;
		color: white;
		cursor: pointer;
	}
	.pagination {
		margin: 25px auto;
		width: 403px;
	}

	.pagination a {
		display: inline-block;
		width: 30px;
	    color: black;
	    float: left;
	    border: 1px solid #ddd;
	    text-align: center;
	    margin-right: 1px;
	    font-weight: 700;
	    height: 23px;
	    text-align: center;
	    line-height: 22px;
	    color: #242424;
	    
	}
	.pagination i {
		width: 30px;
		display: block;
		line-height: 23px;
		color: #242424;
	}
	.fa-eye {
		width: 15px;
	}
	
</style>
</head>
<body>
	<section>
		<div class="board_inline">
			<div class="board_topic">질문 게시판</div>
			<div class="board_sort">
				<span>최신순</span>
				<span>추천순</span>
				<span>댓글순</span>
				<span>조회순</span>
			</div>
			<table class="board">
				<tr class="board_column" id="board_column">
					<th>No.</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>좋아요</th>
					<th>조회수</th>
					<th>첨부</th>
				</tr>
				<tr>
					<td>000</td>
					<td><a href="#">안녕하세요</a></td>
					<td>이인범</td>
					<td>11:12:57</td>
					<td><i class="fas fa-heart"></i> 0</td>
					<td><i class="fas fa-eye"></i> 1</td>
					<td><i class="far fa-file-alt"></i></td>
				</tr>
				<tr>
					<td>000</td>
					<td><a href="#">안녕하세요</a></td>
					<td>이인범</td>
					<td>11:12:57</td>
					<td><i class="fas fa-heart"></i> 0</td>
					<td><i class="fas fa-eye"></i> 1</td>
					<td></td>
				</tr>
				<tr>
					<td>000</td>
					<td><a href="#">안녕하세요</a></td>
					<td>이인범</td>
					<td>11:12:57</td>
					<td><i class="fas fa-heart"></i> 0</td>
					<td><i class="fas fa-eye"></i> 1</td>
					<td></td>
				</tr>
				<tr>
					<td>000</td>
					<td><a href="#">안녕하세요</a></td>
					<td>이인범</td>
					<td>11:12:57</td>
					<td><i class="fas fa-heart"></i> 0</td>
					<td><i class="fas fa-eye"></i> 1</td>
					<td><i class="far fa-file-alt"></i></td>
				</tr>
				<tr>
					<td>000</td>
					<td><a href="#">안녕하세요</a></td>
					<td>이인범</td>
					<td>11:12:57</td>
					<td><i class="fas fa-heart"></i> 0</td>
					<td><i class="fas fa-eye"></i> 1</td>
					<td><i class="far fa-file-alt"></i></td>
				</tr>
				<tr>
					<td>000</td>
					<td><a href="#">안녕하세요</a></td>
					<td>이인범</td>
					<td>11:12:57</td>
					<td><i class="fas fa-heart"></i> 0</td>
					<td><i class="fas fa-eye"></i> 1</td>
					<td></td>
				</tr>
				<tr>
					<td>000</td>
					<td><a href="#">안녕하세요</a></td>
					<td>이인범</td>
					<td>11:12:57</td>
					<td><i class="fas fa-heart"></i> 0</td>
					<td><i class="fas fa-eye"></i> 1</td>
					<td></td>
				</tr>
				<tr>
					<td>000</td>
					<td><a href="#">안녕하세요</a></td>
					<td>이인범</td>
					<td>11:12:57</td>
					<td><i class="fas fa-heart"></i> 0</td>
					<td><i class="fas fa-eye"></i> 1</td>
					<td></td>
				</tr>
				<tr>
					<td>000</td>
					<td><a href="#">안녕하세요</a></td>
					<td>이인범</td>
					<td>11:12:57</td>
					<td><i class="fas fa-heart"></i> 0</td>
					<td><i class="fas fa-eye"></i> 1</td>
					<td></td>
				</tr>
				<tr>
					<td>000</td>
					<td><a href="#">안녕하세요</a></td>
					<td>이인범</td>
					<td>11:12:57</td>
					<td><i class="fas fa-heart"></i> 0</td>
					<td><i class="fas fa-eye"></i> 1</td>
					<td><i class="far fa-file-alt"></i></td>
				</tr>
			</table>
			<div class="board_insert">게시글 등록</div>
			<div class="board_search">
				<select>
					<option selected="selected">조건 선택</option>
					<option value="제목">제목</option>
					<option value="내용">내용</option>
					<option value="제목+내용">제목+내용</option>
					<option value="작성자">작성자</option>
				</select>
				<input type="text" class="search" name="search">
				<i class="fas fa-search"></i>
			</div>
			<div class="pagination">
				<a href="#"><i class="fas fa-angle-double-left"></i></a>
				<a href="#"><i class="fas fa-angle-left"></i></a>
			    <a href="#">1</a>
				<a href="#">2</a>
				<a href="#">3</a>
				<a href="#">4</a>
				<a href="#">5</a>
				<a href="#">6</a>
				<a href="#">7</a>
				<a href="#">8</a>
				<a href="#">9</a>
				<a href="#"><i class="fas fa-angle-right"></i></a>
				<a href="#"><i class="fas fa-angle-double-right"></i></a>
			</div>
		</div>
	</section>
	<script type="text/javascript">
		var flag = 0;
		$(document).ready(function(){
			$('.board_search i').click(function(){
				if(flag == 0) {
					$('.slidebar').css('display', 'block');
					flag = 1;
				} else {
					$('.slidebar').css('display', 'none');
					flag = 0;
				}
			});
			
			$('.board_sort span').click(function(){
				sortStyle();
				$(this).css('color', '#D8ADB6')
				       .css('font-size', '18px')
			});
		});
		
		function sortStyle() {
			$('.board_sort span').css('color', '#242424')
		                         .css('font-size', '16px')
		}  
	</script>
</body>
</html>