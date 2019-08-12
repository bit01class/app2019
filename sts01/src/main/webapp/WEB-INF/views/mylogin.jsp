<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<c:out value="${logout }"></c:out>
</div>
	<h1>로그인</h1>
	<form action="login" method="post">
	<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
		<div>
			id<input type="text" name="username" />
		</div>
		<div>
			pw<input type="password" name="password" />
		</div>
		<div>
			<button>로그인</button>
		</div>
	</form>
</body>
</html>