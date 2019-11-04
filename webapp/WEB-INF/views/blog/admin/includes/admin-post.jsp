<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="conti conti3">
    <div>
        <label for="">제목</label>
        <input type="text" name="post-title">
        <select name="cate-name">
            <option value="스프링MVC">스프링MVC</option>
            <option value="서블릿_JSP">서블릿_JSP</option>
            <option value="오라클">오라클</option>
            <option value="자바프로그래밍">자바프로그래밍</option>
        </select>
    </div>
    <div>
        <label for="">내용</label>
        <textarea name="post-content" cols="30" rows="10"></textarea>
    </div>
    <button type="submit">포스트 하기</button>
</div>