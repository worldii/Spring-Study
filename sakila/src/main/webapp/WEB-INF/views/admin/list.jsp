<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>도움말</title>

</head>
<body>
	<%@include file="/WEB-INF/views/include/header.jsp"%>
	<h2>목록 보기</h2>
	<div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>customer_id</th>
					<th>store_id</th>
					<th>first_name</th>
					<th>last_name</th>
					<th>email</th>
					<th>create_date</th>
				</tr>
			</thead>

			<tbody id="tbody">
			</tbody>
		</table>
	</div>

	<script>
	

	(async function(){
		let config = {
				method:"get"
		};
		let response =  await fetch("${root}/api/customer", config);
		let json = await response.json();
		 for(let item of json.customer){
	            tbody.innerHTML +=`
	                <tr>
	                    <td>`+item.customerId+`</td>
	                    <td>`+item.storeId+`</td>
	                    <td>`+item.firstName+`</td>
	                    <td>`+item.lastName+`</td>
	                    <td>`+item.email+`</td>
	                    <td>`+item.createDate+`</td>
	                </tr>
	            `;
	        }
	})();


	</script>
</body>

</html>