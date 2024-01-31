package actions;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ModalDialog {
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		Actions act = new Actions(driver);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/modal-dialogs");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println(title);
		
		// to click Launch model button - Trigger element
		System.out.println("Clicking launch modal button");
		driver.findElement(By.id("showSmallModal")).click();
		
		// wait to let the modal box be visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-dialog modal-sm")));
		
		// to fetch the web element of the modal container
		System.out.println("Fetching the web element for modal container");
		WebElement modaldialog = driver.findElement(By.className("modal-dialog modal-sm"));
				
		// to fetch the web elements of the modal content and interact with them
		// code to fetch content of modal body and verify it
		WebElement modalcontent = modaldialog.findElement(By.className("modal-body"));
		System.out.println(modalcontent.getText());
		
		// code to click on accept modal button
		 System.out.println("Clicking modal accept button");
		 WebElement modalAcceptButton = modaldialog.findElement(By.className("closeSmallModal"));
		 modalAcceptButton.click();
		
	}

}
