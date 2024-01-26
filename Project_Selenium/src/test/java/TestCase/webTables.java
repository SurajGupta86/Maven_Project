package TestCase;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webTables {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Suraj Gupta\\Downloads\\Drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //implicit wait	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  //explicit wait
		
		driver.get("https://demoqa.com/webtables");
		System.out.println("Title of the page is: "+driver.getTitle());
		
		//List<WebElement> rows = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
		//System.out.println(rows.size());		
		int rowsize = driver.findElements(By.xpath("//div[@class='rt-tr-group']")).size();       //calculate the rows in the table
		int colsize = driver.findElements(By.xpath("//div[@class='rt-tr-group'][1]//div[@class='rt-td']")).size();
		System.out.println(rowsize);
		System.out.println(colsize);
		
		for(int r=1;r<=rowsize;r++) {
			for(int col=1;col<=colsize;col++) {
				String text = driver.findElement(By.xpath("//div[@class='rt-tr-group']["+r+"]//div[@class='rt-td']["+col+"]")).getText();
				System.out.print(text+"  ");
			}
			System.out.println();
		}
		
		driver.close();
		
	}
}
	
