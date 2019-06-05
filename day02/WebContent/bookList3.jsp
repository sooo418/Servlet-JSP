<%@page import="bookservice.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="table.css">
<title>Insert title here</title>
</head>
<body>
	<h1>Book List</h1>
	<table>
	<tr>
	<th>북번호</th><th>Title</th><th>Author</th><th>Price</th><th>Pubdate</th>
	</tr>
	<%//자바코드를 넣을 수 있다.
	List<Book> list = (List<Book>)request.getAttribute("list");
	for(Book data:list){
	%>
	<tr>
		<td><%= data.getBookno() %></td><td><%= data.getTitle() %></td>
		<td><%= data.getAuthor() %></td><td><%= data.getPrice() %></td>
		<td><%= data.getPubdate() %></td>
	</tr>
	
	<%
	}
	%>
	</table>
	
</body>
</html>