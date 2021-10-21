package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base.TestBase;

public class Configure extends TestBase{
	
    @Test (priority=12)
	public void VerifyUserOnConfigurePimPage() {
		// Hover on PIM
		WebElement PIM = driver.findElement(By.id(OR.getProperty("pim_id")));
		Actions act = new Actions(driver);
		act.moveToElement(PIM).build().perform();

		// move to configuration
		WebElement Configuration = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.id(OR.getProperty("configuration_id"))));
		act.moveToElement(Configuration).build().perform();
		
		// Click on Optional Fields
		WebElement OptionalField = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.id(OR.getProperty("optionalfield_id"))));
		OptionalField.click();
		String ActualResult = driver.findElement(By.xpath(OR.getProperty("configureHeading_id"))).getText();
		String EXpectedResult = "Configure PIM";
		soft.assertEquals(ActualResult, EXpectedResult , "User not land on Configure Page");
		log.info("User Land on Configure page");
	}
    
    @Test (priority=13)
    public void VerifyStatusOfCheckBoxesBeforeEdit() {
    	//Verify Nick Name are enabled or not
    	log.info("Verify Checkbox is disabled for Nick anme");
    	WebElement ShowNickNameIsEnabled  = driver.findElement(By.xpath(OR.getProperty("checkboxnickname_xpath")));
    	boolean ShowNickNamecheckboxStatus = ShowNickNameIsEnabled.isEnabled();
    	log.info("Check box for Show Nick Name, Smoker and Military Service in Personal Details is Enabled:"+" "+ShowNickNamecheckboxStatus);
    	Reporter.log("Check box for Show Nick Name, Smoker and Military Service in Personal Details is Enabled:"+" "+ShowNickNamecheckboxStatus);
    	boolean ExpectedShowNickNamecheckboxStatus = false;
    	soft.assertEquals(ShowNickNamecheckboxStatus, ExpectedShowNickNamecheckboxStatus);
    	
    	
		//Verify SSN field Enable or Disbale
		WebElement SsnfieldCheckboxIsEnabled  =driver.findElement(By.xpath(OR.getProperty("checkboxshowssn_xpath")));
		boolean SsnfieldCheckboxStatus =SsnfieldCheckboxIsEnabled.isEnabled();
    	log.info("Check box for SSN field in Personal Detail is Enabled:"+" "+SsnfieldCheckboxStatus);
    	Reporter.log("Check box for SSN field in Personal Detail is Enabled:"+" "+SsnfieldCheckboxStatus);
    	boolean ExpectedSsnfieldCheckboxStatus = false;
    	soft.assertEquals(SsnfieldCheckboxStatus, ExpectedSsnfieldCheckboxStatus);
    	
				
		//Verify SIN field Enable or Disbale
		WebElement SinFieldCheckboxIsEnabled = driver.findElement(By.xpath(OR.getProperty("checkboxshowsin_xpath")));
		boolean SinFieldCheckboxStatus = SinFieldCheckboxIsEnabled.isEnabled();
    	log.info("Check box for SIN field in Personal Details is Enabled:"+" "+SinFieldCheckboxStatus);
    	Reporter.log("Check box for SIN field in Personal Details is Enabled:"+" "+SinFieldCheckboxStatus);
    	boolean ExpectedSinFieldCheckboxStatus = false;
    	soft.assertEquals(SsnfieldCheckboxStatus, ExpectedSinFieldCheckboxStatus);
    	
    	    	
    	//Verify US Tax field Enable or Disbale 
    	WebElement USTaxFieldCheckboxIsEnabled = driver.findElement(By.xpath(OR.getProperty("checkboxustaxField")));
    	boolean USFieldCheckboxStatus = USTaxFieldCheckboxIsEnabled.isEnabled();
    	log.info("Check box for US Tax field in Personal Details is Enabled:"+" "+USFieldCheckboxStatus);
    	Reporter.log("Check box for US Tax field in Personal Details is Enabled:"+" "+USFieldCheckboxStatus);
    	boolean ExpectedUSTaxFieldCheckboxIsEnabled = false;
    	soft.assertEquals(USFieldCheckboxStatus, ExpectedUSTaxFieldCheckboxIsEnabled);	
    }
    
    @Test (priority=14)
    public void Updatecheckboxes() {
    	
    	log.info("Click on edit button and uncheck Nickname and SIN field");
    	//Click on Edit button
    	driver.findElement(By.id(OR.getProperty("btnSave_id"))).click();
    	//uncheck Nick Name
    	WebElement NicknameCheckbox =driver.findElement(By.xpath(OR.getProperty("checkboxnickname_xpath")));
    	NicknameCheckbox.click();
    	
    	//uncheck SIN
		WebElement sinFieldCheckbox = driver.findElement(By.xpath(OR.getProperty("checkboxshowsin_xpath")));
		sinFieldCheckbox.click(); 
		
		//Verify status after 
		
		log.info("Verify the status of check boxes after checked");
		
		//NickName
		boolean ActualNicknameCheckboxSelectionStatus = NicknameCheckbox.isSelected();
		boolean expectedNicknameCheckboxSelectionStatus = false;
		soft.assertEquals(ActualNicknameCheckboxSelectionStatus, expectedNicknameCheckboxSelectionStatus , "checked box is checked");
		
		//Sin Field
		boolean ActualsinfieldCheckboxSelectionStatus = sinFieldCheckbox.isSelected();
		boolean ExpectedsinfieldCheckboxSelectionStatus = false;
		soft.assertEquals(ActualsinfieldCheckboxSelectionStatus, ExpectedsinfieldCheckboxSelectionStatus);
		log.info(ActualsinfieldCheckboxSelectionStatus);
		
		//check status of SSN field
		WebElement SSNfield  = driver.findElement(By.xpath(OR.getProperty("checkboxshowssn_xpath")));
		boolean Actualssnfieldcheckboxstatus = SSNfield.isSelected();
		boolean Expectedssnfieldcheckboxstatus = false;
		soft.assertEquals(Actualssnfieldcheckboxstatus, Expectedssnfieldcheckboxstatus);
		log.info("Status of SSN field check box"+Actualssnfieldcheckboxstatus);
		
		//check status for US tax
		WebElement Ustax = driver.findElement(By.xpath(OR.getProperty("checkboxustaxField")));
		boolean Actualustaxcheckboxstatus = Ustax.isSelected();
		boolean Expectedustaxcheckboxstatus = false;
		soft.assertEquals(Actualustaxcheckboxstatus, Expectedustaxcheckboxstatus);
		log.info("Status of US tax field check box is"+Actualustaxcheckboxstatus);
		
		log.info("click on Save button");
		driver.findElement(By.xpath(OR.getProperty("btnSave_xpath"))).click();		

    }
    
}
