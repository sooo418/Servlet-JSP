package bookservice;

import java.util.List;

public interface BookService {
	List<Book> bookList();
	int addBook(Book vo) throws Exception;
}
