package TestCase;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dropdown {
	
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
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Implicit Wait
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); //Explicit wait
		
		driver.manage().window().maximize();   //Helps to maximize the full screen for the browser 
		
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
		System.out.println("Title of the page is: "+driver.getTitle());
		
		WebElement drop = driver.findElement(By.xpath("//div[@class='information closable']//following::select"));
		Select select = new Select(drop);  //using a class called select for drop-down purpose
		
		//Select any particular country by a method called 'SelectByValue'
		select.selectByValue("IND");
		
		//Select any particular country by a method called 'SelectByIndex'
		select.selectByIndex(3);  //Indexing starts from 0
		
		//Select any particular country by a method called 'SelectByVisisble'
		select.selectByVisibleText("Canada");
		 
		List<WebElement> allOptions = driver.findElements(By.tagName("option"));
		
		System.out.println(allOptions.size());
		
		for(int i=0;i<allOptions.size();i++) {
			System.out.println(allOptions.get(i).getText());
		}
		
	
		
	}
}
