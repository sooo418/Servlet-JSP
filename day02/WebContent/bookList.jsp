<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/table.css">
<title>Insert title here</title>
</head>
<body>
	<h1>Book List el</h1>
	<h3>로그인 정보 ID: ${id}</h3>
	<table>
	<tr>
	<th>북번호</th><th>Title</th><th>Author</th><th>Price</th><th>Pubdate</th><th><button>삭제</button></th>
	</tr>
	<c:forEach var="book" items="${list}">
	<%-- ${list}는 서블릿이 포워딩으로 값을 넘겨주기 때문에ListBookServlet.servlet이 실행되야 list값를 받아 
	book객체를 출력받을 수 있는데 bookList.jsp파일을 직접 실행시키면 받는 값이 없기 때문에 book객체가 존재하지않는다 --%>
	
	<tr>
		<td>${book.bookno}</td><td>${book.title}</td>
		<td>${book.author}</td><td>${book.price}</td>
		<td>${book.pubdate}</td><td><input type="checkbox"></td>
	</tr>
	</c:forEach>
	</table>
	
</body>
</html>