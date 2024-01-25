package TestCase;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class checkbox {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Suraj Gupta\\Downloads\\Drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //implicit wait	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  //explicit wait
		driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
		System.out.println("Title of the page is: "+driver.getTitle());
		
		//Clicking the checkbox using a normal method
		//driver.findElement(By.xpath("//div[4]//input[1]")).click();
		
		//Clicking the checkbox using a normal method from different section
		//driver.findElement(By.xpath("//div[6]//input[2]")).click();
		
		//Clicking the checkbox using a normal method tp uncheck it from different section
		driver.findElement(By.xpath("//div[6]//input[1]")).click();
		
		//Clicking the checkbox using a normal method tp uncheck it from different section
		driver.findElement(By.xpath("//div[6]//input[4]")).click();
		
		//Clicking all the checkbox present in a particular section
//		WebElement checkboxblock = driver.findElement(By.xpath("//div[4]"));
//		List<WebElement> checkboxes = checkboxblock.findElements(By.tagName("input"));
//		System.out.println("No of checkboxes: "+checkboxes.size());
//		for(WebElement checkbox: checkboxes) {
//			//System.out.println(checkbox.getAttribute("value"));
//			checkbox.click();
//		}
	
		//Clicking all the checkbox present in a particular section
		WebElement checkboxmainpage = driver.findElement(By.xpath("//td[@class='mainIn']"));
		List<WebElement> checkboxmain = checkboxmainpage.findElements(By.tagName("input"));
		System.out.println("No of checkboxes: "+checkboxmain.size());
		for(WebElement checkbox: checkboxmain) {
			System.out.println(checkbox.getAttribute("value"));
			checkbox.click();
		}
		
		driver.quit();
		
	}
}
