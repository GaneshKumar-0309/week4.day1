package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForceWindowHandling {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		//launch the url

		driver.get("https://login.salesforce.com/");
		
	   //mazimize
		
		driver.manage().window().maximize();
		
		//adding immplicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		//Enter the username
		
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		
		//Enter the password
		
		driver.findElement(By.id("password")).sendKeys("Password$123");
		
		//Click on login button
		
		driver.findElement(By.id("Login")).click();
		
		//click on the learn more option in the Mobile publish
		
		driver.findElement(By.xpath("(//span[@class=' label bBody'])[2]")).click();
		
		//Switch to the next window using Windowhandles
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		//converting the set to list
		
		List<String> windowLst = new ArrayList<String>(windowHandles);
		
		String firstWindow = windowLst.get(0);
		
		String secondWindow = windowLst.get(1);
		
		//switching to second window
		
		driver.switchTo().window(secondWindow);
		
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		
		//Get the title
		
		String title = driver.getTitle();
		
		System.out.println("The title of the current window is "+title);
		
		//Switching back to the first window
		
		driver.switchTo().window(firstWindow);
		
		
		//close the browser
		
		driver.quit();
		
	 
	}

}
