<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageName" value="게시물 리스트"/>

<%@ include file="../part/head.jspf" %>

 
 <h2 class ="con">전체 게시물 개수 : ${totalCount}</h2>
		<!-- el문법 장점: request.getAttritube("board")할 필요없다 -->
	<div class="con">
		<c:forEach items="${list}" var="board">
			<section>
				<a href="./detail?id=${board.id}">번호 : ${board.id}, 제목 : ${board.title}</a>
			</section>
			<hr>
		</c:forEach>
	</div>
<hr>
<%@ include file="../part/foot.jspf" %>