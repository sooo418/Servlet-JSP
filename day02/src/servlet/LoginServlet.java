package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({"/login.do","/logout.do"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		PrintWriter out = response.getWriter();  
		
		if(id==null||pw==null||id.length()==0||pw.length()==0) {
			response.sendRedirect("./login.jsp");
			return;
		}
		HttpSession session = request.getSession();	//session 객체 생성
		if(id.equals("scott") && pw.equals("!aA1")) {
			session.setAttribute("id", id);	//session객체에 id 저장
			session.setAttribute("pw", pw);	//session객체에 pw 저장
			//String n=(String)session.getAttribute("id");  //object형이라서 형변환 반드시 필요
			//String n1=(String)session.getAttribute("pw");  //object형이라서 형변환 반드시 필요
	        //out.print("Hello "+n); 
	        //out.print("Hello "+n1); 
			getServletContext().getRequestDispatcher("/index.jsp").
			forward(request, response);
			
		}else {
			out.println("<script>alert('id 또는 pw를 잘못 입력하셨습니다.'); location.href='./login.jsp';</script>");
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession HttpSession = request.getSession();
		HttpSession.invalidate();
		PrintWriter out = response.getWriter();
		out.println("<script>alert('로그아웃 되었습니다.'); location.href='./index.jsp';</script>");
		
	}
}
