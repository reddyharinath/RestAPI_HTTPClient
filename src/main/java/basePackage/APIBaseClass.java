package basePackage;

import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class APIBaseClass {
	
	public Properties prop;
	public ExtentReports extentReports;
	public ExtentTest logger;
	 

	public APIBaseClass() {
		prop = new Properties();
		try {
			
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/testConfigPackage/config.properties");
			prop.load(fis);
			
		} catch (Exception e) {
			System.out.println("un-able to load properties file-->"+ e.getMessage());
		}
	}
}
