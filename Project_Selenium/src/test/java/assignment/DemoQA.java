package assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoQA {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Suraj Gupta\\Downloads\\Drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //implicit wait	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  //explicit wait
		driver.get("https://demoqa.com/");
		System.out.println("Title of the page is: "+driver.getTitle());
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[text()='Elements']"))).click();
		driver.findElement(By.xpath("//span[text()='Text Box']")).click();
		
		//Fill the Text Box page
		driver.findElement(By.id("userName")).sendKeys("Hello");
		driver.findElement(By.id("userEmail")).sendKeys("ABC@gmail.com");
		driver.findElement(By.id("currentAddress")).sendKeys("XYZ Lane");
		driver.findElement(By.id("permanentAddress")).sendKeys(" ANZ Road");
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("submit"))).click();
		//driver.findElement(By.id("submit")).click();
		
		//Take screenshot of the whole page
		File ss = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ss, new File("./screenshots/demoqapage.jpg"));
		
		System.out.println("Screenshot of the page is captured and stored in a file");
		
		driver.close();
		
	}

}
