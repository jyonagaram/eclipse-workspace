package seleniumJavaFramework;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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

import pages.Guru99_homepage;
import pages.RadioCheckbox;

public class Testng extends baseClass {
	
	@Test(testName="Selenium is selected from the menubar items")
	public void Testcase1() {
		System.out.println(prop.getProperty("url"));
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		Guru99_homepage ghp=new Guru99_homepage(driver);
		ghp.dropdown_list();
		System.out.println("the Selenium dropdown is selected"); 
		test.info("the dropdown list is selected");

	}


	@Test(testName="Validate RadioCHeckBox Demo is Clicked")
	public void Testcase2() throws InterruptedException {
		Guru99_homepage ghp=new Guru99_homepage(driver);
		ghp.CLick_on_rc();
		test.info("rdaio&checkbox demo value is selected from the dropdown");
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(), "Radio Button & Check Box Demo");
		test.info("validated the title of the current page");
	}

	@Test(testName="Valiadte the first radio option is able to select")
	public void Testcase3() {
		RadioCheckbox rc=new RadioCheckbox(driver);
		rc.radiooptions();
		//to select the radio button
		boolean value=rc.clcikonfisrtbutton();
		if(value==true) {
			test.pass("the test case is passed");

		}else {
			test.fail("the test is executed with an error");
		}

	}


	@Test(testName="Validate only one radio option is selected")
	public void Testcase4() {
		RadioCheckbox rc=new RadioCheckbox(driver);
		boolean value=rc.clickonsecondbutton();
		if(value==true) {
			test.pass("the test case is passed");
		}else {
			test.fail("the test is executed with an error");
		}

	}



	//get the number of radio buttons present 

}
