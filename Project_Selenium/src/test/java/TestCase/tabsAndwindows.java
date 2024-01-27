package TestCase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class tabsAndwindows {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/browser-windows");
		String title = driver.getTitle();
		System.out.println("Title is "+title);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //implicit wait	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //explicit wait
		
		String mainWinHandle = driver.getWindowHandle();  //Get the ID of a particular window
		System.out.println("1st Tab: "+mainWinHandle);
		
		
		//Process for the 'New Tab' button clicked
		driver.findElement(By.id("tabButton")).click();
		
		
		driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
		
		System.out.println("2nd Tab: "+driver.getWindowHandle());
		Thread.sleep(5000);
		
		//Screenshot of the page(2nd tab)
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("./screenshots/tabsscreenshot.png"));
		
		//System.out.println("Title is "+driver.getTitle());
		System.out.println(driver.findElement(By.id("sampleHeading")).getText());
		
		driver.switchTo().window(mainWinHandle);
		//driver.findElement(By.xpath("//a[@href='https://demoqa.com']")).click();
				
		
		//Process for the 'New Window' button clicked
		driver.findElement(By.id("windowButton")).click();
		driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
		driver.manage().window().maximize();
		System.out.println("2nd window: "+driver.getWindowHandle());
		
		//Screenshot of the page(2nd window)
		File screenshots = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshots, new File("./screenshots/windowsscreenshot.png"));
		Thread.sleep(5000);
		
		driver.quit();   //Close all the tabs & windows
		
		//driver.close();  //Close the current tab or window
		
	}
}
