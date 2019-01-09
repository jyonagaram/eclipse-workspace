package SeleniumPractice.Basics;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Practiceone {
//initiate the webdriver interface	
WebDriver driver;
 @BeforeClass
 public void StartTest() {
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ranjeeth\\Desktop\\software\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	
	}
 
 @BeforeTest
 public void report() {
 
 }
			
  @Test()
  public void Url()  {
	  driver.navigate().to("http://demo.guru99.com/v1/");
	  String title=driver.getTitle();
	if(title.equalsIgnoreCase("GTPL Bank Home Page")) {
			System.out.println("the title of the web page is verified");
        }
	else {
		System.out.println("the webpage is not opened");
	}
  }
  
  @Test(dependsOnMethods="Url")
  public void Login() {
	 //enter the username 
	 driver.findElement(By.name("uid")).sendKeys("mngr153815");
	 //enter the password
	 driver.findElement(By.name("password")).sendKeys("UgAjagY");
	 //clcik the login button
	 driver.findElement(By.name("btnLogin")).click();
	 //verify the title of the webpage
	 String title=driver.getTitle();
	 Assert.assertEquals(title, "GTPL Bank Manager HomePage");
	 
  }
  
  @Test(dependsOnMethods="Login")
  public void MenuList() throws InterruptedException {
	  //list of menu items
	  Practiceone p=new Practiceone();
	 List<WebElement>list_items=driver.findElements(By.xpath("//div/ul[@class=\"menusubnav\"]/li")); 
	     for(WebElement value:list_items) {
		 String menu_item=value.getText();
		 if(menu_item.equalsIgnoreCase("New Customer")){
		 driver.findElement(By.xpath("//div/ul[@class=\"menusubnav\"]/li/a[text()=\'"+menu_item+"\']")).click() ;
		 System.out.println("the "+menu_item +" is clicked"); 
		  Thread.sleep(5000);
		  //customer name
		  driver.findElement(By.name("name")).sendKeys("jyothi");
		  //list of radio buttons
		  List<WebElement>radio_buttons=driver.findElements(By.xpath("//input[@type='radio']"));
		     for(WebElement radio_value:radio_buttons) {
			   String value1=radio_value.getText();
			   if(value1.equalsIgnoreCase("male")) {
				//male radio button
				driver.findElement(By.xpath("//input[1][@type='radio']")).click();
				System.out.println("the male radio button is selected");
				break;
			    }
			    else {
				//female radio button
				driver.findElement(By.xpath("//input[2][@type='radio']")).click();
				System.out.println("the female radio button is clicked");
				break;
			     }
		       }
		     
		    //date picker
		     driver.findElement(By.name("dob")).sendKeys("22051992");
		     driver.findElement(By.name("sub")).click();
		     Thread.sleep(2000);
		     Alert alert=driver.switchTo().alert();
			 String text=alert.getText();
			 System.out.println("the alert text is:"+text);
			 alert.accept();
		    break;
	      
		   }
	     else {
	 System.out.println("the menu items are displayed");
       }
     }
  }
  
  
  
  @AfterMethod
  public void shots() throws UnhandledAlertException {
	
	  Screenshot.takeshot(driver);
 
		 
  }
  
 
  
  

  
  
  
  
} 
