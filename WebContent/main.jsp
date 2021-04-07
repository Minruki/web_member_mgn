<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="id" value="${member.id }" />
<c:if test="${id eq null }">
	<c:redirect url="loginForm.jsp"/>
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
<link rel="stylesheet" href="css/style.css">
<!-- <link rel="stylesheet" href="css/style.css"> -->
</head>
<body>
	<h3>${id }로 로그인 하셨습니다.</h3>
	<a href="logoutProcess">로그 아웃</a><br>
	<c:if test="${id eq 'admin' }">
		<a href="memberList">관리자모드 접속(회원 목록 보기)</a>
	</c:if>
</body>
</html>