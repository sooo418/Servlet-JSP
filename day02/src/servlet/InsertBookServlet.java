package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookservice.Book;
import bookservice.BookService;
import bookservice.BookServiceImpl;
import bookservice.Dao;

@WebServlet({ "/InsertBookServlet", "/book.do" })
public class InsertBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		int price = Integer.parseInt(request.getParameter("price"));
		String pubdate = request.getParameter("pubdate");
		
		Dao dao = new Dao();
		BookService service = new BookServiceImpl(dao);
		Book user = new Book(title, author, price, pubdate);
		
		try {
			int i = service.addBook(user);
			response.sendRedirect("list.do");
			//out.print("<h1>" + i +"개의 row 입력 완료");
		} catch (Exception e) {
			request.setAttribute("exception", e);
			
			getServletContext().
			getRequestDispatcher("/error.jsp").
			forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
