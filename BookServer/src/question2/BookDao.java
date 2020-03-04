package question2;

import java.util.*;

public enum BookDao {
	INSTANCE;
	
	private List<Book> booksList = new ArrayList<Book>();
	
	private BookDao() {
//		for(int i = 1; i < 1000; i++) {
//			Book book = new Book();
//			book.setId(i);
//			book.setTitle("Book " + i);
//			book.setAuthor("Bill Burke");
//			book.setYear(2009);
//			
//			booksMap.put(i, book);
//		}
		
		Book book1 = new Book();
		book1.setId(1);
		book1.setTitle("RESTful Java with JAX-RS");
		book1.setAuthor("Bill Burke");
		book1.setYear(2009);
		
		booksList.add(book1);
		
		Book book2 = new Book();
		book2.setId(2);
		book2.setTitle("Java message service");
		book2.setAuthor("David A. Chappell, Richard Monson-Haefel");
		book2.setYear(2000);
		
		booksList.add(book2);
	}
	
	public List<Book> getBooks() {
		return booksList;
	}
	
	public Book getBook(int id) {
		for (Book book : booksList) {
			if(book.getId() == id)
				return book;
		}
		return null;
	}

	public void create(Book book) {
		booksList.add(book);
	}

	public void delete(int id) {
		Iterator<Book> iter = booksList.iterator();
		while(iter.hasNext()) {
			if(iter.next().getId() == id)
				iter.remove();
		}
	}
}
