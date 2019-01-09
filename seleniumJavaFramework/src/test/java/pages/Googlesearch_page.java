package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Googlesearch_page {
	WebDriver driver=null;

	By textToSearch= By.name("q");
	By searchbutton=By.name("btnK");
	
	//Enter text into search area
	public void settextfield(String text) {
		driver.findElement(textToSearch).sendKeys(text);
	}
	//click on the search button
	public void submit() {
		WebElement submit=explicitwait();
		submit.click();
	}
	
	public  Googlesearch_page(WebDriver driver) {
		this.driver=driver;
	}
	//Enter the baseurl
	public void url(String Text) {
		driver.get(Text);
		driver.manage().window().maximize();
	}
	//Wait until the search button element is visible
	public WebElement explicitwait() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(searchbutton));
		return element;
	}
}
