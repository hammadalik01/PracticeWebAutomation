package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base.TestBase;

public class Subscribe extends TestBase{
		
	@Test (priority=8)
	public void successfullySubscribeEmail() {		

		List<WebElement> dynamicElement = driver.findElements(By.id(OR.getProperty("subscriber_button_link_id")));
		
		if(dynamicElement.size() != 0){
			
		driver.findElement(By.id(OR.getProperty("subscriber_button_link_id"))).click();
		driver.findElement(By.id(OR.getProperty("subscriber_name_field_id"))).clear();				
		driver.findElement(By.id(OR.getProperty("subscriber_name_field_id"))).sendKeys("hammad");
		driver.findElement(By.id(OR.getProperty("subscriber_Email_id"))).clear();
		driver.findElement(By.id(OR.getProperty("subscriber_Email_id"))).sendKeys("Test@gmail.com");
		driver.findElement(By.id(OR.getProperty("subscribe_button_id"))).click();
		
		log.info("Successfully message show");
		WebElement Success_Full_Message= driver.findElement(By.xpath(OR.getProperty("Successfully_subscribe_message")));
		String ActualSuccessfullMessage = Success_Full_Message.getText();
		
		String ExpectedSuccessfullmessage = "Successfully Subscribed";		
		soft.assertEquals(ActualSuccessfullMessage, ExpectedSuccessfullmessage ,"User not Subscribed successfully");

		}
		
		else{
		 //Else if size is 0, then element is not present
		log.info("Subscribed button is hidden");
		 
		}
		
		
	}
	

}
