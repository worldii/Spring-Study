<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 출결 관리</title>
<style>
</style>
</head>
<body>
	<%-- header.jsp를 include해서 재사용하기 --%>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<div class="container">
		<ul class="list-group">
			<li class="list-group-item"><a href="${root }/book/regist">출결 이슈 등록
					등록</a></li>
			<li class="list-group-item"><a href="${root }/book/list">출결 이슈 목록
					목록</a></li>
		</ul>
	</div>
</body>
</html>