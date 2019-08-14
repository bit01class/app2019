<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
	<meta charset="utf-8">
	<title>Home</title>
</head>
<body>

<h1>
	<a href="./">Hello world!</a>  
</h1>
<div>
<sec:authorize access="isAnonymous()">
	<a href="./login">로그인</a>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
	<a href="./logout">로그아웃</a>
</sec:authorize>
</div>
<div>
<a href="admin">admin</a>
<a href="member">member</a>
</div>

<a href="add">add</a>
<form action="find">
	<input type="text" name="num"/><button>검색</button>
</form>
<div>
	${list }
	${bean.num }
	${bean.name }
	${bean.nalja }
	${bean.cnt }
</div>
</body>
</html>
