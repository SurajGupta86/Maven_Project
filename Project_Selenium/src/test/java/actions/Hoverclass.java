package actions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Hoverclass {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		Actions act = new Actions(driver);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println("Title is "+title);
		
		WebElement electronicsmenu = driver.findElement(By.xpath("//span[text()='Electronics']"));
		//Perform the hover operation using 'Action' class
		act.moveToElement(electronicsmenu).perform();
		WebElement gamingmenu = driver.findElement(By.xpath("//a[text()='Gaming']"));
		act.moveToElement(gamingmenu).perform();
		Thread.sleep(2000);
		
		
		WebElement gamingkeyboard = driver.findElement(By.xpath("//a[text()='Gaming Keyboards']"));
		Thread.sleep(2000);
		//Perform the keyboard operation "Enter" using Action class
		act.sendKeys(gamingkeyboard,Keys.ENTER).perform();
		
		List<WebElement> count = driver.findElements(By.xpath("//img[@loading='eager' and @class='_396cs4']"));
		System.out.println("The number of keyboards present in a section is :"+ count.size());  //Count the keyboard present on the screen

	}
}
