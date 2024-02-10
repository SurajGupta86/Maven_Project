package assignment;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SignInBusibud {
	public static String browser;
	public static WebDriver driver;
	
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter the browser name: ");
		browser=sc.nextLine();
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		    Actions act = new Actions(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Implicit Wait
			//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); //Explicit wait
			
			driver.manage().window().maximize();   //Helps to maximize the full screen for the browser 
			
			//taking an input from the user 
			System.out.println("Enter the username: ");
			String username= sc.next();
			System.out.println("Enter the password");
			String password= sc.next();
			
			sc.close();
			String url = "https://"+ username+ ":" + password + "@" + "qa.busibud.com/test1";
			driver.get(url);      // Basically operation done here itself still if not work use further Alert code as well
			System.out.println("Title of the page is: "+driver.getTitle());	
					  
//			Alert alt = driver.switchTo().alert();
//			alt.accept();
			
			WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
			email.sendKeys("XYZ@gmail.com");
	
			
			WebElement pwd = driver.findElement(By.xpath("//input[@type='text']"));
			pwd.sendKeys("Test@123");
			
			driver.findElement(By.xpath("//button[text()='Sign in']")).click();
			Thread.sleep(5000);
			
			System.out.println("Login successful but the 'Sign-In' button not working");
			
			driver.close();
			
	}

}
