package TestCase;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class isElementPresent {
	
	public static String browser = "chrome";
	public static WebDriver driver;
	
	public static boolean ElementPresent(String locator) {
//		try {
//		driver.findElement(By.id(locator));
//		return true;
//		}catch(Throwable t) {
//			return false;
//		}
		
		int size = driver.findElements(By.xpath(locator)).size();
		System.out.println(size);
		if(size==0) {
			return false;
		}else {
			return true;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		
		
		driver.get("https://www.globalsqa.com/demo-site/draggableboxes/");
		String title = driver.getTitle();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//		Boolean result = driver.findElement(By.id("searchLanguage")).isDisplayed();
//		System.out.println(result);
		
		System.out.println(ElementPresent("//span[text()='Widgets']"));
		System.out.println("Title is "+title);
		driver.manage().window().maximize();
		driver.close();	

	}

}