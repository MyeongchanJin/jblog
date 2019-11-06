<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="conti conti2">
	<div class="category-list">
    	<table>
        	<tr>
            	<th>번호</th>
           		<th>카테고리명</th>
            	<th>포스트 수</th>
            	<th>설명</th>
            	<th>삭제</th>
        	</tr>
        	<c:forEach items="${categoryList }" var="cvo">
        	    <tr>
            		<td>${cvo.cateNo}</td>
            		<td>${cvo.cateName}</td>
            		<td>포스트 갯수 작업예정(post.xml)</td>
            		<td>${cvo.description}</td>
            		<td><button type="button">삭제</button></td>
            	</tr>
        	</c:forEach>
        </table>
    </div>
    <div class="add-category-box">
        <h3>새로운 카테고리 추가</h3>
        <div>
            <div><label for="cate-name">카테고리명</label><input type="text" name="cate-name"></div>
            <div><label for="cate-desc">설명</label><input type="text" name="cate-desc"></div>
        </div>
        <button type="submit">카테고리 추가</button>
    </div>
</div>