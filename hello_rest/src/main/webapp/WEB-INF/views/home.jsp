<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<c:set var="root" value="${pageContext.servletContext.contextPath}"></c:set>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>도시관리</h1>
	<h2>도시 목록</h2>

	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>CountryCode</th>
				<th>District</th>
			</tr>
		</thead>
		<tbody id="citylist">

		</tbody>
	</table>
	<h2>도시 상세 정보</h2>
	<div id="detail"></div>
	<h2>도시 등록 정보</h2>
	<input type="text" id="name" placeholder="">
	<input type="text" id="countryCode" placeholder="CountryCode">
	<input type="text" id="district" placeholder="District">
	<input type="text" id="population" placeholder="population">
	<button id="insertBtn">추가</button>
</body>


<script>
	async function load() {
		let config = {

			method : "get"
		}
		let response = await fetch("http://127.0.0.1:8080/rest/api/city", config);
		
		let json = await response.json();
		console.log(json);

		let citylist = document.querySelector("#citylist");
		citylist.innerHTML ="";
		
		json.forEach(item => {
			let html = `<tr><td onclick="detail(\${item.id})">\${item.id}</td><td>\${item.name}</td><td>\${item.countryCode}</td><td>\${item.district}</td></tr>`;
			citylist.innerHTML += html;
		});
	}
	load();
	
	async function detail (id) {
		let config = {
				method : "get"
			}
		let response = await fetch("${root}/api/city/"+id, config);
		let json =  await response.json();
		console.log(json)
	
		document.querySelector("#detail").innerHTML = JSON.stringify(json);
	}
	

	document.querySelector("#insertBtn").addEventListener("click", async function(){
		let  city = {
			name : document.querySelector("#name").value,
			countryCode : document.querySelector("#countryCode").value,
			district : document.querySelector("#district").value,
			population : document.querySelector("#population").value,
		}
		console.log(city);
		let config = {

				method : "post", 
				headers : {
					"Content-Type" : "application/json", //@RequestBody					
				},
				body : JSON.stringify(city)
			}
		let response = await fetch("${root}/api/city/", config);
		let json = await response.json();
		alert(JSON.stringify(json) + "추가 완료")
		
	})
</script>
</html>
