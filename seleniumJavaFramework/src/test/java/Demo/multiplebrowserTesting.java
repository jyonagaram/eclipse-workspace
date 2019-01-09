package Demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class multiplebrowserTesting {

	WebDriver driver;
	@Parameters("Mybrowser")
	@BeforeTest
	public void setup(@Optional("firefox")String BrowserName) {
		if(BrowserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chrome_driver\\chromedriver.exe");
			driver=new ChromeDriver();
		}else if(BrowserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\firefox_driver\\geckodriver-v0.23.0-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
		}

	}
	@Test
	public void openbrowser() {
		driver.get("http://demo.guru99.com/V1/index.php");
		System.out.println("thread value is:"+Thread.currentThread().getId());
	}

	@AfterTest
	public void teardown() {
		driver.close();

	}
}
