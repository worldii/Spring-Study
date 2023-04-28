<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="/css/common.css" type="text/css" />
<c:set var="root" value="${pageContext.servletContext.contextPath}"></c:set>


<h1>고객 관리 시스템</h1>

<c:if test="${empty loginUser}">
	<form method="post" action="/user/login">
		<input type="text" name="email" placeholder="아이디를 입력해주세요." /> <input
			type="text" name="firstName" placeholder="패스워드를 입력해주세요." /> <input
			type="submit" value="login" />
	</form>
</c:if>

<c:if test="${!empty loginUser}">
    ${loginUser.email}님 반갑습니다.<a href="${root}/user/logout">로그아웃</a>
</c:if>

<a href="${root}/">홈</a>
<a href="${root}/admin/list">목록</a>
<a href="${root}/admin/insert">추가</a>
<a href="${root}/admin/help">도움말</a>

<hr />