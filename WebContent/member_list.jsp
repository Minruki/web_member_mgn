<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="id" value="${member.id }" />
<c:if test="${id eq null }">
	<c:redirect url="loginForm.jsp"/>
</c:if>

<html>
<head>
<title>회원관리 시스템 관리자모드(회원 목록 보기)</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<%-- ${list } --%>
<table border="1">
	<!-- id, passwd, name, age, gender, email -->
	<tr><td colspan="6" class="td_title">회원 목록</td></tr>
	<tr>
		<td>아이디</td><td>성명</td><td>나이</td>
		<td>성별</td><td>메일</td><td>비고</td>
	</tr>
	<c:forEach var="member" items="${list }">
	<tr>
		<td>${member.id }</td>
		<td>${member.name }</td>
		<td>${member.age }</td>
		<td>${member.gender }</td>
		<td>${member.email }</td>
		<td>
			<a href="updateMember?id=${member.id}">수정</a>&nbsp;
			<a href="deleteMember?id=${member.id}">삭제</a>
		</td>
	</tr>
	</c:forEach>
</table>
<a href="main.jsp">메인으로</a>&nbsp;&nbsp;
<a href="joinForm.jsp">회원 추가하기</a>
</body>
</html>
