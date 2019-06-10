package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bookservice.Book;
import bookservice.BookService;
import bookservice.BookServiceImpl;
import bookservice.Dao;

@WebServlet({ "/ListBookServlet", "/list.do" })
public class ListBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String pw = (String)session.getAttribute("pw");
		if(id==null) {
			out.println("<script>alert('도서목록을 보려면 로그인을 해주세요.'); location.href='./login.jsp'; </script>");
		}
		else if(id.equals("scott") && pw.equals("!aA1")) {
			Dao dao = new Dao();
			BookService service = new BookServiceImpl(dao);
			List<Book> list = service.bookList();

			request.setAttribute("list", list);

			getServletContext().getRequestDispatcher("/bookList2.jsp").forward(request, response);
		}else {
			out.print("<h2>잘못된 정보입니다.");
		}
		
	}

}
