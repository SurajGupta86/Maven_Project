package actions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alertclass {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		Actions act = new Actions(driver);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println("Title is "+title);
		
//		driver.findElement(By.id("alertButton")).click();
//		Alert alt = driver.switchTo().alert();
//		System.out.println(alt.getText());
		
		driver.findElement(By.id("timerAlertButton")).click();
		Alert alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.wait();
		
		alt.accept();
		
	}
}