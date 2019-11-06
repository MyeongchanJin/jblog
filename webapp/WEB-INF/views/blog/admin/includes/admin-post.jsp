<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="conti conti3">
	<form action="<c:url value="/${authUser.id }/admin/write" />" method="POST">
		<div>
	        <label for="">제목</label>
	        <input type="text" name="post-title">
	        <select name="post-category">
	        	<c:forEach items="${categoryList }" var="cvo">
	        		<option value="${cvo.cateNo }">${cvo.cateName }</option>
	        	</c:forEach>
	        </select>
	    </div>
	    <div>
	        <label for="">내용</label>
	        <textarea name="post-content" cols="30" rows="10"></textarea>
	    </div>
	    <button type="submit">포스트 하기</button>
	</form>

</div>