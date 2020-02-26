package question2;

import java.util.List;

import javax.ws.rs.*;
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
}
