package testcases;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import base.TestBase;

public class User extends TestBase {
	

	@Test (priority=4)
	public void SystemUser() {

		log.info("Hover on Admin menu");
		// Move To menu
		WebElement Admin = driver.findElement(By.className(OR.getProperty("admin_classname")));
		Actions act = new Actions(driver);
		act.moveToElement(Admin).build().perform();

		log.info("hover on usermnagement");
		// Move to UserMangement
		WebElement UserMangement;
		UserMangement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("usermangement_xpath"))));
		act.moveToElement(UserMangement).build().perform();

		log.info("Click on User");
		// Click on User Menu
		WebElement User;
		// menu_admin_viewSystemUsers
		User = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(OR.getProperty("user_id"))));
		User.click();
		
		log.info("insite System User View");
		// Get Text of System User
		WebElement HeadText = driver.findElement(By.xpath(OR.getProperty("systemuser_xpath")));
		String ActualHeaderText = HeadText.getText();
		String ExpectedHeaderText = "System Users";
		soft.assertEquals(ActualHeaderText, ExpectedHeaderText);
		log.info("User land on a SystemUserView successfully");
	}
	
	@Test (priority=5)
	public String AddUserAndCheckPasswordValidation() throws InterruptedException{

		log.info("insite to add user");
		driver.findElement(By.xpath(OR.getProperty("buttonAdd_xpath"))).click();
		log.info("Go to add user section and select valid data");
		// Select role
		Select SelectRole = new Select(driver.findElement(By.id(OR.getProperty("usertype_id"))));
		SelectRole.selectByVisibleText("Admin");

		// Enter Employment Name
		driver.findElement(By.id(OR.getProperty("employeeName_id"))).sendKeys("ce");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();
		
		//Ramdom name 
		Faker faker = new Faker();
		String Username = faker.name().fullName();


		// Enter username
		driver.findElement(By.xpath(OR.getProperty("username_xpath"))).sendKeys(Username);

		// Select Status
		Select SelectStatus = new Select(driver.findElement(By.id(OR.getProperty("systemstatus_id"))));
		SelectRole.selectByIndex(0);

		// Enter password
		log.info("Enter password less than 8 chracter");
		driver.findElement(By.id(OR.getProperty("systemUserPassword_id"))).sendKeys("Teste");
		
		//Pssword Length
	    WebElement password_Strength =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(OR.getProperty("veryweakstrength_id"))));
	    String Actual_Password_Very_week = password_Strength.getText();
		String Expected_Password_Very_week = "Very Weak";
		Assert.assertEquals(Actual_Password_Very_week, Expected_Password_Very_week , "Password is Very week");
		  
		  
		  
		  //Enter week password
		  driver.findElement(By.id("systemUser_password")).clear();
		  driver.findElement(By.id("systemUser_password")).sendKeys("Tester01");
		  WebElement password_Strength_Weak =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("weakstrength_xpath"))));	  
		  String Actual_password_weak =  password_Strength_Weak.getText();
		  String Expected_Password_strength = "Weak";
		  Assert.assertEquals(Actual_password_weak, Expected_Password_strength , "Password is week");
		  
		  
		  //Verify Better Password
		  //driver.findElement(By.id("systemUser_password")).clear();
		  //driver.findElement(By.id("systemUser_password")).sendKeys("Tester@01");
		  //WebElement password_Strength_Better =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("betterstrength_xpath"))));	  
		  //String Actual_password_Better = password_Strength_Better.getText();
		  //String Expected_Password_Better = "Better";
		  //Assert.assertEquals(Actual_password_Better, Expected_Password_Better , "Password is Very Better");
		  
		  
		  //Verify Strongest password
		  
		  //driver.findElement(By.id("systemUser_password")).clear();
		  //driver.findElement(By.id("systemUser_password")).sendKeys("Computer@123g19$&*");
		  //WebElement password_Strength_Strong =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("strongstrength_xpath"))));	  
		  //String Actual_password_Strong = password_Strength_Strong.getText();
		  //String Expected_Password_Strong = "Strongest";
		  //Assert.assertEquals(Actual_password_Strong, Expected_Password_Strong , "Password is Strongest");
		  
		  
		  //Required Password
		  driver.findElement(By.id("systemUser_password")).clear();
		  WebElement password_Validation =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("requiredpassword"))));	    
		  String Actual_Required_validation= password_Validation.getText();
		  String Expected_Required_validation="Required";
		  Assert.assertEquals(Actual_Required_validation, Expected_Required_validation , "Password Required");
		  
		  
		//Required Confirm password
		  driver.findElement(By.id("systemUser_password")).sendKeys("Tester@01");
		  WebElement Confirm_password = driver.findElement(By.id(OR.getProperty("confirmpassword_id")));
		  Confirm_password.sendKeys("Tester01");
		  
		  
		 WebElement password_NoMatch =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("passwordnotmatch_xpath"))));	    
		 String Actual_Confirm_password_validation = password_NoMatch.getText();
		 String expected_Confirm_password_validation = "Passwords do not match";
		 Assert.assertEquals(Actual_Confirm_password_validation, expected_Confirm_password_validation , "Passwords do not match");		  
		 Confirm_password.clear();
		 Confirm_password.sendKeys("Tester@01");
		  
	
		// Click for Save Record
		 Thread.sleep(2000);
		WebElement Button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(OR.getProperty("btnSave_id"))));
		act.doubleClick(Button).perform();
		
		WebElement MessageSucc = new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='message success fadable']"))); 
		String ExpectedSuccessFull_message ="Successfully Saved";
		String ActualSuccessFull_message =  MessageSucc.getText();
		Assert.assertEquals(ActualSuccessFull_message, ExpectedSuccessFull_message ,"User Not Added in Admin section");	
		
		
		
		log.info("User Add successfully");
		
		//Button.click();
		log.info("User Add successfully in System User");
		return Username;

      }


}
