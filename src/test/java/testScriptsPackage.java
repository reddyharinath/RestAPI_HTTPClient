import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import basePackage.APIBaseClass;
import testClassesPackage.HttpClientClasses;
import utilPackage.UtilityClass;

public class testScriptsPackage extends APIBaseClass {
	
	public testScriptsPackage() {
		super();
	}
	
	public String serverURL;
	public String getRequestURI;
	public String getRequestURL;
	public ExtentHtmlReporter extentHtmlReporter;
	public HttpClientClasses httpClientClasses;
	public CloseableHttpResponse closeableHttpResponse;

	@BeforeMethod
	public void beforeGetRequestTest() {
		serverURL = prop.getProperty("ServerURL");
		getRequestURI = prop.getProperty("GetUsersURL");
		getRequestURL = serverURL+getRequestURI;
		System.out.println("the server url --- >"+serverURL);
		System.out.println("the get request URI --->"+getRequestURI);
		System.out.println("the get request url ---->"+getRequestURL);
		extentHtmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/GetUSersAPI_"+UtilityClass.getCurrentDataAndTime()+".html"));
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);
		
	}
	
	@Test
	public void getRequestTest() throws ClientProtocolException, IOException {
		logger = extentReports.createTest("getRequestTest");
		logger.info("About to execute get requst API");
		HashMap<String, String> getRequestHeaderMap = new HashMap<String, String>();
		getRequestHeaderMap.put("Content-Type", "application/json");
		httpClientClasses = new HttpClientClasses();
		closeableHttpResponse = httpClientClasses.getRequestCall(getRequestURL, getRequestHeaderMap);
		int getRequestStatusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("the status code is --- >"+getRequestStatusCode);
		
		String getRequestResponseInString = EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
		System.out.println("the response in string--->"+getRequestResponseInString);
		JSONObject getResponseJSONObject = new JSONObject(getRequestResponseInString);
		System.out.println("the per page details --->"+getResponseJSONObject.getInt("per_page"));
		
		
	}
	
	@AfterMethod
	public void afterGetRequestTest() {
		logger.info("get requst API executed");
		extentReports.flush();
	}
	
}
