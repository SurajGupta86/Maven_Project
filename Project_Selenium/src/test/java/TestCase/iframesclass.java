package TestCase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class iframesclass {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Suraj Gupta\\Downloads\\Drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //implicit wait	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  //explicit wait
		
		driver.get("https://demoqa.com/frames");
		System.out.println("Title of the page is: "+driver.getTitle());
		
		
		//Performing action in first frame inside the 'framesWrapper'
		WebElement frame1 = driver.findElement(By.xpath("//div[@id='framesWrapper']//iframe[@id='frame1']"));
		driver.switchTo().frame(frame1);
		System.out.println("Frame Text 1: "+driver.findElement(By.xpath("//body//h1[1]")).getText());
		
		driver.switchTo().defaultContent();  //Returning back to the main page
		
		//Performing action in Second frame inside the 'framesWrapper'
		WebElement frame2 = driver.findElement(By.xpath("//div[@id='framesWrapper']//iframe[@id='frame2']"));
		driver.switchTo().frame(frame2);
		System.out.println("Frame Text 2: "+driver.findElement(By.xpath("//body//h1[1]")).getText());
		
		driver.switchTo().defaultContent();  //Returning back to the main page
		
		//Performing some actions on the main page
		driver.findElement(By.xpath("//*[text()='Forms']")).click();		
		driver.findElement(By.xpath("//*[text()='Practice Form']")).click();
		
		driver.close();
	}
	
}
