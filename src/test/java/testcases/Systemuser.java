package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;

public class Systemuser extends TestBase {
	
	@Test (priority = 6)
	public void VerifyEditRecord() throws InterruptedException{
		//edit Records
		log.info("Go to Edit user");
		User user = new User();
		String EditRecord = user.AddUserAndCheckPasswordValidation();
		log.info("Go to the record whose user name is"+ EditRecord);
		
		WebElement EditRecordTable = driver.findElement(By.xpath("//a[text()='"+ EditRecord+"']"));
		EditRecordTable.click();
		//log.info("The xpath is"+EditRecordTable);
		
		driver.findElement(By.id(OR.getProperty("btnSave_id"))).click();
		driver.findElement(By.id(OR.getProperty("employeeName_id"))).clear();
		driver.findElement(By.id(OR.getProperty("employeeName_id"))).sendKeys("A");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();
		
		WebElement UserName = driver.findElement(By.xpath(OR.getProperty("username_xpath")));
		String DeleteRecords = UserName.getAttribute("value");
		UserName.sendKeys("Edit");
		
		Select status = new Select(driver.findElement(By.id("systemUser_status")));
		status.selectByVisibleText("Disabled"); 
		
		Thread.sleep(1000);
		
		//WebElement EditRecordBtn = driver.findElement(By.xpath(OR.getProperty("ForcebtnSave_bxpath")));
		WebElement EditRecordBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("btnSave_xpath"))));
		EditRecordBtn.sendKeys(Keys.ENTER);
		
		//act.doubleClick(EditRecordBtn).perform();
		
		
		WebElement MessageSucc = new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='message success fadable']"))); 
		String ExpectedSuccessFull_message ="Successfully Updated";
		String ActualSuccessFull_message =  MessageSucc.getText();
		Assert.assertEquals(ActualSuccessFull_message, ExpectedSuccessFull_message ,"User not Edit Successfully in Admin section");	
		
		log.info("User Edit successfully with message of"+ " " + ActualSuccessFull_message);
		
		//Search Record by UserName;
		WebElement SerachUserName = driver.findElement(By.id(OR.getProperty("searchUsername_id")));
		SerachUserName.sendKeys(DeleteRecords+"Edit");
		driver.findElement(By.id(OR.getProperty("searchBtn_id"))).click();

		
	}
	
	
	@Test(priority = 7)
	public void VerifyDeleteRecord() throws InterruptedException{				
		
		log.info("Select user for delete");
		
		WebElement checkbox_delete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(OR.getProperty("selectcheckboc_id"))));
		checkbox_delete.click();
		driver.findElement(By.id(OR.getProperty("btnDelete_id"))).click();
		log.info("Popup appear");
		
		//Click On Cancel Button
		//driver.findElement(By.xpath("cancelBtn_xpath")).click();
		 log.info("click on cancel button");
		 driver.findElement(By.xpath(OR.getProperty("cancelBtn_xpath"))).click();
		 log.info("Click on cancel for disappear popup");
		
		//Click on Ok Button
		driver.findElement(By.id(OR.getProperty("btnDelete_id"))).click();
		log.info("Click on OK for Delete User");
		driver.findElement(By.id(OR.getProperty("okdelete_id"))).click();
		
		WebElement MessageSucc = new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='message success fadable']"))); 
		String ExpectedSuccessFull_message ="Successfully Deleted";
		String ActualSuccessFull_message =  MessageSucc.getText();
		Assert.assertEquals(ActualSuccessFull_message, ExpectedSuccessFull_message ,"User not Deleted Successfully in Admin section");	
		
		log.info("User Deleted successfully with message of" + " " + ActualSuccessFull_message);
	}
	
}
