package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		//launch the url
		
		driver.get("http://leaftaps.com/opentaps/control/login");
		
	    Thread.sleep(5000);
		
		//maximize
		
		driver.manage().window().maximize();
		
		//add implicitly wait
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Enter username and password
		
        driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		 
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		// 	Click Login
		
		driver.findElement(By.className("decorativeSubmit")).click();
		
		// Click crm/sfa link
		
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		
		Thread.sleep(5000);
		
		// Click on contacts Button
		
		driver.findElement(By.linkText("Contacts")).click();
		
		Thread.sleep(5000);
		
		//Click on Merge Contacts using Xpath Locator
		
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
				
		//Click on Widget of From Contact
		
		//span[text()='From Contact']/following::img
	   
		driver.findElement(By.xpath("//span[text()='From Contact']/following::img")).click();
  		
		//moving the control to second window
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		//converting the set to List
		
		List<String> windowHandleList = new ArrayList<String>(windowHandles);
		
		//getting the first windowHandle
		String firstWindowHandle = windowHandleList.get(0);
		
		//getting the first windowHandle
		String secondWindowHandle = windowHandleList.get(1);
		
		System.out.println("FirstWindowHandle "+firstWindowHandle);
		
		System.out.println("SecondWindowHandle "+secondWindowHandle);
		//switching the control to second window
		
		driver.switchTo().window(secondWindowHandle);
		
		//click on First Resulting Contact
		
		Thread.sleep(5000);
		//div[@class='class="x-grid3-cell-inner x-grid3-col-partyId']/following::a
	    
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]")).click();
	
		
		//switch back to first window
		
		driver.switchTo().window(firstWindowHandle);
		
		//Click on Widget of To Contact 
		
		driver.findElement(By.xpath("//span[text()='To Contact']/following::img")).click();

		Set<String> windowHandles1 = driver.getWindowHandles();
		
		//converting the set to List
		
		List<String> windowHandleList2 = new ArrayList<String>(windowHandles1);
		
		//getting the first windowHandle
		String thirdWindowHandle = windowHandleList2.get(1);
		
		System.out.println("FirstWindowHandle "+firstWindowHandle);
		
		System.out.println("ThirdWindowHandle "+thirdWindowHandle);
			
		//Switching to second window
		
		driver.switchTo().window(thirdWindowHandle);
		
		//Click on the second resulting contact
		
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]")).click();
		
		//Switching back to firstWindowHandle
		
		driver.switchTo().window(firstWindowHandle);
		
		//Click on Merge button using Xpath Locator

		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		
		//move into the Alert window
		
		Alert alert = driver.switchTo().alert();
		
		//Accept the alert
		
	    alert.accept();
	    
	    //Verify the title of the page
	    
	    System.out.println("The title of the current page is "+driver.getTitle());
	}

}
