<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<meta charset="utf-8">
	<title>Home</title>
</head>
<body>

<a href="mylogin">login</a>

<a href="mylogout">logout</a>

<h1>
	<a href="./">Hello world!</a>  
</h1>

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
