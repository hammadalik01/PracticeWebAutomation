package testcases;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;

public class Login extends TestBase{
	
	//public SoftAssert soft= new SoftAssert();
	
	@Test (priority=1)
	public void InvalidLogin() {
		log.info("Invalid Credentail");
		driver.findElement(By.id(OR.getProperty("username_id"))).sendKeys("admin123");
		driver.findElement(By.id(OR.getProperty("userpassword_id"))).sendKeys("admin0");
		driver.findElement(By.id(OR.getProperty("loginbutton_id"))).click();
		String ActualErrormessage = driver.findElement(By.xpath(OR.getProperty("spanmessage_xpath"))).getText();
		String ExpectedErrorMessage = "Invalid credentials";
		soft.assertEquals(ActualErrormessage, ExpectedErrorMessage , "Invalid Credential Message not Equal");
		log.info("Invalid credential Message show");
	}
	
	
	
	@Test (priority=2)
	public void EmptyLogin(){
		log.info("Both Field Empty");
		driver.findElement(By.id(OR.getProperty("username_id"))).sendKeys("");
		driver.findElement(By.id(OR.getProperty("userpassword_id"))).sendKeys("");
		driver.findElement(By.id(OR.getProperty("loginbutton_id"))).click();
		String Actual_Empty_Mesage = driver.findElement(By.id(OR.getProperty("spanmessage_id"))).getText();
		String Expected_Message = "Username cannot be empty";
		soft.assertEquals(Actual_Empty_Mesage, Expected_Message ,"Empty field Credential Message not Equal");
		log.info("Both Field Empty");
	}
	
	
	@Test (priority=3)
	public void loginSuccessfully() {
		log.info("insite login");
		driver.findElement(By.id(OR.getProperty("username_id"))).sendKeys("Admin");
		driver.findElement(By.id(OR.getProperty("userpassword_id"))).sendKeys("admin123");
		driver.findElement(By.id(OR.getProperty("loginbutton_id"))).click();
		log.info("Login successfully");
		String ActualTitle = driver.getTitle();
		String EXpectedTitle = "OrangeHRM";
		soft.assertEquals(ActualTitle, EXpectedTitle);
		soft.assertTrue(isElementPresent(By.xpath(OR.getProperty("logoutimage_xpath")), "Login Not Successful"));
	}
	
	

}
