<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 프로젝트의 context 경로를 편하게 사용하기 위한 코드 --%>
<c:set var="root" value="${pageContext.request.contextPath}"/>
    
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/include/head.jsp" %>
</head>
<body>
	<%@ include file="/include/nav.jsp" %>

	<%-- 페이지만의 내용 --%>
	<div class="container p-4">
	
	  <h2>상품 정보 </h2>
<c:if test="${not empty products}">
	
	<table>
	<tr>
	<th>
	code
	</th>
	<th>
	code
	</th><th>
	code
	</th>
	</tr>
<c:forEach var="product" items="${products}" >
	
	<tr onclick="clickFunc('${product.productCode}')">
	
	<td>${product.productCode}</td>
		<td>${product.model}</td>
		<td>${product.price}</td>
	
	</tr>



</c:forEach>
	
	
	</table>

	
</c:if>

<c:if test="${empty products}">

†상품없음
</c:if>
	</div>

	</body>
	<script>
	const clickFunc = (code) => {
		location.href= "${root}/main?action=view&productCode="+ code;
	}
	</script>
	
<%@ include file="/include/footer.jsp" %>