<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 도서 관리</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<div class="container">
		<h1>도서 등록</h1>
	<!-- file upload를 위해 multipart/form-data를 추가한다. -->
	<form method="post" action="regist" enctype="multipart/form-data">
			<!-- front-controller pattern에서 요청을 구분하기 위한 parameter -->
			<div class="input-group mb-3">
				<span class="input-group-text">도서번호</span>
				<input type="text" id="isbn" name="isbn" class="form-control">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text">도서명</span>
				<input type="text" id="title" name="title" class="form-control">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text">저자</span>
				<input type="text" id="author" name="author" class="form-control">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text">가격</span>
				<input type="number" id="price" name="price" class="form-control">
			</div>
			<div class="mb-3">
				<label for="file" class="form-label">이미지</label>
				<input type="file" id="file" name="file" class="form-control" accept="image/*" >
			</div>
			<div class="mb-3">
				<label for="content" class="form-label">설명</label>
				<textarea id="content" name="content" class="form-control" rows="3"></textarea>
			</div>
			<div>
				<button id="registerSubmit" >등록</button>
				<button id="reset" >취소</button>
			</div>
		</form>
		<br> <button id="booklist">도서 목록</a>
	</div>

	<div id="container">
	</div>
</body>

<script>

document.querySelector("#registerSubmit").addEventListener("click", async function() {
	let book = {
			isbn: document.querySelector("#isbn").value,
			author: document.querySelector("#title").value,
			title: document.querySelector("#author").value,
			price: document.querySelector("#price").value,
			content: document.querySelector("#content").value,
			img: document.querySelector("#file").value,
			orgImg: "unknown",
	}

	let config = {
			method: "post",
			headers: {
				"Content-Type": "application/json"
			},
			body: JSON.stringify(book),
	}

	let response = await fetch("${root}/api/book/", config);
	let json = await response.json();
	alert(JSON.stringify(json) + "추가 완료");
});

document.querySelector("#reset").addEventListener("click", function() {
	document.querySelector("#isbn").value = "",
	document.querySelector("#title").value = "",
	document.querySelector("#author").value = "",
	document.querySelector("#price").value = "",
	document.querySelector("#content").value = "",
	document.querySelector("#file").value = "",
});

document.querySelector("#booklist").addEventListener("click", async function() {
	let config = {
			method: "get",
	}

	let response = await fetch("http://localhost:8080/rest/api/booklist", config);
	let json = await response.json();
	console.log(json);
	let booklist = document.querySelector("#container");
	booklist.innerHTML = "";

	json.forEach(item => {
		let html = `<tr><td onclick="detail(\${item.isbn})">\${item.isbn}</td> <td>\${item.author}</td> <td>\${item.title}</td> <td>\${item.price}</td> <td>\${item.content}</td> <td>\${item.img}</td> <td>\${item.orgImg}</td></tr>`;
		booklist.innerHTML += html;
	});

});

</script>
</html>