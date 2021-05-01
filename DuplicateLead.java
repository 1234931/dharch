package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {

		// TODO Auto-generated method stub
				WebDriverManager.chromedriver().setup();
				
				ChromeDriver driver = new ChromeDriver();

		 // Launch URL "http://leaftaps.com/opentaps/control/login"
		          driver.get("http://leaftaps.com/opentaps");
		//maximize window
	    	driver.manage().window().maximize();
	    	
	    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		// To Click Lead
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("12345");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(2000);

		String FirstLead = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]"))
				.getText();
		System.out.println("First Lead ID" + FirstLead);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]")).click();
		Thread.sleep(1000);
	
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(FirstLead);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		//boolean result = false;
		boolean result = driver.findElement(By.xpath("//div[@class='x-paging-info']")).isDisplayed();
		
		if(result)
		{
			System.out.println("Verified");
		}
		else
		{
			System.out.println("Not Verified");
		}
		
		driver.close();

		

	}

}
