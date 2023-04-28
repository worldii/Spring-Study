<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Home</title>
<link rel="stylesheet" href="/css/common.css" type="text/css" />
</head>
<body>
	<%@include file="/WEB-INF/views/include/header.jsp"%>
	<h2>메인 페이지</h2>

	<script>
		let msg = "${msg}";

		if (msg) {
			alert(msg);
		}
	</script>
</body>
</html>