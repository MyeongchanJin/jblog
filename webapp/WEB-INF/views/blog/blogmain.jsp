<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Blog</title>
    <link rel="stylesheet" href="<c:url value="/assets/myhome/css/blogstyle.css"/>">
</head>

<body>
<div id="wrap">
	<c:import url="/WEB-INF/views/includes/blog-header.jsp"/>
        <div id="main">
            <div id="content">
                <h3>등록된 글이 없습니다.</h3>
            </div>
            <div id="sidemenu">
                <div id="logo">
                    <img alt="" src="" />
                </div>
                <div>
                    <h4>카테고리</h4>
                    <ul id="category">
                        <li>미분류</li>
                    </ul>
                </div>
            </div>
        </div>
	<c:import url="/WEB-INF/views/includes/blog-footer.jsp"/>
</div>
</body>

</html>