package assignment;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartSerach {
	public static String browser;
	public static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
			// TODO Auto-generated method stub
			Scanner sc =new Scanner(System.in);
			System.out.println("Enter the browser name: ");
			browser=sc.nextLine();
			sc.close();
			if(browser.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			else if(browser.equals("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}

				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Implicit Wait
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); //Explicit wait
				
				driver.manage().window().maximize();   //Helps to maximize the full screen for the browser 
				
				driver.get("https://www.flipkart.com/");
				System.out.println("Title of the page is: "+driver.getTitle());
				
				driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).sendKeys("Iphone");
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
	}

}
