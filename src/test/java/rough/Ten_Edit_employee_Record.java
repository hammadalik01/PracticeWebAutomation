package rough;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Ten_Edit_employee_Record {
	
	public static void main(String[] args) {
		
		
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
		
		//Edit Record
		driver.findElement(By.xpath("//a[contains(text(),'0002')]")).click();
		
		//driver.findElement(By.xpath("//input[@id='btnSave']")).click();
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("Edit");
		driver.findElement(By.id("personal_txtEmpLastName")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.id("personal_txtEmpLastName")).sendKeys("Edit");		
		
		driver.findElement(By.id("personal_txtOtherID")).sendKeys("10");
		driver.findElement(By.id("personal_txtLicenNo")).sendKeys("12345689");
		driver.findElement(By.id("personal_txtSINNo")).sendKeys("12378952");
		driver.findElement(By.id("personal_optGender_1")).click();
		
		Select MaritalStatus = new Select(driver.findElement(By.id("personal_cmbMarital")));
		MaritalStatus.selectByVisibleText("Single");
		
		Select Nationality = new Select(driver.findElement(By.id("personal_cmbNation")));
		Nationality.selectByVisibleText("Pakistani");
		
		//driver.findElement(By.id("personal_DOB")).sendKeys("1992-06-14");
		
		WebElement DateOfBirth = driver.findElement(By.id("personal_DOB"));
		DateOfBirth.clear();
		DateOfBirth.sendKeys("1992-04-16");
		

		
		driver.findElement(By.id("personal_txtEmpNickName")).sendKeys("Testing");
		driver.findElement(By.id("personal_txtMilitarySer")).sendKeys("Test");
		
		driver.findElement(By.id("btnSave")).click();
		
		//Edit Custom Field
		driver.findElement(By.id("btnEditCustom")).click();		
		Select BloodType = new Select(driver.findElement(By.name("custom1")));
		BloodType.selectByVisibleText("A+");
		driver.findElement(By.id("btnEditCustom")).click();
		
		
		
		//Add Attachment
		driver.findElement(By.id("btnAddAttachment")).click();
		WebElement uploadElement = driver.findElement(By.id("ufile"));
		uploadElement.sendKeys("D:\\image\\3.png");		
		driver.findElement(By.id("txtAttDesc")).sendKeys("For Testing Purpose");
		driver.findElement(By.id("btnSaveAttachment")).click();
		
		
		//Change Profile Picture 
		driver.findElement(By.xpath("//img[@id='empPic']")).click();
		WebElement EmployPic=driver.findElement(By.id("photofile"));
		EmployPic.sendKeys("D:\\image\\profile_pic.jpg");
		driver.findElement(By.id("btnSave")).click();
		
		
		//Edit Contcat Details
		driver.findElement(By.xpath("//a[contains(text(),'Contact Details')]")).click();
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("contact_street1")).sendKeys("karu 17");
		driver.findElement(By.id("contact_street2")).clear();
		driver.findElement(By.id("contact_city")).sendKeys("Tallinn");
		driver.findElement(By.id("contact_province")).sendKeys("kööginurgaga");
		driver.findElement(By.id("contact_emp_zipcode")).sendKeys("10120");		
		Select contcountry = new Select(driver.findElement(By.id("contact_country")));
		contcountry.selectByVisibleText("Estonia");		
		driver.findElement(By.id("btnSave")).click();
		
		
		//Emergency Contacts		
		driver.findElement(By.xpath("//a[contains(text(),'Emergency Contacts')]")).click();
		driver.findElement(By.id("btnAddContact")).click();
		driver.findElement(By.id("emgcontacts_name")).sendKeys("emgcontacts_name");
		driver.findElement(By.id("emgcontacts_relationship")).sendKeys("emgcontacts_relationship");
		driver.findElement(By.id("btnSaveEContact")).click();
		
		//Immigration
		driver.findElement(By.xpath("//a[contains(text(),'Immigration')]")).click();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("immigration_number")).sendKeys("123456789");
		driver.findElement(By.id("btnSave")).click();
		
		
		//Edit Job Record
	    driver.findElement(By.xpath("(//a[contains(text(),'Job')])[4]")).click();
		driver.findElement(By.id("btnSave")).click();
	    //Job_Tittle
	    Select job_title = new Select(driver.findElement(By.id("job_job_title")));
	    job_title.selectByVisibleText("Account Assistant");  
	    //Emp Status
	    driver.findElement(By.id("job_emp_status")).click();
	    new Select(driver.findElement(By.id("job_emp_status"))).selectByVisibleText("Full-Time Contract");
	    //Job Category 
	    Select job_category = new Select(driver.findElement(By.id("job_eeo_category")));
	    job_category.selectByVisibleText("Officials and Managers");
	    //Job Location
	    Select job_location = new Select (driver.findElement(By.id("job_location")));
	    job_location.selectByVisibleText("New York Sales Office");
	    driver.findElement(By.id("btnSave")).click();
	
		
		//Salary
		driver.findElement(By.xpath("//a[contains(text(),'Salary')]")).click();
		driver.findElement(By.id("addSalary")).click();
		driver.findElement(By.id("salary_salary_component")).sendKeys("Monthly Salary");		
		Select PayFrequently = new Select(driver.findElement(By.id("salary_payperiod_code")));		
		PayFrequently.selectByVisibleText("Monthly");
		driver.findElement(By.id("salary_basic_salary")).sendKeys("1500");
		driver.findElement(By.id("btnSalarySave")).click();
		
		//Tax Exemptions
		driver.findElement(By.xpath("//a[contains(text(),'Tax Exemptions')]")).click();
		driver.findElement(By.id("btnSave")).click();
		Select federalStatus = new Select (driver.findElement(By.id("tax_federalStatus")));
		federalStatus.selectByVisibleText("Single");
		WebElement federalExemptions = driver.findElement(By.id("tax_federalExemptions"));
		federalExemptions.clear();
		federalExemptions.sendKeys("100");
		driver.findElement(By.id("btnSave")).click();
		
		//MemberShip
		driver.findElement(By.xpath("(//a[contains(text(),'Memberships')])[2]")).click();
		driver.findElement(By.id("btnAddMembershipDetail")).click();
		driver.findElement(By.id("membership_membership")).click();
		new Select(driver.findElement(By.id("membership_membership")))
				.selectByVisibleText("British Computer Society (BCS)");
		driver.findElement(By.id("membership_subscriptionPaidBy")).click();
		new Select(driver.findElement(By.id("membership_subscriptionPaidBy"))).selectByVisibleText("Company");
		driver.findElement(By.id("membership_subscriptionAmount")).click();
		driver.findElement(By.id("membership_subscriptionAmount")).clear();
		driver.findElement(By.id("membership_subscriptionAmount")).sendKeys("1000");
		driver.findElement(By.id("membership_currency")).click();
		new Select(driver.findElement(By.id("membership_currency"))).selectByVisibleText("Afghanistan Afghani");
		driver.findElement(By.cssSelector("img.ui-datepicker-trigger")).click();
		driver.findElement(By.linkText("6")).click();
		driver.findElement(By.xpath("//form[@id='frmEmpMembership']/fieldset/ol/li[6]/img")).click();
		driver.findElement(By.linkText("13")).click();
		driver.findElement(By.xpath("//form[@id='frmEmpMembership']/fieldset/ol/li[5]")).click();
		driver.findElement(By.id("btnSaveMembership")).click();
		
		
        driver.findElement(By.id("welcome")).click();
		driver.findElement(By.linkText("Logout")).click();
	
		

		
	}
	
	
	
	
	
	

}
