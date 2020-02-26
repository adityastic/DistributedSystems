package q2;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class HelloClient2 {
	
	public static void main(String[] args) throws URISyntaxException, ClientProtocolException, IOException, XmlPullParserException {
		URI uri = new URIBuilder()
				.setScheme("http")
				.setHost("localhost")
				.setPort(8080)
				.setPath("/BookServer/question1/hello")
				.build();
		
		HttpGet httpReq = new HttpGet(uri);
		httpReq.setHeader("Accept", "application/xml");

		CloseableHttpResponse httpResponse =  HttpClients.createDefault().execute(httpReq);
		
		String result = EntityUtils.toString(httpResponse.getEntity());
		
		System.out.println(result);
		
		XmlPullParser pullParser = XmlPullParserFactory.newInstance().newPullParser();
		
		pullParser.setInput(new StringReader(result));
		
		int event = pullParser.getEventType();
		
		while(event != pullParser.END_DOCUMENT) {
			
			if(event == pullParser.TEXT)
				System.out.println(pullParser.getText());
			
			event = pullParser.next();
		}
		
	}
}
