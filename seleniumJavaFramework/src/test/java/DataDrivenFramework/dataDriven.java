package DataDrivenFramework;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class dataDriven {
	
	static Integer rownum=1;
	String filepath="C:\\Users\\Ranjeeth\\eclipse-workspace\\seleniumJavaFramework\\Excel\\data.xlsx";
	
  @Test(dataProvider = "dp")
  public void Testdata1(String Username,String Password,String Number,String result) throws Exception {
	  
	  System.out.println(Username+"/"+Password+"/"+Number); 
	  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chrome_driver\\chromedriver.exe");
      WebDriver driver=new ChromeDriver();
      driver.get("https://www.google.com");
      if(driver.getTitle().equalsIgnoreCase("Google")) {
    	  ExcelUtils.writeData(rownum,3,"passed",filepath);
      }
      else {
    	  ExcelUtils.writeData(rownum,3,"failed",filepath); 
      }
	  
  }
  
  @AfterMethod
  public void teeradown() {
	  rownum++;
	  
  }

  @DataProvider
  public Object[][] dp() throws Exception {

	Object data[][]=	ExcelUtils.readExcel(filepath, "Sheet1");
		
  return data;
}
}
