<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
</head>
<body>
<c:import url="/WEB-INF/views/includes/header.jsp"/>
<h1>Join</h1>
	<form action="<c:url value="/user/join" />" method="post">
		<label>이름</label>
		<input type="text" name="name" />
		<br>
		<label>아이디</label>
		<input type="text" name="id" />
		<button type="button">ID 중복체크</button>
		<!-- ID Validation -->
		<br>
		<label>패스워드</label>
		<input type="password" name="password" />
		<br>
		<label>약관동의</label>
		<input type="checkbox" name="policy"  />서비스 약관에 동의합니다.
		<br>
		<input type="submit" name="submit" value="회원가입">
	</form>
</body>
</html>