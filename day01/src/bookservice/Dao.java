package bookservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;

public class Dao {
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
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);

		}
		return row;
	}
}