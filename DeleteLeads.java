package week2.day2;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLeads 
{

	

	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();

		 // Launch URL "http://leaftaps.com/opentaps/control/login"
          driver.get("http://leaftaps.com/opentaps");
		
		 driver.manage().window().maximize();
		 
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		 //  Enter UserName and Password Using Id Locator
			driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
			
			driver.findElement(By.id("password")).sendKeys("crmsfa");
			
			//3. Click on Login Button using Class Locator
			driver.findElement(By.className("decorativeSubmit")).click();
			String text = driver.findElement(By.tagName("h2")).getText();
			System.out.println(text);
			
			
			driver.findElement(By.linkText("CRM/SFA")).click();
			
			driver.findElement(By.linkText("Create Lead")).click();
			
			driver.findElementByLinkText("Find Leads").click();
			
			//	Click on Phone
			driver.findElementByXPath("//span[text()='Phone']").click();
			Thread.sleep(2000);
			
			//Enter phone number
			driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys("123456");
			  Thread.sleep(5000);
			  
			 // Click find leads button
			 driver.findElementByXPath( "//button[text()='Find Leads']").click();
			 Thread.sleep(2000);
			 
			 //Capture lead ID of First Resulting lead
			String type= driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]").getText();
			System.out.println("type");
			Thread.sleep(2000);
			
			//Click First resulting lead
			driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]").click();
			Thread.sleep(2000);
			
			
			 //Click Delete
			 driver.findElementByLinkText("delete").click();
			 driver.findElementByXPath("//a[text()='Delete']").click();
			 Thread.sleep(2000);
			 
			 //Click Find leads
			 driver.findElementByLinkText("Find Leads").click();
			 Thread.sleep(2000);
			 
			 //Enter captured Lead id
			 driver.findElementByXPath("//input[@name='id']").sendKeys(text);
			 Thread.sleep(2000);
			 
			 //click find leads button
			 driver.findElementByXPath( "//button[text()='Find Leads']").click();
			 
			 //Verify message "No records to display" in the Lead List. This message confirms the successful deletion
			 String text1 = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
				System.out.println(text1);
	
				
				if(text1.contains("No records to display")) {
					 System.out.println("Delete success. Lead record not available");
				 }
				 else
				 {
					 System.out.println("Lead record available. Delete failed");
				 }
				
				
				//close the browser(do not log out)
				driver.close();
	
			 
	}
}
			 
			 

