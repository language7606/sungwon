<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 실패</title>
</head>
<body>
	<div align="center">
		<h1>${member.memberId }는존재하지 않거나 패스워드가 틀렸습니다.</h1>
		<a href="memberLoginForm.do">다시 로그인</a><br />
		<a href="main.do">홈으로 가기</a>
	</div>
</body>
</html>