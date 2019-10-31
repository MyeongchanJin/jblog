<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<c:import url="/WEB-INF/views/includes/header.jsp"/>
	<form action="">
		<input type=text name="searchBox"/>
		<button type="submit" value="search">검색</button>
		<br />
		<input type="radio" name="searchMenu" value="blogTitle" checked/>블로그 제목
		<input type="radio" name="searchMenu" value="bloger" />블로거
	</form>
</body>
</html>