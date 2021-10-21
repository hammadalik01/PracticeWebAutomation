package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base.TestBase;

public class ReportingMethod extends TestBase {
	
	
    @Test (priority=23)
	public void ValidateUserLandOnAReportingMethods() {
		// Hover on PIM
		WebElement PIM = driver.findElement(By.id("menu_pim_viewPimModule"));
		Actions act = new Actions(driver);
		act.moveToElement(PIM).build().perform();

		// move to configuration
		WebElement Configuration = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_pim_Configuration")));
		act.moveToElement(Configuration).build().perform();

		// Click on data import field
		WebElement OptionalField = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_pim_viewReportingMethods")));
		OptionalField.click();
		
		log.info("User Land on Reporting Methods");
	}
	
    @Test (priority=24)
	public void VerifyAddReportingMethod() {
		// Click on Add button
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("reportingMethod_name")).sendKeys("Direction");
		driver.findElement(By.id("btnSave")).click();	

		
		WebElement MessageSucc = new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='message success fadable']"))); 
		String ExpectedSuccessFull_message ="Successfully Saved";
		String ActualSuccessFull_message =  MessageSucc.getText();
		Assert.assertEquals(ActualSuccessFull_message, ExpectedSuccessFull_message ,"Reporting Not Added in Reporting Method");	
		
		log.info("Add Reporting successfully added with message return" + ActualSuccessFull_message);

	}
	
    
    @Test (priority=25)
	public void VerifyReportingMethodDeleteSuccessfully() {
		driver.findElement(By.xpath("//a[text()='Direction']//parent::td[@class='tdName tdValue']//preceding-sibling::td[@class='check']//input[@type='checkbox']")).click();
		driver.findElement(By.id("btnDel")).click();
		
		WebElement MessageSucc = new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='message success fadable']"))); 
		String ExpectedSuccessFull_message ="Successfully Deleted";
		String ActualSuccessFull_message =  MessageSucc.getText();
		Assert.assertEquals(ActualSuccessFull_message, ExpectedSuccessFull_message ,"Reporting Not Added in Reporting Method");
		
		log.info("Delete Reporting successfully with message Return" + " " + ActualSuccessFull_message);

		
	}
	

}
