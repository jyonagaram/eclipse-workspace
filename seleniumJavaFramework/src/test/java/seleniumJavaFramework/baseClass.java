package seleniumJavaFramework;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class baseClass {
	public static WebDriver driver;
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static Properties prop=new Properties();
    static String filepath=System.getProperty("user.dir")+"\\src\\test\\java\\seleniumJavaFramework\\data.properties";


	@BeforeSuite
	public void ExtentReport() {
		reporter=new ExtentHtmlReporter("extentreports.html");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		System.out.println("the new report is created");
		try {
			
			FileInputStream input=new FileInputStream(filepath);
			prop.load(input);
			
			}
			catch(Exception ex) {
				System.out.println(ex.getMessage());
				System.out.println(ex.getCause());
				ex.printStackTrace();
			}

	}
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void OpenUrl() {
        if(prop.getProperty("browsername").equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chrome_driver\\chromedriver.exe");
		driver=new ChromeDriver();
	    }
        else if (prop.getProperty("browsername").equalsIgnoreCase("firefox")) {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\firefox_driver\\geckodriver-v0.23.0-win64\\geckodriver.exe");
        driver=new FirefoxDriver();
        }
        else if(prop.getProperty("browsername").equalsIgnoreCase("internetexplorer")) {
        	
        System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\drivers\\ie_driver\\IEDriverServer.exe");
        driver=new InternetExplorerDriver();
        
        }

	}
	@BeforeMethod
	public void setup(Method method) {
		String testMethodName = method.getName(); //This will be:verifySaveButtonEnabled
		System.out.println(testMethodName);
		String descriptiveTestName = method.getAnnotation(Test.class).testName(); //This will be: 'Verify if the save button is enabled'
		System.out.println(descriptiveTestName);
		test = extent.createTest(descriptiveTestName);
	}
	@AfterMethod
	public void teardown(ITestResult result) throws IOException {

		if(result.getStatus()==ITestResult.SUCCESS) {
			String temp= Screenshot.Takescreenshot(driver);
			test.pass("the test case is passed",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		else {
			String temp= Screenshot.Takescreenshot(driver);
			//test.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
			test.fail(MarkupHelper.createLabel(result.getName()+"Test case is failed", ExtentColor.RED));

		}

	}

	@AfterSuite
	public void FinalStep() {
		extent.flush();

	}


}
