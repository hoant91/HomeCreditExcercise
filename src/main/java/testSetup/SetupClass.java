package testSetup;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class SetupClass {
	public static WebDriver driver;
	public static Properties props;
	public static ExtentReports report;
	public static ExtentTest logger;

	public SetupClass() {
		try {
			props = new Properties();
			FileInputStream input = new FileInputStream(System.getProperty("user.dir") + "\\config.properties");
			props.load(input);
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static void initialization() {
		String workingDir = System.getProperty("user.dir");
		report = new ExtentReports(workingDir + "\\ExtentReports\\ExtentReportResults.html", true);
		String browserName = props.getProperty("browser");
		try {
			if(browserName.equals("chrome")){
				System.setProperty("webdriver.chrome.driver", workingDir+"\\browserDrivers\\chromedriver.exe");	
				driver = new ChromeDriver();
			}
			else if(browserName.equals("firefox")){	
				driver = new FirefoxDriver(); 
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.get(props.getProperty("url"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
