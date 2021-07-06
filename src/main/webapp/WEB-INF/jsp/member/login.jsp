<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageName" value="로그인" />
<%@ include file="../part/head.jspf"%>
<script>
	function submitLoginForm(form) {
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
		form.submit();
	}
</script>
<form class="con common-form" action="./doLogin" method="POST"
	onsubmit="submitLoginForm(this); return false;">
	<div>
		<span> 로그인ID </span>
		<div>
			<input name="loginId" type="text" placeholder="아이디"
				autofocus="autofocus" maxlength="30">
		</div>
	</div>
	<div>
		<span> 로그인PW </span>
		<div>
			<input name="loginPw" type="password" placeholder="비밀번호"
				autofocus="autofocus" maxlength="30">
		</div>
	</div>

		<div>
			<input type="submit" value="로그인"> 
			<input type="reset" value="취소">
		</div>
		
</form>
<%@ include file="../part/foot.jspf"%> 