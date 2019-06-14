<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL SQL Context Datasource lookup</title>
<link rel="stylesheet" href="http://70.12.115.67:9090/day02/css/table.css">
</head>
<body>

<sql:query var="rs" dataSource="jdbc/oracle">
   
select ename,job,d.deptno,dname,loc
from emp e join dept d
on e.deptno = d.deptno
</sql:query>
<table border="1">
		<tr>
			<c:forEach var="columnName" items="${rs.columnNames}">
				<th><c:out value="${columnName}" /></th>
			</c:forEach>
		</tr>

		<c:forEach var="row" items="${rs.rows}">
			<tr>
				<td>${row.ename}</td> 
				<td>${row.job}</td>
				<td><c:out value="${row.d.deptno}"/></td>
				<td><c:out value="${row.dname }"/></td>
				<td><c:out value="${row.loc }"/></td>
			</tr>
		</c:forEach>

</table>

</body>
</html>