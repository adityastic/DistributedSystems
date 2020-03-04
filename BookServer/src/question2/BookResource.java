package question2;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/books")
public class BookResource {

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
	public List<Book>getBooks(){
		return BookDao.INSTANCE.getBooks();
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
	@Path("{bookId}")
	public Book getBook(@PathParam("bookId") String id){
		return BookDao.INSTANCE.getBook(Integer.parseInt(id));
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Book postBook(
			@FormParam("id") String id,
			@FormParam("title") String title,
			@FormParam("author") String author,
			@FormParam("year") String year,
			@Context HttpServletResponse httpServletResponse) {
		System.out.println("Inside POST id = "+ id);
		System.out.println("title = " + title);

		Book book = new Book();
		book.setId(Integer.parseInt(id));
		book.setTitle(title);
		book.setAuthor(author);
		book.setYear(Integer.parseInt(year));
		BookDao.INSTANCE.create(book);

		return BookDao.INSTANCE.getBook(Integer.parseInt(id));
	}

	@DELETE
	@Produces(MediaType.TEXT_HTML)
	@Path("/{bookId}")
	public void deleteBook(
			@PathParam("bookId") String id
			) {
		BookDao.INSTANCE.delete(Integer.parseInt(id));
	}
	
	@PUT
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/{bookId}")
	public void putBook(
			@PathParam("bookId") String id,
			@FormParam("title") String title, 
			@FormParam("author") String author,
			@FormParam("year") String year,
			@Context HttpServletResponse servletResponse) {
		
		Book book = new Book();
		book.setId(Integer.parseInt(id));
		book.setTitle(title);
		book.setAuthor(author);
		book.setYear(Integer.parseInt(year));
		BookDao.INSTANCE.create(book);
	}
}

