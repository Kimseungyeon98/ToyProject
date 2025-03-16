<%@ page language="java" contentType="text/html; charsset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	안녕하세요  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<a href='<c:url value='/board/list'/>' role="button" class="btn btn-outline-info">들어가기</a>

</body>
</html>