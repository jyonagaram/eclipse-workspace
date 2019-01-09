package seleniumJavaFramework;

import org.testng.annotations.Test;

import pages.RadioCheckbox;

public class Testng2 extends baseClass {

 
  @Test(testName="Validate the checkbox button is able to select")
  public void TestCase5() {
	  RadioCheckbox rc=new RadioCheckbox(driver);
	  boolean value=rc.fisrtcheckbox();
	  if(value==true) {
		  test.pass("the test case is passed");
		  
	  }else {
		  test.fail("the test is executed with an error");  
	  }
	  
  }
  
  @Test(testName="Validate the multuple checkbox are Selected")
  public void TestCase6() {
	  RadioCheckbox rc=new RadioCheckbox(driver);
	  boolean value=rc.Secondcheckbox();
	  if(value==true) {
		  test.pass("the test case is passed");
		  
	  }else {
		  test.fail("the test is executed with an error");  
	  }
	  
  } 
  

@Test(testName="Validate allCheckboxe able to select")
public void TestCase7() {
	RadioCheckbox rc=new RadioCheckbox(driver);
	  boolean value=rc.thirdcheckbox();
	  if(value==true) {
		  test.pass("the test case is passed");
		  
	  }else {
		  test.fail("the test is executed with an error"); 
	  }
	  
} 
}
