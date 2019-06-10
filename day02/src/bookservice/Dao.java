package bookservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.List;

public class Dao {
	public List<Book> bookList() {
		List<Book> list = new ArrayList<Book>();
		String sql = "select * from book";

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setBookno(rs.getInt("bookno"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getInt("price"));
				book.setPubdate(rs.getString("pubdate"));
				list.add(book);
			}

		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			JDBCUtil.close(con, ps, rs);

		}

		return list;
	}
	public static int addBook(Book vo) throws Exception {
		String sql = "insert into book(bookno, title, author, price, pubdate) "
				+ "values((select nvl(max(bookno),0)+1 from book),?,?,?,?)";

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getAuthor());
			ps.setInt(3, vo.getPrice());
			ps.setString(4, vo.getPubdate());

			row = ps.executeUpdate();

		} catch (SQLDataException e) {
			System.out.println("등록데이터확인필요");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
			throw(e);
			
		} finally {
			JDBCUtil.close(con, ps, rs);

		}
		return row;
	}
	public int deleteBook(String title) throws Exception {
		String sql = "delete from book where title= ?";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, title);
			
			row = ps.executeUpdate();
			
		} catch (Exception e) {
			throw(e);
			
		}
		
		return row;
	}
}