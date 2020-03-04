
import java.net.URI;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Client2Delete {
	
	public static void main (String[] args) throws Exception {
		URI uri = new URIBuilder()
				.setScheme("http")
				.setHost("localhost")
				.setPort(8080)
				.setPath("/Lab6/rest/books/13").build();
		System.out.println(uri.toString());
		
		HttpDelete httpDelete = new HttpDelete(uri);
		httpDelete.setHeader("Accept", "text/html");
		CloseableHttpClient client = HttpClients.createDefault();
		
		System.out.println("Sending DELETE request...");
		CloseableHttpResponse response = client.execute(httpDelete);
		System.out.println("Response: " + response.toString());
	}
}
