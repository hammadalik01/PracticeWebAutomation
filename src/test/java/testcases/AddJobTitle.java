package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;

public class AddJobTitle extends TestBase {

	@Test(priority = 9)
	public void VerifyUserOnAddJobTitlePage() {
		
		log.info("User Hover on Admin");
		// Hover on Admin menu
		WebElement Admin;
		Admin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(OR.getProperty("adminMenu_id"))));
		Actions act = new Actions(driver);
		act.moveToElement(Admin).build().perform();

		// Click on job
		log.info("User click on job");
		WebElement job;
		job = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(OR.getProperty("job_id"))));
		job.click();

		// Click on User Menu
		log.info("User click on jobTitles");
		// WebElement JobTitles;
		// JobTitles=new
		// WebDriverWait(driver,20).until(ExpectedConditions.visibilityOfElementLocated(By.id(OR.getProperty("jobTitle_id"))));
		// JobTitles.click();

		WebElement JobTitles;
		JobTitles = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(OR.getProperty("jobTitleMenu_id"))));
		JobTitles.click();
		log.info("User successfully land on AddJobTitles Page");
		
	}

	@Test(priority = 10, dataProvider = "getData")
	public void Add_JobTittle(String JobTitle, String JobDescription, String Note, String FilePath) {

		// Click On Add button
		// WebElement AddBtn;
		// AddBtn=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(OR.getProperty("btnAdd"))));
		// AddBtn.click();

		driver.findElement(By.id("btnAdd")).click();
		
		// Fill all Field
		driver.findElement(By.id(OR.getProperty("jobTitle_id"))).sendKeys(JobTitle);
		driver.findElement(By.id(OR.getProperty("jobDescription_id"))).sendKeys(JobDescription);
		driver.findElement(By.id(OR.getProperty("jobNote_id"))).sendKeys(Note);
		

		// Upload File
		WebElement button = driver.findElement(By.id((OR.getProperty("jobSpecification_id"))));
		button.sendKeys(FilePath);
		

		// Save Button
		driver.findElement(By.id(OR.getProperty("btnSave_id"))).click();
		
		
		
		WebElement MessageSucc = new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='message success fadable']"))); 
		String ExpectedSuccessFull_message ="Successfully Saved";
		String ActualSuccessFull_message =  MessageSucc.getText();
		Assert.assertEquals(ActualSuccessFull_message, ExpectedSuccessFull_message ,"Job added Successfully in the record");	
		log.info("Job Add successfully and message show" + " " + ActualSuccessFull_message);

	}

	@DataProvider
	public Object[][] getData() {

		String sheetName = "Add_JobTittle";

		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][cols];

		for (int rowNum = 2; rowNum <= rows; rowNum++) {

			for (int colNum = 0; colNum < cols; colNum++) {

				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum); // -2

			}
		}

		return data;

	}

	@Test(priority = 11)
	public void DeleteAllRecord() {

		driver.findElement(By.xpath(
				"//a[text()='Co Founder']//parent::td[@class='left']//preceding-sibling::td[1]//input[@name='chkSelectRow[]']"))
				.click();
		driver.findElement(By.xpath(
				"//a[text()='Coordinator']//parent::td[@class='left']//preceding-sibling::td[1]//input[@name='chkSelectRow[]']"))
				.click();
		driver.findElement(By.xpath(
				"//a[text()='Founder']//parent::td[@class='left']//preceding-sibling::td[1]//input[@name='chkSelectRow[]']"))
				.click();

		driver.findElement(By.id(OR.getProperty("btnDelete_id"))).click();
		driver.findElement(By.id(OR.getProperty("okdelete_id"))).click();
		
		WebElement MessageSucc = new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='message success fadable']"))); 
		String ExpectedSuccessFull_message ="Successfully Deleted";
		String ActualSuccessFull_message =  MessageSucc.getText();
		Assert.assertEquals(ActualSuccessFull_message, ExpectedSuccessFull_message ,"Job added Successfully in the record");
		
		
		log.info("Job Deleted successfully and message show" + " " + ActualSuccessFull_message);

	}

}
