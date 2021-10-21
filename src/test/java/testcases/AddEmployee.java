package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;

public class AddEmployee extends TestBase {
	
	@Test (priority=26)
	public void VerifyUserOnAddEmployeeSection() {
		
		log.info("User Hover on PIM");		
	
		WebElement PIM = driver.findElement(By.id(OR.getProperty("pim_id")));
		Actions act = new Actions(driver);
		act.moveToElement(PIM).build().perform();
		
		log.info("Click on Add Employee");
		WebElement OptionalField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(OR.getProperty("addEmployeeMenu_id"))));
		OptionalField.click();		
		String ActualEmployeeHeading = driver.findElement(By.xpath(OR.getProperty("addEmployee_xpath"))).getText();
		String ExpectedEmployeeHeading = "Add Employee" ;
		Assert.assertEquals(ActualEmployeeHeading, ExpectedEmployeeHeading ,"User Not in Add Employee section");
		log.info("Admin land on Add Employee page");

	}
	
	@Test (priority=27 , dataProvider="getEmployeeData")
	public void VerifyAddEmployee(String FirstName , String LastName , String EmployeeId) {
		log.info("Add Employee and take data from excel sheet");
		driver.findElement(By.id(OR.getProperty("employee_FirstName_Id"))).sendKeys(FirstName);
		driver.findElement(By.id(OR.getProperty("employee_LastName_Id"))).sendKeys(LastName);
		WebElement EmpID= driver.findElement(By.id(OR.getProperty("employeeId_id")));
		EmpID.clear();
		EmpID.sendKeys(EmployeeId);
		driver.findElement(By.id("btnSave")).click();				
		driver.findElement(By.id(OR.getProperty("addEmployeeMenu_id"))).click();		
		log.info("Data added successfully from excel");
	}
	
	
	
	
	@DataProvider	
	  public Object[][] getEmployeeData(){
			
	   String sheetName="Add_EmployeeData";
			
	   int rows = excel.getRowCount(sheetName);
	   int cols = excel.getColumnCount(sheetName);
		
	   Object[][] data = new Object[rows-1][cols];
			
	     for(int rowNum = 2 ; rowNum <= rows ; rowNum++){ 
							
	     for(int colNum=0 ; colNum< cols; colNum++){
	    	 
		 data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum); //-2


			     }
			  }
			
			return data;
			
			
		}
	

	

}
