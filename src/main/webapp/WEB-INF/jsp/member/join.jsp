<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageName" value="회원가입" />
<%@ include file="../part/head.jspf"%>

<script>
	function submitJoinForm(form) {
		form.loginId.value = form.loginId.value.trim();
		if (form.loginId.value.length == 0) {
			alert('아이디를 입력해주세요.');
			form.loginId.focus();
			return false;
		}
		form.loginPw.value = form.loginPw.value.trim();
		if (form.loginPw.value.length == 0) {
			alert('비밀번호를 입력해주세요.');
			form.loginPw.focus();
			return false;
		}
		form.loginPwConfirm.value = form.loginPwConfirm.value.trim();
		if (form.loginPwConfirm.value.length == 0) {
			alert('비밀번호를 한번더 입력해 주세요.');
			form.loginPwConfirm.focus();
			return false;
		}
		if (form.loginPw.value != form.loginPwConfirm.value) {
			alert('비밀번호가 일치하지 않습니다.');
			form.loginPwConfirm.focus();
			return false;			
		}
		form.submit();
	}
</script>

<form class="con common-form" action="./doJoin" method="POST"
	onsubmit="submitJoinForm(this); return false;">
	<div>
		<span> ID </span>
		<div>
			<input name="loginId" type="text" placeholder="아이디를 입력하세요"
				autofocus="autofocus" maxlength="30">
		</div>
	</div>

	<div>
		<span> Password </span>
		<div>
			<input name="loginPw" type="password" placeholder="비밀번호를 입력하세요"
				autofocus="autofocus" maxlength="30">
		</div>
	</div>

	<div>
		<span> 비밀번호 확인 </span>
		<div>
			<input name="loginPwConfirm" type="password" placeholder="비밀번호 확인"
				autofocus="autofocus" maxlength="30">
		</div>
	</div>

		<div>
			<input type="submit" value="가입">
			 <input type="reset" value="취소" onclick="history.back();">
		</div>
</form>

<div class="btns con">
	<a href="../board/main">메인</a>
	<a href="/">가입</a>
</div>

<%@ include file="../part/foot.jspf"%> 