package testClassesPackage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpClientClasses {
	
	

	public CloseableHttpResponse getRequestCall(String getRequestAPIURI, HashMap<String, String> geRequestHeaderMap) throws ClientProtocolException, IOException {
		
		CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(getRequestAPIURI);
		for (Map.Entry<String, String> key: geRequestHeaderMap.entrySet()) {
			httpGet.addHeader(key.getKey(),key.getValue());
		}
		
		CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpGet);
		return closeableHttpResponse;
	}
	
}
