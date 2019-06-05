<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	HttpSession HttpSession = request.getSession();
	HttpSession.invalidate();
	out.println("<script>alert('로그아웃 되었습니다.'); location.href='./index.jsp';</script>");
	%>
</body>
</html>