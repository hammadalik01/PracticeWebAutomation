package rough;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class Main_testing {
	
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
        
        
        //Login Functionality 
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		
			
		//Hover on Admin menu
		WebElement Admin = driver.findElement(By.className("main-menu-first-level-list-item"));
		Actions act = new Actions(driver);
		act.moveToElement(Admin).build().perform();
		
		//hover on usermnagement
		WebElement UserMangement; 
		UserMangement = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='menu_admin_UserManagement']")));
		act.moveToElement(UserMangement).build().perform();
		
		//Click on User Menu
		WebElement User;
		User=new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_admin_viewSystemUsers")));
		User.click();
		//System.out.println("User Reached to System User");
		
		WebElement checkbox_delete =driver.findElement(By.xpath("//a[text()='123jkkkkkk']//parent::td[@class='left']//preceding-sibling::td[not(@id)]//input[@name='chkSelectRow[]']"));
		checkbox_delete.click();
		
		
		
		
		
		//insite to add user
		driver.findElement(By.id("btnAdd")).click();
		//Select role
		Select SelectRole = new Select(driver.findElement(By.id("systemUser_userType")));
		SelectRole.selectByVisibleText("Admin");
		
		//Enter Employment Name 
		driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys("ce");
		//Actions act = new Actions(driver);
		act.sendKeys(Keys.DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();
		
		//Random Name Start
	    int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();
		//Randome Name End 
	    
	  //Enter username 
	  driver.findElement(By.xpath("//input[@id='systemUser_userName']")).sendKeys(generatedString);
	  
		
	  //Select Status
	  Select SelectStatus = new Select(driver.findElement(By.id("systemUser_status")));
	  SelectRole.selectByIndex(0);
	  
	  
	  driver.findElement(By.id("systemUser_password")).sendKeys("Teste");


	  
	  //Pssword Length
      WebElement password_Strength =new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("systemUser_password_strength_meter")));
      String Actual_Password_Very_week = password_Strength.getText();
	  String Expected_Password_Very_week = "Very Weak";
	  Assert.assertEquals(Actual_Password_Very_week, Expected_Password_Very_week , "Password is Very week");
	  
	  
	  //Enter week password
	  driver.findElement(By.id("systemUser_password")).clear();
	  driver.findElement(By.id("systemUser_password")).sendKeys("Tester01");
	  WebElement password_Strength_Weak =new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='weak passwordStrengthCheck']")));	  
	  String Actual_password_weak =  password_Strength_Weak.getText();
	  String Expected_Password_strength = "Weak";
	  Assert.assertEquals(Actual_password_weak, Expected_Password_strength , "Password is week");
	  
	  //Verify Better Password
	  driver.findElement(By.id("systemUser_password")).clear();
	  driver.findElement(By.id("systemUser_password")).sendKeys("Tester@01");
	  WebElement password_Strength_Better =new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='better passwordStrengthCheck']")));	  
	  String Actual_password_Better = password_Strength_Better.getText();
	  String Expected_Password_Better = "Better";
	  Assert.assertEquals(Actual_password_Better, Expected_Password_Better , "Password is Very Better");
	  
	  //Verify Strongest password
	  driver.findElement(By.id("systemUser_password")).clear();
	  driver.findElement(By.id("systemUser_password")).sendKeys("Computer@123g19$&*");
	  WebElement password_Strength_Strong =new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='strongest passwordStrengthCheck']")));	  
	  String Actual_password_Strong = password_Strength_Strong.getText();
	  String Expected_Password_Strong = "Strongest";
	  Assert.assertEquals(Actual_password_Strong, Expected_Password_Strong , "Password is Strongest");
	  
	  //Required Password
	  driver.findElement(By.id("systemUser_password")).clear();
	  WebElement password_Validation =new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Required')]")));	    
	  String Actual_Required_validation= password_Validation.getText();
	  String Expected_Required_validation="Required";
	  Assert.assertEquals(Actual_Required_validation, Expected_Required_validation , "Password Required");
	  
	  
	  
	  //Required Confirm password
	  driver.findElement(By.id("systemUser_password")).sendKeys("Tester@01");
	  WebElement Confirm_password = driver.findElement(By.id("systemUser_confirmPassword"));
	  Confirm_password.sendKeys("Tester01");
	  
	
	  WebElement password_NoMatch =new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Passwords do not match')]")));	    
	  String Actual_Confirm_password_validation = password_NoMatch.getText();
	  String expected_Confirm_password_validation = "Passwords do not match";
	  Assert.assertEquals(Actual_Confirm_password_validation, expected_Confirm_password_validation , "Passwords do not match");
	  
	  Confirm_password.clear();
	  Confirm_password.sendKeys("Tester@01");
	  

	  
	  //Button Saved
	  WebElement Button =new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
	  Button.click(); 
	  System.out.println("User Add successfully");
	  Thread.sleep(1000);
	
	  
		
		
        
		
        //Closing the browser
        //driver.quit();
		

	}

}
