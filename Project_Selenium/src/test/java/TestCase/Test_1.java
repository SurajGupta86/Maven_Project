package TestCase;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_1{
	
	public static String browser;
	public static WebDriver driver;
	
	public static void main(String[] args) throws Throwable {
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
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();   //Helps to maximize the full screen for the browser 
			driver.get("https://www.flipkart.com/");
			System.out.println("Title of the page is: "+driver.getTitle());
			driver.findElement(By.xpath("//span[text()='Login']")).click();
			//Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[1]/input")).sendKeys("8369187184");
			//Thread.sleep(5000);
			driver.findElement(By.xpath("//button[text()='Request OTP']")).click();
			Thread.sleep(5000);
			//driver.close();

	}
//wTGAwaTUST
}
