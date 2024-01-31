package actions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alertclass {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		Actions act = new Actions(driver);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println("Title is "+title);
		
		//Perform the Alert function for getting an alert window
//		driver.findElement(By.id("alertButton")).click();
//		Alert alt = driver.switchTo().alert();
//		System.out.println(alt.getText());
//		alt.accept();
		
		//Perform the Alert function for getting an alert window after 5 seconds
//		driver.findElement(By.id("timerAlertButton")).click();
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));  //Using explicit wait to look for alert being present or not
//		wait.until(ExpectedConditions.alertIsPresent());
//		Alert alt_1 = driver.switchTo().alert();
//		System.out.println(alt_1.getText());
//		alt_1.accept();
		
		//Perform the Alert function for getting an alert window with 'Ok' and 'Cancel' option
//		driver.findElement(By.id("confirmButton")).click();
//		Alert alt1 = driver.switchTo().alert();
//		//alt1.wait(2000, 20000);
//		//File screenshot = driver.getScreenshotAs(OutputType.FILE);
//		//FileUtils.copyFile(screenshot, new File("./screenshots/alert.png"));
//		System.out.println(alt1.getText());
//		alt1.dismiss();
	
		//Perform the Alert function for getting an alert window and Sen the text in the textbox
		driver.findElement(By.id("promtButton")).click();
		Alert alt2 = driver.switchTo().alert();
		System.out.println(alt2.getText());
		alt2.sendKeys("Hello");
		//Thread.sleep(2000);
		alt2.accept();	
		
	}
}