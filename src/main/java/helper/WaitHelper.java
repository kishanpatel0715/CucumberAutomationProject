package helper;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WaitHelper {

	WebDriver driver;
	
	public WaitHelper()
	{
		driver = Browser.driver;
	}
	
	public void waitForElementToBeVisible(By element, int time)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
	}
}
