package rough;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Seven {

	public static void main(String[] args) throws InterruptedException {

		// Creating a driver object referencing WebDriver interface
		WebDriver driver = null;
		// WebDriverWait wait = new WebDriverWait(driver, 20);

		// Setting webdriver.gecko.driver property
		System.setProperty("webdriver.gecko.driver",
				"E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");

		// Instantiating driver object and launching browser
		driver = new FirefoxDriver();

		// Using get() method to open a webpage
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		//Actions act = new Actions(driver);

		// Login Functionality
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();

		//Click on Buzz Menu
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//b[contains(text(),'Buzz')]")).click();


		
		//Post some Status
		
		driver.findElement(By.xpath("//textarea[@id='createPost_content']")).click();
		driver.findElement(By.xpath("//textarea[@id='createPost_content']")).clear();
		driver.findElement(By.xpath("//textarea[@id='createPost_content']")).sendKeys("Example");
		driver.findElement(By.id("postSubmitBtn")).click();
		
		//Post am image
		driver.findElement(By.id("tabLink2")).click();
		WebElement UploadPostImage = driver.findElement(By.id("photofile"));
		
		
		
		
		//UploadPostImage.click();	
		UploadPostImage.sendKeys("E:\\3.jpg");
		driver.findElement(By.id("phototext")).sendKeys("ok its new photo");
		driver.findElement(By.id("imageUploadBtn")).click();


		//Delete 
		driver.findElement(By.id("postOptionWidget")).click();
		driver.findElement(By.linkText("Delete")).click();
		driver.findElement(By.id("delete_confirm")).click();
		String DeleteText = driver.findElement(By.id("successBodyDelete")).getText();
		System.out.println(DeleteText);
		
		
		//driver.findElement(By.tagName("textarea")).sendKeys("Edit One");
	
		
		
		
		
		
		//WebElement createPost = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("createPost_content")));
		//createPost.click();
		//createPost.clear();
		//createPost.sendKeys("Example");
		//driver.findElement(By.id("postSubmitBtn")).click();
		
		
		
		//driver.findElement(By.id("createPost_content")).click();
	    //driver.findElement(By.id("createPost_content")).clear();
	   //driver.findElement(By.id("createPost_content")).sendKeys("Example");
	    //driver.findElement(By.id("postSubmitBtn")).click();
		
		

	}

}
