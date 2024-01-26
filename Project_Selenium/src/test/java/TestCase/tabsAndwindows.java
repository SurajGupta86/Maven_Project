package TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class tabsAndwindows {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/browser-windows");
		String title = driver.getTitle();
		System.out.println("Title is "+title);
		driver.manage().window().maximize();
		String mainWinHandle = driver.getWindowHandle();
		
		driver.findElement(By.id("tabButton")).click();
		
		driver.switchTo().window(mainWinHandle);
		driver.findElement(By.xpath("//a[@href='https://demoqa.com']"));
		
//		
//		System.out.println(driver.findElement(By.id("sampleHeading")).getText());
//		System.out.println("Title is "+title);
		
	}
}
