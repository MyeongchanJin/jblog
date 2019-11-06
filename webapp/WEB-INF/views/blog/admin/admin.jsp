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
                    <li><a href="<c:url value="/${authUser.id }/admin/basic"/>">기본설정</a></li>
                    <li><a href="<c:url value="/${authUser.id }/admin/category"/>">카테고리</a></li>
                    <li><a href="<c:url value="/${authUser.id }/admin/post"/>">글 작성</a></li>
                </ul>
            </nav>
			<div id="content" class="tab-cont">
				<c:choose>
					<c:when test="${opt eq 'basic' }">
						<c:import url="/WEB-INF/views/blog/admin/includes/admin-basic.jsp" charEncoding="UTF-8"/>
					</c:when>
					<c:when test="${opt eq 'category' }">
						<c:import url="/WEB-INF/views/blog/admin/includes/admin-category.jsp" charEncoding="UTF-8"/>
					</c:when>
					<c:when test="${opt eq 'post' }">
						<c:import url="/WEB-INF/views/blog/admin/includes/admin-post.jsp" charEncoding="UTF-8"/>
					</c:when>
					<c:otherwise>
						<c:import url="/WEB-INF/views/blog/admin/includes/admin-basic.jsp" charEncoding="UTF-8"/>
					</c:otherwise>				
				</c:choose>
	
            </div>

            <div id="sidemenu">
                <div id="logo">
                    <img alt="" src="<c:url value="/images/springbasic.png"/>" />
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
<!--  
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
    -->
</script>

</html>