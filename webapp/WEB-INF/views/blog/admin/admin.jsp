<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Administer</title>
		<link rel="stylesheet" href="<c:url value="/assets/myhome/css/blogstyle.css?3"/>">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
		<style>
			#sidemenu {
				display: none;
			}
		</style>
	</head>
	<body>
    <div id="wrap">
		<c:import url="/WEB-INF/views/includes/blog-header.jsp"/>
        <div id="main">
            <nav class="tab-btn">
                <ul>
                    <li class="active"><a href="<c:url value="/${authUser.id }/admin/basic"/>">기본설정</a></li>
                    <li><a href="<c:url value="/${authUser.id }/admin/category"/>">카테고리</a></li>
                    <li><a href="<c:url value="/${authUser.id }/admin/post"/>">글 작성</a></li>
                </ul>
            </nav>

            <div id="content" class="tab-cont">
                <div class="conti conti1">

                    <div class="section">
                        <label>블로그 제목</label>
                        <input class="blog-title" type="text" name="blog-title">
                    </div>
                    <div class="section section-logo">
                        <label>로고 이미지</label>
                        <img width="200px" src="<c:url value="/images/springbasic.png"/>" alt="">
                        <br>
                        <div>
                            <button type="button">파일선택</button>
                            <label>선택한 파일 없음</label>
                        </div>
                    </div>
                    <div class="section">
                        <input class="save-btn" type="submit" value="기본설정변경" name="save">
                    </div>

             
                </div>
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
                            <tr>
                                <td>${cateNo}</td>
                                <td>${cateName}</td>
                                <td>포스트 수---post</td>
                                <td>${description}</td>
                                <td><button type="button">삭제</button></td>
                            </tr>
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
	<script>
    $(function () {
        var tabBtn = $(".tab-btn > ul > li");
        var tabCont = $(".tab-cont > div");

        tabCont.hide().eq(0).show();

        tabBtn.click(function (e) {
            e.preventDefault();
            var target = $(this);
            var index = target.index();
            tabBtn.removeClass("active");
            target.addClass("active");
            tabCont.css("display", "none");
            tabCont.eq(index).css("display", "block");
        });
    });
</script>
</html>