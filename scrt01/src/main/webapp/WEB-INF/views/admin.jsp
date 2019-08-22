<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>admin page</h1>
	<a href="./">[HOME]</a>
<sec:authorize access="isAnonymous()">
<a href="login">[login]</a>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
<a href="logout">[logout]</a>
</sec:authorize>
</body>
</html>