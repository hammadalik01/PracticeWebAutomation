package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base.TestBase;

public class CustomField extends TestBase {

	@Test(priority=15)
	public void validateUserlandOnAccurateSection() {
		// Hover on PIM
		WebElement PIM = driver.findElement(By.id(OR.getProperty("pim_id")));
		Actions act = new Actions(driver);
		act.moveToElement(PIM).build().perform();
		WebElement Configuration = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id(OR.getProperty("configuration_id"))));
		act.moveToElement(Configuration).build().perform();
		WebElement OptionalField = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id(OR.getProperty("CustomFields_id"))));
		OptionalField.click();
		WebElement ButtonAdd = driver.findElement(By.id(OR.getProperty("buttonAdd_id")));
		ButtonAdd.click();
		driver.findElement(By.id(OR.getProperty("btnSave_id"))).click();
		String ActualValidation= driver.findElement(By.xpath(OR.getProperty("required_xpath"))).getText();
		String ExpectedValidation= "Required";
		Assert.assertEquals(ActualValidation, ExpectedValidation);
		log.info("User land on Custom Field");
		
	}
	
	@Test(priority=16)
	public void VerifyAddCustomFieldSuccessfully() {
		log.info("User add a custom field");
		log.info("User add first custom field");
		driver.findElement(By.xpath(OR.getProperty("fieldname_xpath"))).sendKeys("First Custom Field");
		//Select the screen
		log.info("User select screen");
		Select screen = new Select(driver.findElement(By.xpath(OR.getProperty("screen_xpath"))));
		screen.selectByVisibleText("Contact Details");
		//Select the type
		log.info("User select type");
		Select type = new Select(driver.findElement(By.id(OR.getProperty("type_id"))));
		type.selectByVisibleText("Text or Number");
		log.info("User Click on button Save");
		driver.findElement(By.id(OR.getProperty("btnSave_id"))).click();
		
		
		
		WebElement MessageSucc = new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='message success fadable']"))); 
		String ExpectedSuccessFull_message ="Successfully Saved";
		String ActualSuccessFull_message =  MessageSucc.getText();
		Assert.assertEquals(ActualSuccessFull_message, ExpectedSuccessFull_message ,"User Not Added in Admin section");	
		
		log.info("Custom Field successfully added with return message" + ActualSuccessFull_message);
		
	}
	
	@Test(priority=17)
	public void VerifyEditCustomFieldsuccessfully() {
		log.info("Edit user costom field");
		driver.findElement(By.xpath("//a[text()='First Custom Field']")).click();
		driver.findElement(By.xpath(OR.getProperty("fieldname_xpath"))).sendKeys("Edit");
		
		log.info("User select screen");
		Select screen = new Select(driver.findElement(By.xpath(OR.getProperty("screen_xpath"))));
		screen.selectByVisibleText("Dependents");
		
		
		log.info("User select type");
		Select type = new Select(driver.findElement(By.id(OR.getProperty("type_id"))));
		type.selectByVisibleText("Drop Down");
		
		
		driver.findElement(By.xpath(OR.getProperty("selectOption_xpath"))).sendKeys("OK , Set , Done");
	
		log.info("User Click on button Save");
		driver.findElement(By.id(OR.getProperty("btnSave_id"))).click();
	
		
		WebElement MessageSucc = new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='message success fadable']"))); 
		String ExpectedSuccessFull_message ="Successfully Saved";
		String ActualSuccessFull_message =  MessageSucc.getText();
		Assert.assertEquals(ActualSuccessFull_message, ExpectedSuccessFull_message ,"User Not Added in Admin section");	
		
		
		log.info("User costom field successfully edit and return message" +" "+ ActualSuccessFull_message );
	
	}
	
	@Test(priority=18)
	public void DeleteCustomFieldSuccessfully() {
	log.info("Action for Deleted Custom Field");
	log.info("Select check box for delete custom field");
	WebElement checkbox_delete = new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='First Custom FieldEdit']//parent::td[@class='fieldName']//preceding-sibling::td[@class='check']//input[@type='checkbox']")));
	checkbox_delete.click();
	
	log.info("User click on button Delete");
	driver.findElement(By.id(OR.getProperty("deleteCustomField_id"))).click();
	log.info("Popup appear");
		
	//Click n Cancel Button
	log.info("Click on cancel button for disappear popup");
	driver.findElement(By.xpath(OR.getProperty("cancelBtn_xpath"))).click();
	
	//Click on Ok Button
	log.info("Click on Delete button for appear popup");
	driver.findElement(By.id(OR.getProperty("deleteCustomField_id"))).click();
	log.info("Click on Ok button");
	driver.findElement(By.id(OR.getProperty("okdelete_id"))).click();
	
	WebElement MessageSucc = new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='message success fadable']"))); 
	String ExpectedSuccessFull_message = "Successfully Deleted";
	String ActualSuccessFull_message =  MessageSucc.getText();
	Assert.assertEquals(ActualSuccessFull_message, ExpectedSuccessFull_message ,"User Not Added in Admin section");	
	log.info("User costom field successfully edit and return message" +" "+ ActualSuccessFull_message );
	


	}

}
