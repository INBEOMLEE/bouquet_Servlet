<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOUQUET : 회원가입</title>
<style type="text/css">
	.section {
		border-top: 1px solid #dadada;
		background-color: #FFFFF6;
	}
	.inner_section {
		border: 1px solid white;
		width: 1440px;
		height: auto;
		margin: 0 auto;
		text-align: center;
		background-color: white;
	}
	.join_menu {
		/*border: 1px solid black;*/
		width: 550px;
		padding: 10px;
		margin: 0 auto;
		border: 1px solid #D8ADB6;
		margin-top: 20px;
		border-radius: 5px;
		position: relative;
	}
	.join_menu:nth-child(1) {
		margin-top: 30px;
	}
	.join_minititle {
		width: 100%;
		text-align: left;
		font-size: 15px;
		padding: 0 0 10px 10px;
	}
	.join_menu input {
		width: 498px;
		height: 45px;
		font-size: 16px;
		padding: 10px;
		border-radius: 5px;
		border: 1px solid #dadada;
	}
	.join_menu > span {
		display: block;
		text-align: left;
		padding: 10px 0 0 10px;
		font-size: 15px;
		color: tomato;
		display: none;
	}
	#email_id, #email_url {
		width: 185px;
		display: inline-block;
		float: left;
		flex: 1;
	}
	#email_url {
		width: 150px;
		margin-right: 4px;
	}
	h1 {
		display: inline-block;
		padding: 0;
		margin: 0;
		line-height: 45px;
		float: left;
		padding: 0 5px;
		font-weight: 200;

	}
	#selmail {
		width: 120px;
		height: 45px;
		flex: 1;
		border: 1px solid #dadada;
		border-radius: 5px;				
	}
	.email_wrap {
		margin: 0 auto;
		/*border: 1px solid black;*/
		display: flex;
		width: 498px;
	}
	.address_wrap {
		width: 498px;
		text-align: left;
		margin: 0 auto;
	}
	.address_wrap input {
		width: 300px;
		padding: 10px;
		margin-top: 4px;
	}
	.address_wrap input:nth-child(2) {
		width: 193.5px;
		cursor: pointer;
		background: #D8B8B6;
		color: white;
		border: 1px solid #D8B8B6;
	}
	.address_wrap input:nth-child(3) {
		width: 100%;
	}
	.address_wrap input:nth-child(5) {
		width: 193.5px;
	}
	.joinBtn_wrap {
		border: 1px solid #D8B8B6;
		width: 550px;
		margin: 30px auto;
		height: 61px;
		font-size: 20px;
		font-weight: 600;
		line-height: 61px;
		text-align: center;
		color: white;
		background-color: #D8B8B6;
		cursor: pointer;
	}
	.explanation {
		position: absolute;
		top: 0;
		right: -330px;
		width: 300px;
		height: 94px;
		border: 1px solid black;
		padding: 10px;
		border-radius: 5px;
		border: 1px solid #D8ADB6;
		display: none;
	}
	.explanation span {
		display: block;
		padding-top: 16px;
		color: #D8ADB6;
	}
	#explanation_adr {
		height: 196px;
		padding-top: 60px;
	}
