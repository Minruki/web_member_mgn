<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>회원관리 시스템 회원가입 페이지</title>
<link rel="stylesheet" href="css/loginForm.css">
</head>
<body>
<form name="joinform" action="joinProcess" method="get">
<table border=1>
	<tr>
		<td colspan="2" class = "td_title">
			회원가입 페이지
		</td>
	</tr>
	<tr>
		<td><label for = "id">아이디 : </label></td>
		<td><input type="text" name="id" id = "id"/></td>
	</tr>
	<tr>
		<td><label for = "pass">비밀번호 : </label></td>
		<td><input type="password" name="pass" id = "pass"/></td>
	</tr>
	<tr>
		<td><label for = "name">이름 : </label></td>
		<td><input type="text" name="name" id = "name"/></td>
	</tr>
	<tr>
		<td><label for = "age">나이 : </label></td>
		<td><input type="text" name="age" id = "age"/>
		</td>
	</tr>
	<tr>
		<td><label for = "gender"></label>성별 : </td>
		<td>
			<input type="radio" name="gender" value="남" id = "gender" checked/>남자
			<input type="radio" name="gender" value="여" id = "gender"/>여자
		</td>
	</tr>
	<tr>
		<td><label for = "email">이메일 주소 : </label></td>
		<td><input type="text" name="email" id = "email"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<a href="javascript:joinform.submit()">회원가입</a>&nbsp;&nbsp;
			<a href="javascript:joinform.reset()">다시작성</a>
		</td>
	</tr>
</table>
</form>
</body>
</html>
