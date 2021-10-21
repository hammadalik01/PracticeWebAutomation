package testcases;

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

import base.TestBase;

public class EditEmployeeRecord extends TestBase {

	@Test(priority = 30)
	public void verifyDateValidationMesageshow() {

		// Hover on PIM
		WebElement PIM = driver.findElement(By.id(OR.getProperty("pim_id")));
		Actions act = new Actions(driver);
		act.moveToElement(PIM).build().perform();

		// Click on Employment List Menu
		WebElement EmployeeListMenu = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id(OR.getProperty("employeeListMenu_id"))));
		EmployeeListMenu.click();

		driver.findElement(By.xpath(OR.getProperty("checkbox_xpath"))).click();
		driver.findElement(By.xpath(OR.getProperty("btnSave_xpath"))).click();

		WebElement DateOfBirth = driver.findElement(By.id(OR.getProperty("dateofBirth_id")));
		DateOfBirth.clear();
		DateOfBirth.sendKeys("01-25-1992");

		driver.findElement(By.id(OR.getProperty("btnSave_id"))).click();
		WebElement validation_msg = driver.findElement(By.xpath(OR.getProperty("validationMessage_xpath")));
		String ActualValidationErrorMsg = validation_msg.getText();
		String ExpectedValidationErrorMsg = "Should be a valid date in yyyy-mm-dd";
		soft.assertEquals(ActualValidationErrorMsg, ExpectedValidationErrorMsg, "Date Validation message show");	

		log.info("Date Validation Message show");

	}

	@Test(priority = 31)
	public void VerifyEmployeeRecordEditSuccessfully() throws InterruptedException {

		driver.findElement(By.id(OR.getProperty("fullname_id"))).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.id(OR.getProperty("fullname_id"))).sendKeys("Edit");
		driver.findElement(By.id(OR.getProperty("lastname_id"))).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.id(OR.getProperty("lastname_id"))).sendKeys("Edit");
		driver.findElement(By.id(OR.getProperty("otherID_id"))).sendKeys("10");
		WebElement ssnNumber = driver.findElement(By.id(OR.getProperty("ssn_number_id")));
		ssnNumber.clear();
		ssnNumber.sendKeys("12345689");
		
		//WebElement SinNumber = driver.findElement(By.id(OR.getProperty("sinNumber_id")));
		//SinNumber.clear();
		//SinNumber.sendKeys("122334455");
		
		driver.findElement(By.id(OR.getProperty("gender_id"))).click();
		Select MaritalStatus = new Select(driver.findElement(By.id(OR.getProperty("maritStatus_id"))));
		MaritalStatus.selectByVisibleText("Single");
		Select Nationality = new Select(driver.findElement(By.id(OR.getProperty("nationality_id"))));
		Nationality.selectByVisibleText("Pakistani");

		WebElement PersonalDateOfBirth = driver.findElement(By.xpath(OR.getProperty("dateofBirth_xpath")));
		PersonalDateOfBirth.clear();
		PersonalDateOfBirth.sendKeys("1992-04-16");

		//driver.findElement(By.id(OR.getProperty("nickname_id"))).sendKeys("Testing");
		//driver.findElement(By.id(OR.getProperty("military_Service_id"))).sendKeys("Test");

		driver.findElement(By.xpath(OR.getProperty("btnSave_xpath"))).click();
		
		
		
		WebElement MessageSucc = new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='message success fadable']"))); 
		String ExpectedSuccessFull_message ="Successfully Saved";
		String ActualSuccessFull_message =  MessageSucc.getText();
		Assert.assertEquals(ActualSuccessFull_message, ExpectedSuccessFull_message ,"Employee Profile not Updated");	
		log.info("Employee Record Edit Successfully with return message" + " " + ActualSuccessFull_message);
	}

	@Test(priority = 32)
	public void VerifyCustomFieldEditSuccessfully() {
		driver.findElement(By.id(OR.getProperty("customEditButton_id"))).click();
		Select BloodType = new Select(driver.findElement(By.name(OR.getProperty("bloodType_name"))));
		BloodType.selectByVisibleText("A+");
		driver.findElement(By.id(OR.getProperty("customEditButton_id"))).click();
		WebElement MessageSucc = new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='message success fadable']"))); 
		String ExpectedSuccessFull_message ="Successfully Updated";
		String ActualSuccessFull_message =  MessageSucc.getText();
		Assert.assertEquals(ActualSuccessFull_message, ExpectedSuccessFull_message ,"Employee Custom Field not Updated");	
		log.info("Custom Field Edit Successfully");
	}
	
	@Test (priority=33)
	public void VerifyFileAttachmentSuccessfully() {
		driver.findElement(By.id(OR.getProperty("ButtonAttachment_id"))).click();
		WebElement uploadElement = driver.findElement(By.id(OR.getProperty("fileAttachment_id")));
		uploadElement.sendKeys("E:\\img\\3.jpg");		
		driver.findElement(By.id(OR.getProperty("attachmentCommentBox_id"))).sendKeys("For Testing Purpose");
		driver.findElement(By.id(OR.getProperty("uploadAttachment_id"))).click();	
				
		WebElement MessageSucc = new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='message success fadable']"))); 
		String ExpectedSuccessFull_message ="Successfully Saved";
		String ActualSuccessFull_message =  MessageSucc.getText();
		Assert.assertEquals(ActualSuccessFull_message, ExpectedSuccessFull_message ,"In Employee Section file is not updated");	
	
		log.info("File Attachment Successfully with message return" + " " + ActualSuccessFull_message );
		
	}	
	
	@Test (priority=34)
	public void VerifyEmployeeProfilePictureUploadSuccessfully() {			
		driver.findElement(By.xpath("//img[@id='empPic']")).click();
		WebElement EmployPic=driver.findElement(By.id(OR.getProperty("changePhoto_id")));
		EmployPic.sendKeys("E:\\img\\profile_pic.png");
		driver.findElement(By.id(OR.getProperty("btnSave_id"))).click();		
		WebElement MessageSucc = new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='message success fadable']"))); 
		String ExpectedSuccessFull_message ="Successfully Uploaded";
		String ActualSuccessFull_message =  MessageSucc.getText();
		Assert.assertEquals(ActualSuccessFull_message, ExpectedSuccessFull_message ,"In Employee Section Profile picture is not uploaded");		
		log.info("Employee Profile Picture Upload Successfully with Return message" + " " + ActualSuccessFull_message );
	}
	
	
	@Test (priority=35)
	public void VerifyContactDetailAddedSuccessfully() {
		driver.findElement(By.xpath(OR.getProperty("contactDetailMenu_xpath"))).click();
		driver.findElement(By.xpath(OR.getProperty("btnSave_xpath"))).click();
		driver.findElement(By.id(OR.getProperty("addressStreet1_ID"))).clear();
		driver.findElement(By.id(OR.getProperty("addressStreet1_ID"))).sendKeys("karu 17");
		driver.findElement(By.id(OR.getProperty("addressStreet2_ID"))).clear();
		driver.findElement(By.id(OR.getProperty("city_ID"))).sendKeys("Tallinn");
		driver.findElement(By.id(OR.getProperty("contact_province_id"))).sendKeys("kööginurgaga");
		driver.findElement(By.id(OR.getProperty("zipcode_id"))).sendKeys("10120");		
		Select contcountry = new Select(driver.findElement(By.id(OR.getProperty("contactcountry_id"))));
		contcountry.selectByVisibleText("Estonia");		
		driver.findElement(By.xpath(OR.getProperty("btnSave_xpath"))).click();
		
		WebElement MessageSucc = new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='message success fadable']"))); 
		String ExpectedSuccessFull_message ="Successfully Saved";
		String ActualSuccessFull_message =  MessageSucc.getText();
		Assert.assertEquals(ActualSuccessFull_message, ExpectedSuccessFull_message ,"In Employee Section Contact is not updated");	
		log.info("Contact Detail Added Successfully with return message" + " " + ActualSuccessFull_message );
	}
	
	@Test (priority=36)
	public void ValidateEmergencyContactAddedSuccessfully() {		
		driver.findElement(By.xpath(OR.getProperty("emergencyMenu_xpath"))).click();
		driver.findElement(By.id(OR.getProperty("emergencyAddContact_id"))).click();
		driver.findElement(By.id(OR.getProperty("emergencyContact_id"))).sendKeys("emgcontacts_name");
		driver.findElement(By.id(OR.getProperty("relationshipcontact_id"))).sendKeys("emgcontacts_relationship");
		driver.findElement(By.id(OR.getProperty("EmergencyContactNumber"))).sendKeys("1234567");
		driver.findElement(By.id(OR.getProperty("Savecontactbutton_id"))).click();	
		
		WebElement MessageSucc = new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='message success fadable']"))); 
		String ExpectedSuccessFull_message ="Successfully Saved";
		String ActualSuccessFull_message =  MessageSucc.getText();
		Assert.assertEquals(ActualSuccessFull_message, ExpectedSuccessFull_message ,"In Employee Section Emergency Contact is not updated");	
		log.info("Emergency Contact Added Successfully with return message" + " " + ActualSuccessFull_message);
	}
	
	
	
	@Test (priority=37)
	public void ValidateImmigrationRecordAddedSuccessfully() {
		driver.findElement(By.xpath(OR.getProperty("immigration_xpath"))).click();
		driver.findElement(By.xpath(OR.getProperty("buttonAdd_xpath"))).click();
		driver.findElement(By.id(OR.getProperty("immigrationNumber_id"))).sendKeys("123456789");
		driver.findElement(By.xpath(OR.getProperty("btnSave_xpath"))).click();
		
		WebElement MessageSucc = new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='message success fadable']"))); 
		String ExpectedSuccessFull_message ="Successfully Saved";
		String ActualSuccessFull_message =  MessageSucc.getText();
		Assert.assertEquals(ActualSuccessFull_message, ExpectedSuccessFull_message ,"In Employee Section Emergency Contact is not updated");	
		log.info("Immigration Record Added Successfully with return message"+ " "+ ActualSuccessFull_message);  
	}
	
	@Test (priority=38)
	public void ValidatejobEditSuccessfully() {
		
		//Edit Job Record
	    driver.findElement(By.xpath(OR.getProperty("jobMenu_xpath"))).click();
		driver.findElement(By.id(OR.getProperty("btnSave_id"))).click();
		
	    //Job_Tittle
	    Select job_title = new Select(driver.findElement(By.id(OR.getProperty("jobjobtitle_id"))));
	    job_title.selectByVisibleText("QA Engineer");  
	    
	    //Emp Status
	    driver.findElement(By.id(OR.getProperty("jobEmpStatus_id"))).click();
	    new Select(driver.findElement(By.id(OR.getProperty("jobEmpStatus_id")))).selectByVisibleText("Full-Time Contract");
	    
	    //Job Category 
	    Select job_category = new Select(driver.findElement(By.id(OR.getProperty("jobCategory_id"))));
	    job_category.selectByVisibleText("Officials and Managers");
	    
	    //Job Location
	    Select job_location = new Select (driver.findElement(By.id(OR.getProperty("jobjobLocation_id"))));
	    job_location.selectByVisibleText("New York Sales Office");
	    driver.findElement(By.xpath(OR.getProperty("btnSave_xpath"))).click();
	    
	    WebElement MessageSucc = new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='message success fadable']"))); 
		String ExpectedSuccessFull_message ="Successfully Updated";
		String ActualSuccessFull_message =  MessageSucc.getText();
		Assert.assertEquals(ActualSuccessFull_message, ExpectedSuccessFull_message ,"In Employee Section Emergency Contact is not updated");	    
		log.info("job Added Successfully with return message" + " " + ActualSuccessFull_message);
		
	}

	
	@Test (priority=39)
	public void ValidateSalaryAddedSuccessfully() {		
		driver.findElement(By.xpath(OR.getProperty("salarymenu_xpath"))).click();
		driver.findElement(By.id(OR.getProperty("addsalary_id"))).click();
		driver.findElement(By.id(OR.getProperty("salaryComponent_xpath"))).sendKeys("Monthly Salary");		
		Select PayFrequently = new Select(driver.findElement(By.id(OR.getProperty("salaryperiod_id"))));		
		PayFrequently.selectByVisibleText("Monthly");

		Select Salarycurrency = new Select(driver.findElement(By.id(OR.getProperty("salarycurrency_id"))));		
		Salarycurrency.selectByVisibleText("Euro");

		driver.findElement(By.id(OR.getProperty("amount_id"))).sendKeys("1500");
		driver.findElement(By.id(OR.getProperty("salarySave_id"))).click();
		
		WebElement MessageSucc = new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='message success fadable']"))); 
		String ExpectedSuccessFull_message ="Successfully Saved";
		String ActualSuccessFull_message =  MessageSucc.getText();
		Assert.assertEquals(ActualSuccessFull_message, ExpectedSuccessFull_message ,"In Employee Section Emergency Contact is not updated");	    
		log.info("Salary Added Successfully with return message" + " " + ActualSuccessFull_message);
	}
	
	@Test (priority=40)
	public void ValidateTaxExemptionAddedSuccessfully() {
		
		WebElement TaxExemptionsXpath = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("taxExemptions_xpath"))));
		TaxExemptionsXpath.click();		
		driver.findElement(By.xpath(OR.getProperty("btnSave_xpath"))).click();
		Select federalStatus = new Select (driver.findElement(By.id(OR.getProperty("federalStatus_id"))));
		federalStatus.selectByVisibleText("Single");
		WebElement federalExemptions = driver.findElement(By.id(OR.getProperty("exemptions_id")));
		federalExemptions.clear();
		federalExemptions.sendKeys("100");
		driver.findElement(By.xpath(OR.getProperty("btnSave_xpath"))).click();
			
		WebElement MessageSucc = new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='message success fadable']"))); 
		String ExpectedSuccessFull_message ="Successfully Saved";
		String ActualSuccessFull_message =  MessageSucc.getText();
		Assert.assertEquals(ActualSuccessFull_message, ExpectedSuccessFull_message ,"In Employee Section Emergency Contact is not updated");	    
		log.info("Tax Exemption Added Successfully with return message" +" " + ActualSuccessFull_message);
		
	}	
	
	@Test (priority=41)
	public void ValidateMemberShipEditSuccessFully() {
		
		driver.findElement(By.xpath(OR.getProperty("membershipmenu_xpath"))).click();
		driver.findElement(By.id(OR.getProperty("addbuttonMembershipDetail_id"))).click();
		
		WebElement MemberShip = driver.findElement(By.id(OR.getProperty("membershipMembership_id")));
		Select MemberShipDropDown = new Select(MemberShip);
		MemberShipDropDown.selectByVisibleText("British Computer Society (BCS)");
				
		WebElement membership_subscriptionPaid =driver.findElement(By.id(OR.getProperty("memberSubscriptionPaid_id")));
		Select membership_subscriptionPaidDropdown = new Select(membership_subscriptionPaid);
		membership_subscriptionPaidDropdown.selectByVisibleText("Company");

		driver.findElement(By.id(OR.getProperty("membership_subscriptionAmount_id"))).click();
		driver.findElement(By.id(OR.getProperty("membership_subscriptionAmount_id"))).clear();
		driver.findElement(By.id(OR.getProperty("membership_subscriptionAmount_id"))).sendKeys("1000");
		
		driver.findElement(By.id(OR.getProperty("membershipcurrency_id"))).click();
		new Select(driver.findElement(By.id(OR.getProperty("membershipcurrency_id")))).selectByVisibleText("Afghanistan Afghani");
		driver.findElement(By.cssSelector(OR.getProperty("susbscribtionDatePicker_cssSelector"))).click();
		driver.findElement(By.linkText(OR.getProperty("subscription_linkText"))).click();
		
		driver.findElement(By.xpath(OR.getProperty("subscriptionRenewalDatePicket_xpath"))).click();
		driver.findElement(By.linkText(OR.getProperty("13_linkText"))).click();
		driver.findElement(By.xpath(OR.getProperty("selectdate_xpath"))).click();
		driver.findElement(By.id(OR.getProperty("btnSaveMembership_id"))).click();
		
				
		WebElement MessageSucc = new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='message success fadable']"))); 
		String ExpectedSuccessFull_message ="Successfully Saved";
		String ActualSuccessFull_message =  MessageSucc.getText();
		Assert.assertEquals(ActualSuccessFull_message, ExpectedSuccessFull_message ,"In Employee Section Emergency Contact is not updated");	    
		

		log.info("Member Ship Edit Successfully with return message" +" " + ActualSuccessFull_message);
		
	}	
	
	
	@Test (priority=42)
	public void ValidateEditEmployeeDeletedSuccessfully() {
		
		WebElement EmployeeListMenu = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id(OR.getProperty("employeeListMenu_id"))));
		EmployeeListMenu.click();
		
		driver.findElement(By.id(OR.getProperty("employeesearchID_id"))).sendKeys("1.0");
		driver.findElement(By.id(OR.getProperty("serachButton_id"))).click();
		driver.findElement(By.id(OR.getProperty("checkboxSelectAll_id"))).click();
		driver.findElement(By.id(OR.getProperty("buttonDelete_id"))).click();
		driver.findElement(By.id(OR.getProperty("dialogDeletebtn_id"))).click();
		//driver.findElement(By.id(OR.getProperty("resetBtn_id"))).click();				
		WebElement MessageSucc = new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='message success fadable']"))); 
		String ExpectedSuccessFull_message ="Successfully Deleted";
		String ActualSuccessFull_message =  MessageSucc.getText();
		Assert.assertEquals(ActualSuccessFull_message, ExpectedSuccessFull_message ,"In Employee Section Emergency Contact is not updated");	    

		log.info("Edit Employee Deleted Successfully with return message" + " " + ActualSuccessFull_message);
		
	}
	
	

}
