<%@ page language="java" contentType="text/html; charset=UTF-8" %>
	<%-- User를 사용하기 위해 dto 패키지를 import 한다. --%>
		<%@ page import="com.ssafy.ws.model.dto.*" %>
			<%-- jstl의 core 라이브러리를 사용하기 위해 taglib를 이용한다. --%>
				<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
					<%--절대경로를 쉽게 사용하기 위해 session에 root를 key로 컨텍스트 루트 경로를 저장해둔다. --%>
						<c:set value="${pageContext.request.contextPath }" scope="session" var="root"></c:set>

						<!DOCTYPE html>
						<html>

						<head>
							<meta charset="UTF-8">
							<title>SSAFY 도서 관리</title>
							<%--절대경로를 쉽게 사용하기 위해 session에 root를 key로 컨텍스트 루트 경로를 저장해둔다. --%>
								<c:set value="${pageContext.request.contextPath }" scope="session" var="root"></c:set>
								<%-- bootstrap 관련 코드를 등록한다. --%>
									<!-- CSS only -->
									<link
										href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
										rel="stylesheet"
										integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
										crossorigin="anonymous">
									<!-- JavaScript Bundle with Popper -->
									<script
										src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
										integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
										crossorigin="anonymous"></script>
									<%-- 프로젝트에서 정의한 CSS를 참조할 때 resources 경로를 참조한다. --%>
										<link rel="stylesheet" href="${root }/resources/css/common.css">
										<style>
										</style>
						</head>

						<body>
							<div class="container">
								<img src="${root }/resources/img/ssafy_logo.png" id="ssafy_logo">
								<h1 class="display-4 text-center">도서 관리</h1>
								<br>
								<div class="d-flex justify-content-end">
									<%-- session에서 loginUser를 가져와서 존재 여부에 따라 로그인 폼 또는 사용자 정보를 출력한다. --%>
										<%--로그인 정보가 없을 경우는 로그인을 위한 폼을 제공한다. --%>
											<c:if test="${empty loginUser }">
												<form method="post" action="${root }/login">
													<div>
														<input type="text" name="id" id="id" placeholder="아이디">
														<input type="password" name="pass" id="pass" placeholder="비밀번호">
														<input type="submit" id="submit" class="btn btn-primary"
															value="로그인">
													</div>
												</form>
											</c:if>
											<%--로그인 정보가 있는 경우는 사용자 이름과 로그아웃을 위한 링크를 생성한다.--%>
												<c:if test="${!empty loginUser }">
													<div>
														${loginUser.name }님 반갑습니다.
														<button id="logoutBtn">로그아웃</button>
													</div>
												</c:if>
								</div>
							</div>
							<hr>

							<div class="selections">
								<ul>
									<li><a href="${root}/regist" id="bookRegister">도서 등록</a></li>
									<li>도서 목록 <button id="bookList"> 보기</button></li>
								</ul>
							</div>


							<div id="container">
							</div>


						</body>

						<script>



							window.onload = function () {
								let user = JSON.stringify("${loginUser.id}");

								let userLoggedIn = ${!empty loginUser
							};

							console.log(userLoggedIn);

							if (!userLoggedIn) {

								console.log("user not logged in")


								// 로그인 기능
								document.querySelector("#submit").addEventListener("click", async function () {
									let user = {
										id: document.querySelector("#id").value,
										name: "unknown",
										pass: document.querySelector("#pass").value,
									}

									let config = {
										method: "post",
										headers: {
											"Content-Type": "application/json"
										},
										body: JSON.stringify(user),
									}

									let response = await fetch("${root}/api/user/login", config);
									let json = await response.json();
									alert(JSON.stringify(json.message))

									// 만약 새로고침 안될 경우 주석 해제
									// location.reload();
								});


								return;
							} else {

								console.log("user is logged in")
								// 로그아웃
								document.querySelector("#logoutBtn").addEventListener("click", async function () {
									let config = {
										method: "get",
									}

									let response = await fetch("${root}/api/user/logout", config);
									let json = await response.json();
									console.log(json);
									alert(JSON.stringify(json.message))

									// 만약 새로고침 안될 경우 주석 해제
									location.reload();
								});
							}
}



							document.querySelector("#bookList").addEventListener("click", async function () {
								let config = {
									method: "get",
								}
								console.log("hello");

								let response = await fetch("${root}/api/book", config);
								let json = await response.json();
								json = json.data;
								let booklist = document.querySelector("#container");
								booklist.innerHTML ="";
								booklist.innerHTML += `<table class="table table-striped">
                                                      			<thead>
                                                      				<tr>
                                                      					<th>번호</th>
                                                      					<th>ISBN</th>
                                                      					<th>제목</th>
                                                      					<th>저자</th>
                                                      					<th>가격</th>
                                                      				</tr>
                                                      			</thead>
                                                      			<tbody>`;
								json.forEach(item => {
								let html = `<tr> <td onclick="detail(\${item.isbn})">\${item.isbn}</td>
                                        <td>\${item.author}</td>
                                        <td>\${item.title}</td>
                                        <td>\${item.price}</td>
                                        <td>\${item.content}</td></tr> `;
									booklist.innerHTML += html;
								});
								booklist.innerHTML +=`	</tbody>
                                                      		</table>`;
							});

							async function detail(isbn) {
								let config = {
									method: "get",
								}

								let response = await fetch("${root}/api/book/" + isbn, config);
								let json = await response.json();
								console.log(json);
								document.querySelector("#container").innerHTML = JSON.stringify(json);
							}

						</script>



						</html>