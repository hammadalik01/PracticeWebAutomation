package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base.TestBase;

public class Logout extends TestBase{
	
	@Test (priority=46)
	public void logout() throws InterruptedException {
		Thread.sleep(2000);
		WebElement welcome_Option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("welcome")));
		welcome_Option.click();
	    //driver.findElement(By.id("welcome")).click();
	    driver.findElement(By.linkText("Logout")).click();
		log.info("User Logout from application");
	}
	
	

}
