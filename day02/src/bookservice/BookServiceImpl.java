package bookservice;

import java.util.List;

public class BookServiceImpl implements BookService{

	private Dao dao = null;

	public BookServiceImpl() {
		super();
	}

	public BookServiceImpl(Dao dao) {
		super();
		this.dao = dao;
	}

	public Dao getDao() {
		return dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}

	@Override
	public List<Book> bookList() {
		return dao.bookList();
	}

	@Override
	public int addBook(Book vo) throws Exception {

		return dao.addBook(vo);
	}

	@Override
	public int deleteBook(String title) throws Exception {
		return dao.deleteBook(title);
	}
	
}
