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

public class DataImport extends TestBase {

	@Test (priority=19)
	public void ValidateUserLandOnCorrectPage() {
		// Hover on PIM
		WebElement PIM = driver.findElement(By.id(OR.getProperty("pim_id")));
		Actions act = new Actions(driver);
		act.moveToElement(PIM).build().perform();

		// move to configuration
		WebElement Configuration = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id(OR.getProperty("configuration_id"))));
		act.moveToElement(Configuration).build().perform();

		// Click on data import field
		WebElement OptionalField = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id(OR.getProperty("dataImport_id"))));
		OptionalField.click();

		// Verify user land on correct page
		WebElement headingofpage = driver.findElement(By.id(OR.getProperty("dataImportHeading_id")));
		headingofpage.getText();
		String Actualheadingofpage = headingofpage.getText();
		String Expectedheadingofpage = "CSV Data Import";
		Assert.assertEquals(Expectedheadingofpage, Actualheadingofpage);
		log.info("User Land On Data Import section");
	}
	
	@Test (priority=20)
	public void VerifyFileSuccessfullyDownloaded() {
		log.info("Click on Download text for Download file");
		WebElement DownloadLink =  driver.findElement(By.xpath(OR.getProperty("downloadFileLink_xpath")));
		DownloadLink.click();
		log.info("Verify File successfully downloaded");
	}
	

	@Test(priority=21)
	public void ValidateFileuploadSuccessfully() {
		log.info("File upload"); 
		WebElement choseFileButton = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='pimCsvImport_csvFile']")));
		choseFileButton.sendKeys("C:\\Users\\Hp\\Downloads\\importData.csv");
		log.info("Click On Upload button");
		driver.findElement(By.id("btnSave")).click();
		log.info("Verify File Uploaded successfully");
	}
	
	@Test (priority=22)
	public void ValidationErrorShowOnEmptyFile() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(By.id("btnSave")).click();
		String ActualErrorMessage = driver.findElement(By.xpath("//span[contains(text(),'Required')]")).getText();
		String ExpectedErrorMessage = "Required";
		Assert.assertEquals(ActualErrorMessage, ExpectedErrorMessage ,"Error message not show");
		log.info("Required Error Message show");
	}
	


}