</style>
</head>
<body>	
	<section>
		<div class="section">
			<div class="inner_section">
				<form class="form" method="POST" action="">
					<!-- 아이디 -->
					<div class=join_menu>
						<div class="join_minititle">
							<label for="id">아이디</label>
						</div>
						<input type="text" name="id" id="id" class="input_box" maxlength="20" placeholder="아이디를 입력해주세요.">
						<span class="err_msg">올바른 값을 입력해주세요.</span>
						<div class="explanation">
							<span>영어와 숫자를 조합하여<br> 5~15자 이내로 입력해주세요.</span>
						</div>
					</div>
					<!-- 비밀번호 -->
					<div class=join_menu>
						<div class="join_minititle">
							<label for="pw">비밀번호</label>
						</div>
						<input type="password" name="pw" id="pw" class="input_box" maxlength="20" placeholder="비밀번호를 입력해주세요.">
						<span class="err_msg">올바른 값을 입력해주세요.</span>
						<div class="explanation">
							<span>영어와 숫자를 조합하여<br> 4~12자 이내로 입력해주세요.</span>
						</div>
					</div>
					<!-- 비밀번호 재확인 -->
					<div class=join_menu>
						<div class="join_minititle">
							<label for="repw">비밀번호 재확인</label>
						</div>
						<input type="password" name="repw" id="repw" class="input_box" maxlength="20" placeholder="비밀번호를 다시 입력해주세요.">
						<span class="err_msg">올바른 값을 입력해주세요.</span>
						<div class="explanation">
							<span>위에 입력하셨던 비밀번호와<br> 동일하게 입력해주세요.</span>
						</div>
					</div>
					<!-- 이름 -->
					<div class=join_menu>
						<div class="join_minititle">
							<label for="name">이름</label>
						</div>
						<input type="text" name="name" id="name" class="input_box" maxlength="4" placeholder="이름을 입력해주세요.">
						<span class="err_msg">올바른 값을 입력해주세요.</span>
						<div class="explanation">
							<span>한글(Korean) 이름으로<br> 2~4자 이내로 입력해주세요.</span>
						</div>
					</div>
					<!-- 전화번호 -->
					<div class=join_menu>
						<div class="join_minititle">
							<label for="phone">전화번호</label>
						</div>
						<input type="text" name="phone" id="phone" class="input_box" maxlength="11" placeholder="전화번호를 입력해주세요.">
						<span class="err_msg">올바른 값을 입력해주세요.</span>
						<div class="explanation">
							<span>'-' 없이 숫자로만 입력해주세요.<br>ex ) 01012345678</span>
						</div>
					</div>
					<!-- 이메일 -->
					<div class=join_menu>
						<div class="join_minititle">
							<label for="phone">이메일</label>
						</div>
						<div class="email_wrap">
							<input type="text" id="email_id" placeholder="이메일을 입력해주세요.">
							<h1>@</h1>
							<input type="text" id="email_url" placeholder="이메일 선택">
							<select id="selmail">
								<option value="">이메일 선택</option>
								<option value="directVal">직접입력
								</option>
								<option value="naver.com">naver.com</option>
								<option value="daum.net">daum.net</option>
								<option value="gmail.com">gmail.com</option>
								<option value="nate.com">nate.com
								</option>
							</select>
						</div>
						<span class="err_msg">올바른 값을 입력해주세요.</span>
						<div class="explanation">
							<span>본인이 자주 사용하시는<br> 이메일을 정확하게 입력해주세요.</span>
						</div>
					</div>

					<!-- 주소 -->
					<div class=join_menu>
						<div class="join_minititle">
							<label for="phone">주소</label>
						</div>
						<div class=address_wrap>
							<input type="text" id="sample6_postcode" placeholder="우편번호">
							<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
							<input type="text" id="sample6_address" placeholder="주소">
							<input type="text" id="sample6_detailAddress" placeholder="상세주소">
							<input type="text" id="sample6_extraAddress" placeholder="참고항목">
						</div>
						<span class="err_msg">올바른 값을 입력해주세요.</span>
						<div class="explanation" id="explanation_adr">
							<span>우편번호 찾기를 이용하시면<br>편리하게 주소입력을 하실 수 있습니다.</span>
						</div>
					</div>
				</form>
				<div class="joinBtn_wrap">
					<span>
						<a href="#" class="join_btn">가입하기</a>
					</span>
				</div>
			</div>
		</div>
	</section>
	<%@ include file="include/footer.jsp" %>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#id").blur(function(){
				var id = $.trim($(this).val());
				
				// id에 값이 있는 경우에만 ajax 동작 !
				if(id != "" || id.length != 0) {
					$.ajax({
						url: "idCheck.bouquet",
						type: "POST",
						dataType: "json",
						data: "id="+id,
						success: function(data){
							
						},
						error: function(){
							alert("System Error!!!");
						} 
					});
				}
			});
		});
	</script>
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			
			var 
				form = $('#join_frm'),
				uid = $('#id'),
				upw = $('#pw'),
				urepw = $('#repw'),
				uname = $('#name'),
				uphone = $('#phone'),
				umail = $('#email_id'),
				uurl = $('#email_url');

			// 정규식
			var idReg = RegExp(/^[a-zA-Z0-9]{5,15}$/);
			var pwReg = RegExp(/^[a-zA-Z0-9]{4,12}$/);
			var nameReg = RegExp(/^[가-힣]{2,4}$/);
			var phoneReg = RegExp(/^[0-9]{8,11}$/);
			var emailReg = RegExp(/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i);

			$('#selmail').change(function() {
				var selmail = $(this).val();

				if(selmail == 'directVal') {
					$('#email_url').val("");
					$('#email_url').focus();
				} else {
					$('#email_url').val(selmail);
				}
			});

			// input 태그에 따른 설명 띄우기
			uid.focus(function(){
				// alert('test');
				$('.explanation').eq(0).css('display', 'block');
			});

			uid.blur(function(){
				// alert('test');
				$('.explanation').eq(0).css('display', 'none');

				var id = $.trim(uid.val());

				if(id == '' || id.length == 0) {
					$('.err_msg').eq(0).css('display', 'block')
					                   .text('필수입력 정보입니다.')
					                   .css('color', 'tomato');
					uid.val('');
					return false;
				} else if(!idReg.test(id)) {
					$('.err_msg').eq(0).css('display', 'block')
					                   .text('올바른 값을 입력해주세요.')
					                   .css('color', 'tomato');
					return false;
				} else {
					$('.err_msg').eq(0).css('display', 'block')
					                   .text('사용 가능한 아이디입니다.')
					                   .css('color', 'dodgerblue');
				}
			});

			upw.focus(function(){
				// alert('test');
				$('.explanation').eq(1).css('display', 'block');
			});

			upw.blur(function(){
				// alert('test');
				$('.explanation').eq(1).css('display', 'none');

				var pw = $.trim(upw.val());

				if(pw == '' || pw.length == 0) {
					$('.err_msg').eq(1).css('display', 'block')
					                   .text('필수입력 정보입니다.')
					                   .css('color', 'tomato');
					upw.val('');
					return false;
				} else if(!pwReg.test(pw)) {
					$('.err_msg').eq(1).css('display', 'block')
					                   .text('올바른 값을 입력해주세요.')
					                   .css('color', 'tomato');
					return false;
				} else {
					$('.err_msg').eq(1).css('display', 'block')
					                   .text('조건에 맞는 비밀번호입니다.')
					                   .css('color', 'dodgerblue');
				}
			});

			urepw.focus(function(){
				// alert('test');
				$('.explanation').eq(2).css('display', 'block');
			});

			urepw.blur(function(){
				// alert('test');
				$('.explanation').eq(2).css('display', 'none');

				var pw = $.trim(upw.val());
				var repw = $.trim(urepw.val());

				if(repw == '' || repw.length == 0) {
					$('.err_msg').eq(2).css('display', 'block')
					                   .text('필수입력 정보입니다.')
					                   .css('color', 'tomato');
					urepw.val('');
					return false;
				} else if(!pwReg.test(repw)) {
					$('.err_msg').eq(2).css('display', 'block')
					                   .text('비밀번호 조건에 맞지 않습니다.')
					                   .css('color', 'tomato');
					return false;
				} else if(pw != repw) {
					$('.err_msg').eq(2).css('display', 'block')
					                   .text('위의 비밀번호와 일치하지 않습니다.')
					                   .css('color', 'tomato');
				} else {
					$('.err_msg').eq(2).css('display', 'block')
					                   .text('조건에 맞는 비밀번호입니다.')
					                   .css('color', 'dodgerblue');
				}
			});

			uname.focus(function(){
				// alert('test');
				$('.explanation').eq(3).css('display', 'block');
			});

			uname.blur(function(){
				// alert('test');
				$('.explanation').eq(3).css('display', 'none');
				var name = $.trim($('#name').val());
					
				if(name == '' || name.length == 0) {
					$('.err_msg').eq(3).css('display', 'block')
					                   .css('color', 'tomato')
					                   .text('필수입력 정보입니다.');
					uname.val('');
					return false;
				} else if(!nameReg.test(name)) {
					$('.err_msg').eq(3).css('display', 'block')
					                   .css('color', 'tomato')
					                   .text('올바른 값을 입력하세요.');
					return false;
				} else {
					$('.err_msg').eq(3).css('display', 'block')
					                   .css('color', 'dodgerblue')
					                   .text('멋진 이름이네요.');
				}
			});

			uphone.focus(function(){
				// alert('test');
				$('.explanation').eq(4).css('display', 'block');
			});

			uphone.blur(function(){
				// alert('test');
				$('.explanation').eq(4).css('display', 'none');

				var phone = $.trim(uphone.val());

				if(phone == '' || phone.length == 0) {
					$('.err_msg').eq(4).css('display', 'block')
					                   .css('color', 'tomato')
					                   .text('필수입력 정보입니다.');
                    uphone.val('');
                    return false;
				} else if(!phoneReg.test(phone)) {
					$('.err_msg').eq(4).css('display', 'block')
					                   .css('color', 'tomato')
					                   .text('올바른 값을 입력하세요.');
					return false;
				} else {
					$('.err_msg').eq(4).css('display', 'block')
					                   .css('color', 'dodgerblue')
					                   .text('좋은 전화번호네요.');
				}
			});

			$('.email_wrap > input').focus(function(){
				// alert('test');
				$('.explanation').eq(5).css('display', 'block');
			});

			$('.email_wrap > input').blur(function(){
				// alert('test');
				$('.explanation').eq(5).css('display', 'none');
			});

			$('.address_wrap > input').focus(function(){
				// alert('test');
				$('.explanation').eq(6).css('display', 'block');
			});

			$('.address_wrap > input').blur(function(){
				// alert('test');
				$('.explanation').eq(6).css('display', 'none');
			});

		});

		function sample6_execDaumPostcode() {
	        new daum.Postcode({
	            oncomplete: function(data) {
	                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

	                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                var addr = ''; // 주소 변수
	                var extraAddr = ''; // 참고항목 변수

	                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                    addr = data.roadAddress;
	                } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                    addr = data.jibunAddress;
	                }

	                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
	                if(data.userSelectedType === 'R'){
	                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                        extraAddr += data.bname;
	                    }
	                    // 건물명이 있고, 공동주택일 경우 추가한다.
	                    if(data.buildingName !== '' && data.apartment === 'Y'){
	                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                    }
	                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                    if(extraAddr !== ''){
	                        extraAddr = ' (' + extraAddr + ')';
	                    }
	                    // 조합된 참고항목을 해당 필드에 넣는다.
	                    document.getElementById("sample6_extraAddress").value = extraAddr;
	                
	                } else {
	                    document.getElementById("sample6_extraAddress").value = '';
	                }

	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                document.getElementById('sample6_postcode').value = data.zonecode;
	                document.getElementById("sample6_address").value = addr;
	                // 커서를 상세주소 필드로 이동한다.
	                document.getElementById("sample6_detailAddress").focus();
	            }
	        }).open();
	    }
	</script>
</body>
</html>