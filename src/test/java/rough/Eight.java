package rough;

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

public class Eight {

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


		// Click on Add Employment
		WebElement OptionalField = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_pim_viewEmployeeList")));
		OptionalField.click();
		
		driver.findElement(By.xpath("//input[@id='empsearch_id']")).sendKeys("0016");
		driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
		
		WebElement CheckBox = driver.findElement(By.xpath("//input[@id='ohrmList_chkSelectAll']"));
		CheckBox.click();		
		driver.findElement(By.xpath("//input[@id='btnDelete']")).click();
		driver.findElement(By.xpath("//input[@id='dialogDeleteBtn']")).click();
		
		
		//for (int i = 0; i < 10; i++) 
		//{ 
		//JavascriptExecutor j = (JavascriptExecutor)
	   // driver; String s = (String)
		//j.executeScript("return document.body.innerHTML;"); 
		//if	
		//(StringUtils.countMatches(s, "Successfully Deleted") > 1)
		//System.out.println("Get HTML of page: "+ s); 
		//Thread.sleep(500); 
		//}
		
		WebElement MessageSucc = new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='message success fadable']"))); 
		String All_Message =  MessageSucc.getText(); 
		System.out.println(All_Message);

		
		 String dir = System.getProperty("user.dir");
		 System.out.println(dir);
		
		//String ActualEmployeeHeading = driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content']/div[1]/div[1]")).getText();
		//System.out.println(ActualEmployeeHeading);
		
		//Add Employee
		
		//driver.findElement(By.id("firstName")).sendKeys("Hammad");
		//driver.findElement(By.id("lastName")).sendKeys("Ali");
		//WebElement EmpID= driver.findElement(By.id("employeeId"));
		//EmpID.clear();
		//EmpID.sendKeys("1");
		
		//driver.findElement(By.id("btnSave")).click();		
		
		//driver.findElement(By.id("menu_pim_addEmployee")).click();
		
		

	}

}
