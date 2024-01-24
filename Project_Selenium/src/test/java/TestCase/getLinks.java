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
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getLinks{
	
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
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); //Explicit wait
			
			driver.manage().window().maximize();   //Helps to maximize the full screen for the browser 
			
			driver.get("https://www.flipkart.com/");
			System.out.println("Title of the page is: "+driver.getTitle());
			
//			//Print all the links available on the web page
//			List<WebElement> links = driver.findElements(By.tagName("a"));
//			System.out.println(links.size());
//			for(WebElement i : links) {
//				System.out.println(i.getAttribute("href"));
//			}
			
			//Print the links which are there in a bottom section
//			WebElement allLink = driver.findElement(By.xpath("//div[@class='_2j7a4R']"));
//			List<WebElement> url = allLink.findElements(By.tagName("a"));
//			System.out.println(url.size());
//			for(WebElement k : url) {
//				System.out.println(k.getAttribute("title")+"- The URL of the title is :"+k.getAttribute("href"));
//			}
			
			//Print the links which are there in a specific region or block
			WebElement allinks = driver.findElement(By.xpath("//*[text()='Top Stories :']//following::div[@class='_3xGbi-'][1]"));
			//System.out.println(allinks);
			//WebElement allinks = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[2]/div[3]/footer/div/div[1]/div[2]"));
			List<WebElement> urls = allinks.findElements(By.tagName("a"));
			//System.out.println(url.get(1));
			System.out.println(urls.size());
			for(WebElement k : urls) {
				System.out.println(k.getAttribute("title")+"- The URL of the title is :"+k.getAttribute("href"));
			}
			
	}
}
