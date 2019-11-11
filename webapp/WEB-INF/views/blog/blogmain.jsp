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
                    <h4><a href="<c:url value="/${bloger.id } "/>">카테고리</a></h4>
                    <ul id="category">
                    	<li>미분류?</li>
                        <c:forEach items="${categoryList }" var="clist">

	                        	<li><a href="<c:url value="/${bloger.id}?cateNo=${clist.cateNo }"/>">${clist.cateName}</a></li>

                        </c:forEach>
					</ul>
                </div>
            </div>

            <div id="postList">
            	<ul>
            		<c:forEach items="${postList }" var="plist">
						<ul>
							<li><a href="#">${plist.postTitle }</a></li>
							<li>${plist.regDate }</li>
						</ul>
            				

            		</c:forEach>
            	</ul>
            </div>

        </div>
	<c:import url="/WEB-INF/views/includes/blog-footer.jsp"/>
</div>
</body>

</html>