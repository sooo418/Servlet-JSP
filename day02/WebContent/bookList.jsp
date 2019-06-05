<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="table.css">
<title>Insert title here</title>
</head>
<body>
	<h1>Book List el</h1>
	<table>
	<tr>
	<th>북번호</th><th>Title</th><th>Author</th><th>Price</th><th>Pubdate</th>
	</tr>
	<c:forEach var="book" items="${list}">
	<tr>
		<td>${book.bookno}</td><td>${book.title}</td>
		<td>${book.author}</td><td>${book.price}</td>
		<td>${book.pubdate}</td>
	</tr>
	</c:forEach>
	</table>
	
</body>
</html>