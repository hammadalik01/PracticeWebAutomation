package rough;

import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sixth {

	public static void main(String[] args) throws InterruptedException {

		//Creating a driver object referencing WebDriver interface
        WebDriver driver = null;
        //WebDriverWait wait = new WebDriverWait(driver, 20);
        
        //Setting webdriver.gecko.driver property
        System.setProperty("webdriver.gecko.driver", "D:\\Pre_Condition\\Firefox\\geckodriver-v0.29.1-win64\\geckodriver.exe");
        
        //Instantiating driver object and launching browser
        driver = new FirefoxDriver();
        
        //Using get() method to open a webpage
        driver.get("https://opensource-demo.orangehrmlive.com/");
        

		// Login Functionality
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();

		// Hover on PIM
		WebElement PIM = driver.findElement(By.id("menu_pim_viewPimModule"));
		Actions act = new Actions(driver);
		act.moveToElement(PIM).build().perform();

		// move to configuration
		WebElement Configuration = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_pim_Configuration")));
		act.moveToElement(Configuration).build().perform();
		
		//Click on data import field
		WebElement OptionalField= new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_pim_viewReportingMethods")));
		OptionalField.click();
		
		//Random Name 
		
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		String generatedString = buffer.toString();
		
		//Random Name
		
		//Click on Add button
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("reportingMethod_name")).sendKeys(generatedString);
		driver.findElement(By.id("btnSave")).click();

		

		
	//WebElement MessageSucc = driver.findElement(By.className("message success"));
		
		
	 //WebElement MessageSucc = new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='message success fadable']"))); 
	 //String All_Message =  MessageSucc.getText(); 
	 //System.out.println(All_Message);
		 
		 
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
		 
		 
		 
		
		//WebElement Successfull_Message = driver.findElement(By.id("successBodyEdit"));
		
		
	
		
		//Fetch Element with locator for message 
		
		//List<WebElement> elements = driver.findElements(By.id("successBodyEdit"));
	    //System.out.println("Number of elements:" +elements.size());

	    //for (int i=0; i<elements.size();i++){
	     //System.out.println("All Element value:" + elements.get(i).getAttribute("value"));
	    //}
		
		
		
		
		
		//=========================================//
		
		
		/*
		 * List<WebElement> el = driver.findElements(By.xpath("//*")); int count=0; for
		 * ( WebElement e : el ) { System.out.println(
		 * e.getTagName()+"    "+e.getText());
		 * 
		 * count++;
		 * 
		 * } System.out.println(count );
		 */
		
		
		
		//=========================================//
		
				
		
		
		

	}

}
