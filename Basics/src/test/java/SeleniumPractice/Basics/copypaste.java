package SeleniumPractice.Basics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class copypaste {
	WebDriver driver;
    Actions act;
	 public void StartTest() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ranjeeth\\Desktop\\software\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		}
	
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
	 
	  public void Login() {
		 //enter the username 
		 driver.findElement(By.name("uid")).sendKeys("mngr160478");
		 //enter the password
		 driver.findElement(By.name("password")).sendKeys("YzArEbu");
		 //clcik the login button
		 driver.findElement(By.name("btnLogin")).click();
		 //verify the title of the webpage
		 String title=driver.getTitle();
		 Assert.assertEquals(title, "GTPL Bank Manager HomePage");
		 
	  }
	 
	  public void MenuList() throws InterruptedException {
		  //list of menu items
		 List<WebElement>list_items=driver.findElements(By.xpath("//div/ul[@class=\"menusubnav\"]/li")); 
		     for(WebElement value:list_items) {
			 String menu_item=value.getText();
			 if(menu_item.equalsIgnoreCase("Customised Statement")){
			 driver.findElement(By.xpath("//div/ul[@class=\"menusubnav\"]/li/a[text()=\'"+menu_item+"\']")).click() ;
			 System.out.println("the "+menu_item +" is clicked"); 
			 break;
			 }
             }
	 }
	
	 public void accountno() {
       driver.findElement(By.xpath("//input[@name=\"accountno\"]")).sendKeys("abc"); 
       String error=driver.findElement(By.xpath("//label[@id='message2']")).getText();
       System.out.println(error);
		 
	 }
	 public void Insurance() {
			driver.findElement(By.xpath("//*[text()=\"Insurance Project\"]")).click();
			System.out.println("the insurance project has begun");
			act=new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath("//*[text()='Register']"))).click().build().perform();
			Assert.assertEquals(driver.getTitle(), "Insurance Broker System - Register");
			}
			
	public void  surtitle() throws IOException {
		Select dropdown=new Select(driver.findElement(By.id("user_title")));
		
		List<WebElement> dd =dropdown.getOptions();
		System.out.println(dd.size());
		for(int j=0;j<dd.size();j++) {
			System.out.println(dd.get(j).getText());
			Excel.writeexcel(j, 0, dd.get(j).getText());
			
		}
	
	
	
			}
	@Test
	public void m() throws Exception {
		// TODO Auto-generated method stub
		copypaste cp=new copypaste();
		cp.StartTest();
		cp.Url();
		cp.Login();
		cp.MenuList();
		cp.accountno();

	}

}
