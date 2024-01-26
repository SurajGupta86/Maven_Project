package TestCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class tabsAndwindows {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/browser-windows");
		String title = driver.getTitle();
		System.out.println("Title is "+title);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));  //implicit wait	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //explicit wait
		
		String mainWinHandle = driver.getWindowHandle();  //Get the ID of a particular window
		System.out.println("1st Tab: "+mainWinHandle);
		
		driver.findElement(By.id("tabButton")).click();
		
		
		driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
		
		System.out.println("2nd Tab: "+driver.getWindowHandle());
		Thread.sleep(5000);
		//System.out.println("Title is "+driver.getTitle());
		System.out.println(driver.findElement(By.id("sampleHeading")).getText());
		
		driver.switchTo().window(mainWinHandle);
		driver.findElement(By.xpath("//a[@href='https://demoqa.com']")).click();
				
		//System.out.println(driver.findElement(By.id("sampleHeading")).getText());
		
		
		driver.quit();   //Close all the tabs & windows
		
		//driver.close();  //Close the current tab or window
		
	}
}
