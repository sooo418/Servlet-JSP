<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>title</title>
<style>
header {
	margin: 0px;
	text-align: center;
	background-color: lightgreen;
	height: 120px;
}

ul {
	list-style: none;
}

ul li a {
	text-decoration: none;
}

nav ul li {
	display: inline-block;
	border-radius: 10px 10px 0 0;
	background-color: pink;
	width: 80px;
	height: 20px;
	padding: 20px;
	text-align: center;
}

nav ul {
	background-color: lightgreen;
	margin: 0 auto;
	text-align: center;
}

.nullspace {
	height: 35px;
	background-color: purple;
}

#left_aside {
	float: left;
	background-color: skyblue;
	width: 20%;
	height: 550px;
}

#left_aside ul li {
	border-radius: 15px;
	background-color: lightgreen;
	width: 70px;
	height: 10px;
	padding: 10px;
	text-align: center;
	border: 2px solid white;
	margin: 5px;
	position: relative;
	right: 40px;
}

#right_aside {
	display: table-row;
	background-color: skyblue;
	width: 20%;
	height: 550px;
	float: right;
}
#right_aside ul li{
	padding: 10px;
}
section {
	display: table-cell;
	text-align: center;
}
article{
	position: relative;
	top:10px;
	left: 225px;
}
table{
	width:300px;
	height: 150px;
	border: 3px solid black;
	border-collapse: collapse;
}
table tr:nth-child(2n+1) {
	background-color: gray;
}
table tr:first-child {
	background-color: black;
	color:yellow;
}
footer{
	background-color: lightpink;
	clear: both;
	height: 120px;
}
</style>
</head>
<body>
	<div>
		<header>
			<hgroup>
				<h1>HTML5 & CSS3.0</h1>
				<h6>javascript, jquery, ajax</h6>
			</hgroup>
		</header>
		<nav>
			<ul>
				<li><a href="#">HTML5</a></li>
				<li><a href="#">CSS</a></li>
				<li><a href="#">JavaScript</a></li>
				<li><a href="#">jQuery</a></li>
				<li><a href="#">Ajax</a></li>
			</ul>
		</nav>

		<div class="nullspace"></div>
		<aside id="left_aside">
			<ul>
				<li><a href="#">기능1</a></li>
				<li><a href="#">기능2</a></li>
				<li><a href="#">기능3</a></li>
			</ul>
		</aside>
		
		<aside id="right_aside">
			<ul>
				<li><img src="/edu1/img/car.jpg" alt="" width="130px" height="40px"></li>
				<li><img src="/edu1/img/Lighthouse.jpg" alt="" width="130px" height="40px"></li>
				<li><img src="/edu2/img/cat.jpg" alt="" width="130px" height="40px"></li>
				<li><img src="/edu1/img/coffee1.gif" alt="" width="130px" height="40px"></li>
			</ul>
		</aside>
		<section>
			<article>
				<h2>Table CSS</h2>
				<table border="1">
					<tr>
						<th colspan="3">ID &nbsp;&nbsp;&nbsp;&nbsp; PWD &nbsp;&nbsp; NAME</th>
					</tr>
					<tr>
						<td colspan="3">java01 &nbsp;&nbsp; 1234 &nbsp;&nbsp; 홍길동</td>
					</tr>
					<tr>
						<td colspan="3">java02 &nbsp;&nbsp; 1234 &nbsp;&nbsp; 고길동</td>
					</tr>
					<tr>
						<td colspan="3">java03 &nbsp;&nbsp; 1234 &nbsp;&nbsp; 박길동</td>
					</tr>
					<tr>
						<td colspan="3">java04 &nbsp;&nbsp; 1234 &nbsp;&nbsp; 김길동</td>
					</tr>
					<tr>
						<td colspan="3">java05 &nbsp;&nbsp; 1234 &nbsp;&nbsp; 최길동</td>
					</tr>
				</table>
			</article>
		</section>
<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>