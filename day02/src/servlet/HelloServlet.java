package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/Hello", "/hello.do" })//urlPatterns는 생략되어 있다.
//@WebServlet(urlPatterns = { "/Hello", "/hello.do" },loadOnStartup=1) ->
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HelloServlet() {
		System.out.println("HelloServlet() 객체 생성 ");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("HelloServlet => init() 수행 ");
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//service 메소드는get방식과 post방식 모두 허용된다.
		request.setCharacterEncoding("utf-8");
		//클라이언트는 요청을 할 때 정보를 넘긴다. 그 정보들의 문자들 타입을 utf-8로 변경해주는 메소드
		response.setContentType("text/html;charset=utf-8");
		//서버가 클라이언트에게 정보를 응답해줄 때 문자들 타입을 utf-8로 표현해주는 메소드
		
		//서버는 클라이언트에게 정보를 심을 수 있다.
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("HelloServlet => doGet service");
		
		PrintWriter out = response.getWriter();	//응답할 내용을 표시할 객체
		out.print("<h1> HelloServlet 페이지입니다. </h1>");
		
		String name = request.getParameter("name");	//값을 가져오는 메소드
		if(name != null)
			out.print("<h3> 당신의 성은 : " + name.charAt(0) + " </h3>");
		
		String addr = request.getParameter("addr");
		out.print("<h3> 당신의 주소는 : " + addr + " </h3>");
	}
	/*
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("HelloServlet => doPost service");
		
		doGet(request, response);
	}
	*/
	@Override
	public void destroy() {
		System.out.println("HelloServlet => destroy 자원반납 코드 ");
	}

}
