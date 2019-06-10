package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookservice.BookService;
import bookservice.BookServiceImpl;
import bookservice.Dao;

@WebServlet({ "/DeleteServlet", "/delete.do" })
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		int count = 0;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String[] check = request.getParameterValues("check");
		Dao dao = new Dao();
		BookService service = new BookServiceImpl(dao);
		
		if(check == null)
			out.println("<script>alert('선택된 개체가 없습니다.'); location.href='./bookList2.jsp'; </script>");
		for(int i = 0; i < check.length; i++) {
			try {
				service.deleteBook(check[i]);
				count++;
			} catch (Exception e) {
				
			} finally {
				out.println("<script>alert('개체를 " + count + "개 삭제하였습니다.'); location.href='./bookList2.jsp'; </script>");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
