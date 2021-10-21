package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;

public class Buzz extends TestBase {
	
	@Test (priority=43)
	
	public void VerifyUserAddPostSuccessfully() throws InterruptedException{
		log.info("User Click on Buzz menu");		
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("buzzMenu_xpath"))).click();
		//Post some Status
		driver.findElement(By.xpath(OR.getProperty("creatPostContent_xpath"))).click();
		driver.findElement(By.xpath(OR.getProperty("creatPostContent_xpath"))).clear();
		driver.findElement(By.xpath(OR.getProperty("creatPostContent_xpath"))).sendKeys("Example");
		driver.findElement(By.id(OR.getProperty("postButton_id"))).click();
    }
	
	
	@Test (priority=44)
	public void VerifyImagePostSuccessfully() {		
		
	driver.findElement(By.id(OR.getProperty("uploadImage_id"))).click();
	WebElement UploadPostImage = driver.findElement(By.id(OR.getProperty("photofileUpload_id")));
	UploadPostImage.sendKeys("E:\\3.jpg");
	driver.findElement(By.id(OR.getProperty("phototext_id"))).sendKeys("Text for upload Image through post");
	driver.findElement(By.id(OR.getProperty("imageUploadButton_id"))).click();	
	}
	
		
	@Test (priority=45)
	public void VerifyPostDeletedSuccessfully() {
		driver.findElement(By.id(OR.getProperty("postOptionWidget_id"))).click();
		driver.findElement(By.linkText(OR.getProperty("delete_link"))).click();
		driver.findElement(By.id(OR.getProperty("delete_confirm_id"))).click();
		WebElement Delete_message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(OR.getProperty("successBodyDelete_id"))));
		String ActualSuccessDelete_message = Delete_message.getText();
		String ExpectedSuccessDelete_message ="Successfully Deleted";
		Assert.assertEquals(ActualSuccessDelete_message, ExpectedSuccessDelete_message ,"Post Delete Successfully");
	}
	
	
	
	
	
	
	
	
	
	
	

}
