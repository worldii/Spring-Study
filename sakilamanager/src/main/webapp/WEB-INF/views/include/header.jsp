<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="root" value="${pageContext.servletContext.contextPath }"></c:set>
<link rel="stylesheet" href="/css/common.css">
<h1>고객 관리 시스템</h1>


<c:if test="${empty loginUser }">
	<form method="post" action="${root }/user/login">
		<input type="text" name="email" value="MARY.SMITH@sakilacustomer.org">
		<input type="text" name="firstName" value="MARY">
		<input type="submit" value="login">
	</form>
</c:if>

<c:if test="${!empty loginUser }">
	${loginUser.email}님 반갑습니다.<a href="${root }/user/logout">logout</a>
</c:if>
<br>
<a href="${root }/">홈</a>
<a href="${root }/admin/list">목록</a>
<a href="${root }/admin/insert">추가</a>
<a href="${root }/admin/help">도움말</a>

<hr>
<script>
	let msg = "${msg}";
	if(msg){
		alert(msg);
	}
</script>