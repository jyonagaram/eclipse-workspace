package seleniumJavaFramework;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class Screenshot {
	
	WebDriver driver=null;
	
	public  static String Takescreenshot(WebDriver driver) throws IOException {
	
	File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    String path=System.getProperty("user.dir")+"//Screenshots//"+System.currentTimeMillis()+".jpg";
	File destinationFile=new File(path);
	FileUtils.copyFile(screenshotFile, destinationFile);
	return path;
	
	}
	
	
	

}
