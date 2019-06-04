package bookservice;

public class BookServiceImpl implements BookService{

	private Dao	dao = null;
	
	public BookServiceImpl(Dao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public int addBook(Book vo) throws Exception {
		return Dao.addBook(vo);
	}

}
