package rough;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Nine {

	public static void main(String[] args) throws InterruptedException {
		
		// Creating a driver object referencing WebDriver interface
				WebDriver driver;
				// WebDriverWait wait = new WebDriverWait(driver, 20);

				// Setting webdriver.gecko.driver property
				System.setProperty("webdriver.gecko.driver","D:\\Pre_Condition\\geckodriver-v0.29.0-win64\\geckodriver.exe");

				// Instantiating driver object and launching browser
				driver = new FirefoxDriver();

				// Using get() method to open a webpage
				driver.get("https://opensource-demo.orangehrmlive.com/");

				// Login Functionality
				driver.findElement(By.id("txtUsername")).sendKeys("admin");
				driver.findElement(By.id("txtPassword")).sendKeys("admin123");
				driver.findElement(By.id("btnLogin")).click();

				// Hover on PIM
				WebElement PIM = driver.findElement(By.id("menu_pim_viewPimModule"));
				Actions act = new Actions(driver);
				act.moveToElement(PIM).build().perform();
				
				// Click on Employment List Menu 
				WebElement OptionalField = new WebDriverWait(driver, 10)
						.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_pim_viewEmployeeList")));
				OptionalField.click();
				

				
				//Delete an Employee
				driver.findElement(By.id("empsearch_id")).sendKeys("0024");
				driver.findElement(By.id("searchBtn")).click();
				driver.findElement(By.id("ohrmList_chkSelectAll")).click();
				driver.findElement(By.id("btnDelete")).click();
				driver.findElement(By.id("dialogDeleteBtn")).click();
				driver.findElement(By.id("resetBtn")).click();
				
				//Verify Record Not Exist
				/*
				 * driver.findElement(By.id("empsearch_id")).sendKeys("0007");
				 * driver.findElement(By.id("searchBtn")).click(); WebElement RecordNot =
				 * driver.findElement(By.xpath("//td[contains(text(),'No Records Found')]"));
				 * String ActualMessage = RecordNot.getText(); String ExpectedMessage
				 * ="No Records Found";
				 */
				
				for (int i = 0; i < 10; i++)
				{ 
				JavascriptExecutor j = (JavascriptExecutor)
			    driver; String s = (String)
				j.executeScript("return document.body.innerHTML;"); 
				if	
				(StringUtils.countMatches(s, "Successfully Deleted") > 1)
				System.out.println("Get HTML of page: "+ s); 
				Thread.sleep(500);
				}
					
					 
				//WebElement MessageSucc = new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='message success fadable']"))); 
				
				//String ExpectedSuccessFull_message ="Successfully Saved";
				//String ActualSuccessFull_message =  MessageSucc.getText();
				//System.out.println(MessageSucc.getText());
				//Assert.assertEquals(ActualSuccessFull_message, ExpectedSuccessFull_message ,"User Not Added in Admin section");

				
	
				




	}

}
