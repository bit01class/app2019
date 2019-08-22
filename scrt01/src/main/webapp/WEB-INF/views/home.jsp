<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
	<meta charset="utf-8">
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<sec:authorize access="isAnonymous()">
<a href="login">[login]</a>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
<a href="logout">[logout]</a>
</sec:authorize>
<a href="admin">[go admin]</a>
<a href="user">[go user]</a>

</body>
</html>
