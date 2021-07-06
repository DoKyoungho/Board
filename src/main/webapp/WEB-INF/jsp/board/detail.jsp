<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageName" value="게시물 상세"/>

<%@ include file="../part/head.jspf" %>
	
	<section class="con">
			번호 : ${board.id}<br>
			제목 : ${board.title}<br>
			내용 : ${board.body}<br>
			조회수 : ${board.hit}<br>
	</section>
	
	<div class="btns con">
		<a href="./list">게시판 리스트</a>
		<a href="./insert">게시글 추가</a>
		<a href="./modify?id=${board.id}">게시글 수정</a>
		<a onclick="if (confirm('삭제하시겠습니까?') == false) return false;" href="./doDelete?id=${board.id}">게시물 삭제</a>
	</div>
<%@ include file="../part/foot.jspf" %>