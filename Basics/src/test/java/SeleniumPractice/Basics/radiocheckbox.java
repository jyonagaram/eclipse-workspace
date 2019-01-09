package SeleniumPractice.Basics;



import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class radiocheckbox   {
	
	WebDriver driver;
	Actions act;


  @Test(dataProvider="test")
  public static void Test(Hashtable<Integer,Hashtable<String,String>> masterData) throws Exception {
	  int numofrows=masterData.size();
	  copypaste rc=new copypaste(); 
	  rc.StartTest();
	  rc.Url();
	  rc.Login();
	  rc.Insurance();
	  rc.surtitle();
	  
	  }
	  

 @DataProvider(name="test")
 Object[][] passdata() throws Exception{
	 return Excel.readexcel();
 }
 }
