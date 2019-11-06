<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="conti conti1">
	<form action="<c:url value="/${authUser.id }/admin/basic" />" method="POST" enctype="multipart/form-data">
	    <div class="section">
	        <label>블로그 제목</label>
	        <input class="blog-title" type="text" name="blog-title" value="${blog.blogTitle }">
	    </div>
		<div class="section section-logo">
	        <label>로고 이미지</label>
	        <img width="200px" src="<c:url value="/${blog.logoFile }"/>" alt="">
	        <br>
	        <div>
	        	<input type="file" name="blog-logo">
	        </div>
	    </div>
	
	    <div class="section">
	        <input class="save-btn" type="submit" value="기본설정변경" name="save">
	    </div>
	</form>
	         
</div>
