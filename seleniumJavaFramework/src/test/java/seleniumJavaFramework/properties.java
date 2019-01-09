package seleniumJavaFramework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class properties {
    public static Properties prop=new Properties();
    static String filepath=System.getProperty("user.dir")+"\\src\\test\\java\\seleniumJavaFramework\\data.properties";
    
	public static void getproperties() {
		try {
		
		InputStream input=new FileInputStream(filepath);
		prop.load(input);
		
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getCause());
			ex.printStackTrace();
		}
	}
		
		public static  void setproperties() {
			try {
				OutputStream output=new FileOutputStream(filepath);
                prop.setProperty("result", "passed");
                prop.store(output, "Write the property file");
				
				}
				catch(Exception ex) {
					System.out.println(ex.getMessage());
					System.out.println(ex.getCause());
					ex.printStackTrace();
				}
		}
	
		
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chrome_driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		getproperties();
		driver.navigate().to(prop.getProperty("url"));
	}
}
