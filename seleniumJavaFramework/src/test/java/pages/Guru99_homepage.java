package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Guru99_homepage {
	WebDriver driver=null;
	 

	By dropdown=By.xpath("//a[@class='dropdown-toggle']");
	By dropdownlist=By.xpath("//ul[@class='dropdown-menu']");
	By firstvalue=By.xpath("//ul[@class='dropdown-menu']/li[1]/a[text()='Flash Movie Demo']");
	By secondvalue=By.xpath("//ul[@class='dropdown-menu']/li[2]/a[text()='Radio & Checkbox Demo']");
	
public Guru99_homepage(WebDriver driver) {
		this.driver=driver;
	}
	
	
 public void dropdown_list() {
	     Actions act=new Actions(driver);
		 act.moveToElement(driver.findElement(dropdown)).click().build().perform();
		  WebElement element=driver.findElement(dropdownlist);
		  List<WebElement>values=element.findElements(By.tagName("li"));
		  for(int i=0;i<values.size();i++) {
			  System.out.println(values.get(i).getText());
		  }
      }
    
 public void Click_on_Fm() {
	   Actions act=new Actions(driver);
	   act.moveToElement(driver.findElement(firstvalue)).click().build().perform();
   }
 
public void CLick_on_rc() {
	Actions act=new Actions(driver);
	act.moveToElement(driver.findElement(secondvalue)).click().build().perform();
}
		

	}

