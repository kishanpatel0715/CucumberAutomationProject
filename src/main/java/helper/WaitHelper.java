package helper;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WaitHelper {

	WebDriver driver = Browser.getDriver();;
    WebDriverWait wait;
	
	public WebElement waitForElementToBeVisible(By element, int timeOutInSeconds)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	
	 public WebElement waitForElementToBeEnableOrClickable(By element, int timeOutInSeconds)
	 {
	     wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
	     return wait.until(ExpectedConditions.elementToBeClickable(element));
	 }

	 public WebElement waitForElementUntilExist(By element, int timeOutInSeconds)
	 {
	     wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
	     return wait.until(ExpectedConditions.presenceOfElementLocated(element));
	 }

	 public void waitForElementUntilItDisappeares(By element, int timeOutInSeconds)
	 {
	     wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
	     wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
	 }

	 public void waitForElementUntilItGetsText(By element, int timeOutInSeconds, String text)
	 {
	     wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
	     wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(element), text));
	 }

	 public Alert waitForAlert(int timeOutInSeconds)
	 {
	     wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
	     return wait.until(ExpectedConditions.alertIsPresent());
	 }
}