package SeleniumPractice.Basics;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot {
	
	 WebDriver driver;
	
	public static void takeshot(WebDriver driver) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File srcfile=ts.getScreenshotAs(OutputType.FILE);
		File destfile=new File("C:\\Users\\Ranjeeth\\eclipse-workspace\\Basics\\screenshots\\"+System.currentTimeMillis()+".png");
		try {
			FileUtils.copyFile(srcfile, destfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("the screenshot is taken");
			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
