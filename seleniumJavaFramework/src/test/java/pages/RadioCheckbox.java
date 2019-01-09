package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RadioCheckbox {
	
    static WebDriver driver=null;
	static By radio=By.xpath("//input[@type='radio']");
	static By radiobutton1=By.xpath("//input[@value='Option 1']");
	static By radiobutton2=By.xpath("//input[@value='Option 2']");
	By radiobuton3=By.xpath("//input[@value='Option 3']");
	static By checkbox1=By.xpath("//input[@value='checkbox1']");
	static By checkbox2=By.xpath("//input[@value='checkbox2']");
	static By checkbox3=By.xpath("//input[@value='checkbox3']");
	
	public RadioCheckbox (WebDriver driver) {
		this.driver=driver;
		
	}
	 
	public  static void radiooptions() {
		List<WebElement>number=driver.findElements(radio);
		System.out.println(number.size());	
	}
	
	public static boolean clcikonfisrtbutton() {
		driver.findElement(radiobutton1).click();
		boolean value;
		if(driver.findElement(radiobutton1).isSelected()) {
			 value=true;
		}
		else {
			value= false;
		}
		return value;
	}
	
	public static boolean clickonsecondbutton() {
		driver.findElement(radiobutton2).click();
		boolean value;
		if(driver.findElement(radiobutton2).isSelected()&&driver.findElement(radiobutton1).isSelected()) {
			value=false;
		}else {
			value=true;
		}return value;
	}
	
	public static boolean fisrtcheckbox() {
		driver.findElement(checkbox1).click();
		boolean value;
		if(driver.findElement(checkbox1).isSelected()) {
			 value=true;
		}
		else {
			value= false;
		}
		return value;
	}
	

	public static boolean Secondcheckbox() {
		driver.findElement(checkbox2).click();
		boolean value;
		if(driver.findElement(checkbox2).isSelected()&&driver.findElement(checkbox1).isSelected()) {
			 value=true;
		}
		else {
			value= false;
		}
		return value;
	}
	
	public static boolean thirdcheckbox() {
		driver.findElement(checkbox3).click();
		boolean value;
		if(driver.findElement(checkbox3).isSelected()&&driver.findElement(checkbox2).isSelected()&&driver.findElement(checkbox1).isSelected()) {
			 value=true;
		}
		else {
			value= false;
		}
		return value;
	}
	
	
	
	
}
