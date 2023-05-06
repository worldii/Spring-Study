<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 프로젝트의 context 경로를 편하게 사용하기 위한 코드 --%>
<c:set var="root" value="${pageContext.request.contextPath}"/>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">

	<ul class="navbar-nav me-auto">
		<li class="nav-item"><a class="nav-link" href="${root}/main?action=list">상품 목록</a></li>
		<li class="nav-item"><a class="nav-link" href="${root}/main?action=mvRegist">상품 정보 등록</a></li>
	</ul>
	
	<c:if test="${ empty loginUser}">
	
	<form method="post" action="${root}/main">
	<input type="hidden" name="action" value="login"></input>
	<input name="name"></input>
	<input name="password" type="password"></input>
	<button type="submit">로그인</button>
	
	</form
	></c:if>
	<c:if test="${not empty loginUser}">
	<p class="text-white">${loginUser.userName} 님 환영합니다.</p>
	<button onclick="logout()">로그아웃 </button>
	</c:if>
	
	<script>
	const logout = () => {
		location.href = "main?action=logout";
	}
	</script>
	
</nav>