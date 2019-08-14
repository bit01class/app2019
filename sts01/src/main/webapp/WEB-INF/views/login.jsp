<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 페이지</h1>
	<form method="post">
			<input type="hidden"  name="${_csrf.parameterName }" value="${_csrf.token }"/>
		<div>
			<input type="text"  name="username"/>
		</div>
		<div>
			<input type="password"  name="password"/>
		</div>
		<div>
			<input type="submit" value="로그인" />
		</div>
	</form>
</body>
</html>