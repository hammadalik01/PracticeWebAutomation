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

public class DeleteEmployee extends TestBase {
	
	@Test (priority=28)
	public void DeleteEmployeeSelectedRecord() {
		
		log.info("User Hover on PIM");
		
		WebElement PIM = driver.findElement(By.id("menu_pim_viewPimModule"));
		Actions act = new Actions(driver);
		act.moveToElement(PIM).build().perform();
		
		log.info("Click on Employee List");
		WebElement EmployeeListMenu = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id(OR.getProperty("employeeListMenu_id"))));
		EmployeeListMenu.click();
		
		
		//Delete an Employee recod 0.2		
		driver.findElement(By.id(OR.getProperty("employeesearchID_id"))).sendKeys("2.0");
		driver.findElement(By.id(OR.getProperty("serachButton_id"))).click();
		driver.findElement(By.id(OR.getProperty("checkboxSelectAll_id"))).click();
		driver.findElement(By.id(OR.getProperty("buttonDelete_id"))).click();
		driver.findElement(By.id(OR.getProperty("dialogDeletebtn_id"))).click();
		driver.findElement(By.id(OR.getProperty("resetBtn_id"))).click();
		
		
		//Delete an Employee recod 0.3		
		driver.findElement(By.id(OR.getProperty("employeesearchID_id"))).sendKeys("3.0");
		driver.findElement(By.id(OR.getProperty("serachButton_id"))).click();
		driver.findElement(By.id(OR.getProperty("checkboxSelectAll_id"))).click();
		driver.findElement(By.id(OR.getProperty("buttonDelete_id"))).click();
		driver.findElement(By.id(OR.getProperty("dialogDeletebtn_id"))).click();
		driver.findElement(By.id(OR.getProperty("resetBtn_id"))).click();
		
		//Delete an Employee recod 0.4
		driver.findElement(By.id(OR.getProperty("employeesearchID_id"))).sendKeys("4.0");
		driver.findElement(By.id(OR.getProperty("serachButton_id"))).click();
		driver.findElement(By.id(OR.getProperty("checkboxSelectAll_id"))).click();
		driver.findElement(By.id(OR.getProperty("buttonDelete_id"))).click();
		driver.findElement(By.id(OR.getProperty("dialogDeletebtn_id"))).click();
		driver.findElement(By.id(OR.getProperty("resetBtn_id"))).click();
		
		//Delete an Employee recod 0.5
		driver.findElement(By.id(OR.getProperty("employeesearchID_id"))).sendKeys("5.0");
		driver.findElement(By.id(OR.getProperty("serachButton_id"))).click();
		driver.findElement(By.id(OR.getProperty("checkboxSelectAll_id"))).click();
		driver.findElement(By.id(OR.getProperty("buttonDelete_id"))).click();
		driver.findElement(By.id(OR.getProperty("dialogDeletebtn_id"))).click();
		//driver.findElement(By.id(OR.getProperty("resetBtn_id"))).click();
		
		WebElement MessageSucc = new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='message success fadable']"))); 		
		String ExpectedSuccessFull_message ="Successfully Deleted";
		String ActualSuccessFull_message =  MessageSucc.getText();
		Assert.assertEquals(ActualSuccessFull_message, ExpectedSuccessFull_message ,"Employee Not Deleted in Employee section");
		log.info("Employee Record Deleted Successfully"+ "" + ActualSuccessFull_message);

		
	}
	
	@Test (priority=29)
	public void VerifyDeletedRecordNotFoundInList() {	
		
		driver.findElement(By.id(OR.getProperty("employeesearchID_id"))).sendKeys("2.0");
		driver.findElement(By.id(OR.getProperty("serachButton_id"))).click();
		WebElement RecordNot = driver.findElement(By.xpath(OR.getProperty("recordnnotFound_xpath")));
		String ActualMessage = RecordNot.getText();
		String ExpectedMessage ="No Records Found";
		soft.assertEquals(ActualMessage, ExpectedMessage , "Deleted Records found in the Employee list");			
		log.info("Delete Record Not found Successfully");
		
	}
	
	


}
