package assignment;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadBusiBuild {
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
		    Actions act = new Actions(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Implicit Wait
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); //Explicit wait
			
			driver.manage().window().maximize();   //Helps to maximize the full screen for the browser 
			
			String username= "qatest";
			String password= "qatest";
			
			String url = "https://"+ username+ ":" + password + "@" + "qa.busibud.com/test2";
			driver.get(url);      // Basically operation done here itself still if not work use further Alert code as well
			System.out.println("Title of the page is: "+driver.getTitle());	
			
			WebElement uploadfile = driver.findElement(By.xpath("//input[@type='file']//following::label"));
//			wait.until(ExpectedConditions.elementToBeClickable(uploadfile));
			uploadfile.sendKeys("C:\\Users\\Suraj Gupta\\Desktop\\SOU images\\IMG_20240105_132821.jpg");
			System.out.println("File is Uploaded Successfully");
	}
}
