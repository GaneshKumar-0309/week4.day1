package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundWindow {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		//launch the url

		driver.get("http://www.leafground.com/pages/Window.html");
		
	   //mazimize
		
		driver.manage().window().maximize();
		
		//1.Click button to open home page in New Window
		
		driver.findElement(By.id("home")).click();
		
		//closing the opened window
		
		//moving control to the second window
		
		Set<String> windowHandles = driver.getWindowHandles();

		//converting the set to list
		
		List<String> windowlst = new ArrayList<String>(windowHandles);
		
		String firstHandle = windowlst.get(0);
		
		String secondhandle = windowlst.get(1);
		
		driver.switchTo().window(secondhandle);
		
		//closing the window
		
		driver.close();
		
		//moving back to the First Window
		
		driver.switchTo().window(firstHandle);
		
		//2.Find the number of opened windows

		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		
		//to find the number of windows open
		
		Set<String> windowHandles2 = driver.getWindowHandles();
		
		int size = windowHandles2.size();
		
		//printing the number of windows open

		System.out.println("The Number of windows open is "+size);
		
		//To close the newly opened windows
		
		//converting the set to list
		
		List<String> windowlst2 = new ArrayList<String>(windowHandles2);
		
		for (int i = 1; i < windowlst2.size(); i++) {
			
			driver.switchTo().window(windowlst2.get(i));
			driver.close();
			
		}
		
		//moving the control back to winow1
		
		driver.switchTo().window(firstHandle);
		
		//3.Close all except this window
		
		driver.findElement(By.id("color")).click();
		
		//closeall the windows opened wxcept the original one
		
		Set<String> windowHandles3 = driver.getWindowHandles();

		List<String> windowlst3 = new ArrayList<String>(windowHandles3);
		
      for (int i = 1; i < windowlst3.size(); i++) {
			
			driver.switchTo().window(windowlst3.get(i));
			driver.close();
			
		}
      
       //moving the control back to winow1
		
        driver.switchTo().window(firstHandle);
      
        //wait for 2 new window to open
        
        driver.findElement(By.xpath("(//button[@id='color'])[2]")).click();
			
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));	
	}

}
