<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<ul class="navbar-nav me-auto">
		<li class="nav-item"><a class="nav-link" href="${root}/product/list">상품 목록</a></li>
		<li class="nav-item"><a class="nav-link" href="${root}/product/regist">상품 정보 등록</a></li>
		<c:if test="${empty loginUser}">
			<li><a class="nav-link" href="${root}/user/login">로그인</a></li>		
		</c:if>
		<c:if test="${!empty loginUser}">
			<li>${loginUser.name}님 반갑습니다.</li>
			<li><a class="nav-link" href="${root}/user/logout">로그아웃</a></li>	
		</c:if>
	</ul>
</nav>