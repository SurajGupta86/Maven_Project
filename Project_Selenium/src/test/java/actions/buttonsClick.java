package actions;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class buttonsClick {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		Actions act = new Actions(driver);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/buttons");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println("Title is "+title);
		
		//Perform double click operation
		WebElement doubleclick = driver.findElement(By.xpath("//*[text()='Double Click Me']"));
		act.doubleClick(doubleclick).perform();
		
		Thread.sleep(2000);
		
		//Perform click operation
		driver.findElement(By.xpath("//*[text()='Click Me']")).click();
		
		Thread.sleep(2000);
		
		//Perform a right click operation
		WebElement rightclick = driver.findElement(By.xpath("//*[text()='Right Click Me']"));
		act.contextClick(rightclick).perform();
		
		driver.close();
		
	}
}
