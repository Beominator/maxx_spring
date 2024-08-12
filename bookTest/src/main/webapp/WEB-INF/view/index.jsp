<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관리</title>

<link rel = "stylesheet" href = "/css/default.css">
</head>
<body>

	<a href = "/coffeeReg">커피등록</a>
	<!-- 
	클래스명
		컨트롤 : CoffeeControl
		서비스 : CoffeeService
		DTO : CoffeeDto
		DAO : CoffeeDao -->
	
	<div id = "wrap">
		<h2> 도서관리 </h2>
		<div id = "mainTitle">
			<h3>등록 도서 목록</h3>
			<a href = "/bookWrite" id = "enroll">도서등록</a>
		</div>
		<div id = "bookListWrap">
			<ul id = "bookList">
				<li class = "blist">
					<span class = "title"> 자바의 기초 </span>
					<span class = "auth">가나</span>
					<span class = "bookCode">ㅁㅇㄴㅍ79</span>
					<span class = "category">언어</span>
				</li>
				<li class = "blist">
					<span class = "title"> 임의로 </span>
					<span class = "auth">넣는게</span>
					<span class = "bookCode">대ㅑㅁㅇ34</span>
					<span class = "category">운영체제</span>
				</li>
				<li class = "blist">
					<span class = "title"> 세상에서 </span>
					<span class = "auth">제일</span>
					<span class = "bookCode">ㅂㅈㄹㄴㅁㅍ23</span>
					<span class = "category">프로그래밍</span>
				</li>
				<li class = "blist">
					<span class = "title"> 어려운거 </span>
					<span class = "auth">같아요</span>
					<span class = "bookCode">ㄷㄱㅎ31</span>
					<span class = "category">응용</span>
				</li>
				<li class = "blist">
					<span class = "title"> 휴 </span>
					<span class = "auth">끝났다</span>
					<span class = "bookCode">ㅂㅈㄹㅍ1</span>
					<span class = "category">기초</span>
				</li>
			</ul>
		</div>
	</div>
</body>
</html>