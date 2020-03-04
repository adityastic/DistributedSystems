
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

public class Client1Post {

	public static void main (String[] args) throws Exception {
		URI uri = new URIBuilder()
				.setScheme("http")
				.setHost("localhost")
				.setPort(8080)
				.setPath("/BookServer/question2/books").build();
		System.out.println(uri.toString());
		
		HttpPost httpPost = new HttpPost(uri);
		httpPost.setHeader("Accept", "application/json");
		CloseableHttpClient client = HttpClients.createDefault();
		
		// POST
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
		nameValuePairs.add(new BasicNameValuePair("id", "13"));
		nameValuePairs.add(new BasicNameValuePair("title", "Programming Scala"));
		nameValuePairs.add(new BasicNameValuePair("author", "Wampler"));
		nameValuePairs.add(new BasicNameValuePair("year", "2013"));
		
		httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		System.out.println("Sending request...");
		CloseableHttpResponse response = client.execute(httpPost);
		
		System.out.println("Response: " + response.toString());
	}
}
