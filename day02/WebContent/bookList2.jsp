<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="bookservice.Book"%>
<%@page import="java.util.List"%>
<%@page import="bookservice.Dao"%>
<%@page import="bookservice.BookServiceImpl"%>
<%@page import="bookservice.BookService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/table.css">
<title>Insert title here</title>
</head>
<body>
	<h1>Book List</h1>
	<h2>로그인 정보 ID: ${id}</h2>
	<form action="delete.do" method="get">
		<table>
			<tr>
				<th>북번호</th><th>Title</th><th>Author</th>
				<th>Price</th><th>Pubdate</th>
				<th><input type="submit" value="삭제" 
				onclick="return confirm('정말 삭제하시겠습니까?')"></th>
			</tr>
	<%//자바코드를 넣을 수 있다.
	Dao dao = new Dao();
	BookService service = new BookServiceImpl(dao);
	List<Book> list = service.bookList();
	for(Book data:list){
		String pubdate = "";
		DateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
		if(data.getPubdate() != null){
			Date temp = sdFormat.parse(data.getPubdate());
			pubdate = sdFormat.format(temp);
		}
		else{
			Date nowDate = new Date();
			pubdate = sdFormat.format(nowDate);
		}
	%>
			<tr>
				<td><%= data.getBookno() %></td><td><%= data.getTitle() %></td>
				<td><%= data.getAuthor() %></td><td><%= data.getPrice() %></td>
				<td><%= pubdate %></td>
				<td><input type="checkbox" name="check" value="<%= data.getTitle() %>"></td>
			</tr>
	
	<%
	}
	%>
		</table>
	</form>
	
</body>
</html>