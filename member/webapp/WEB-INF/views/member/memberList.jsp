<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>회원목록</h1>
		</div>
		<div>
			<table border="1">
				<tr>
					<th width="150">학생이름</th>
					<th width="150">학생아이디</th>
					<th width="150">학생패스워드</th>
					<th width="300">학생주소</th>
				</tr>
				<c:forEach var="vo" items="${members }">
					<tr> 
						<td align="center">${vo.memberName }</td>
						<td align="center">${vo.memberId }</td>
						<td align="center">${vo.memberPassword }</td>
						<td align="center">${vo.memberAddress }</td>
					</tr>
				</c:forEach>
			</table>
		</div><br/>
		<div>
			<button type="button" onclick="location.href='memberRegister.do">회원등록</button>
		</div>
	</div>
</body>
</html>