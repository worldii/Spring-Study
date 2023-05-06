<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/WEB-INF/views/include/header.jsp"%>
	<h2>고객 명단</h2>
	<table>
		<thead>
			<tr>
				<th>고객 번호</th>
				<th>상점 번호</th>
				<th>고객 명</th>
				<th>이메일</th>
				<th>탈퇴 여부</th>
			</tr>
		</thead>
		<tbody id="list-body">

		</tbody>
	</table>
</body>
<script>
	(async function(){
		let response = await fetch("${root}/api/customer")
		let json = await response.json();
		let listBody = document.querySelector("#list-body");
		listBody.innerHTML = "";
		json.forEach(c =>{
			console.log(c)
			listBody.innerHTML+=`
				<tr>
					<td>\${c.customerId}</td>
					<td>\${c.storeId}</td>
					<td>\${c.firstName} \${c.lastName}</td>
					<td>\${c.email}</td>
					<td>\${c.active?"활동중":"휴면계정"}</td>
			    </tr>
			`;
		})
		
	})();
	
</script>
</html>