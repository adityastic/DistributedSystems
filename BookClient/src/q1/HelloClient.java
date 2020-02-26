package q1;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HelloClient {
	
	public static void main(String[] args) throws URISyntaxException, ClientProtocolException, IOException {
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
	}
}
