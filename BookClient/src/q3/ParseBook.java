package q3;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class ParseBook {

	private List<Book> books;

	List<Book> parse(String response) throws XmlPullParserException, IOException{

		books = new ArrayList<>();
		
		XmlPullParser pullParser = XmlPullParserFactory.newInstance().newPullParser();
		pullParser.setInput(new StringReader(response));
		
		Book tempBook = new Book();
		
		for (int event = pullParser.getEventType(); event != pullParser.END_DOCUMENT; event = pullParser.next()) {

			if(event == pullParser.START_TAG && pullParser.getName().equals("book")) {
				tempBook = new Book();
			}
			
			if(event == pullParser.START_TAG && pullParser.getName().equals("id")) {
				event = pullParser.next();
				
				tempBook.setId(Integer.parseInt(pullParser.getText()));
			}

			if(event == pullParser.START_TAG && pullParser.getName().equals("author")) {
				event = pullParser.next();;
				
				tempBook.setAuthor(pullParser.getText());
			}

			if(event == pullParser.START_TAG && pullParser.getName().equals("title")) {
				event = pullParser.next();;
				
				tempBook.setTitle(pullParser.getText());
			}

			if(event == pullParser.START_TAG && pullParser.getName().equals("year")) {
				event = pullParser.next();;
				
				tempBook.setYear(Integer.parseInt(pullParser.getText()));
			}

			if(event == pullParser.END_TAG && pullParser.getName().equals("book")) {
				books.add(tempBook);
			}
		}

		return books;
	}
}
