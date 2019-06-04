package servlet;

import java.io.IOException;

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
		
		String btitle = request.getParameter("btitle");
		String bauthor = request.getParameter("bauthor");
		int bprice = Integer.parseInt(request.getParameter("bprice"));
		String bpubdate = request.getParameter("bpubdate");
		
		Dao dao = new Dao();
		BookService service = new BookServiceImpl(dao);
		Book user = new Book(btitle, bauthor, bprice, bpubdate);
		
		try {
			service.addBook(user);
		} catch (Exception e) {
			System.out.println("등록 데이터 확인하세요");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
