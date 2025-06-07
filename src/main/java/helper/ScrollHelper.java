package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ScrollHelper {

	WebDriver driver = Browser.getDriver();;

	 public void scrollToTheElement(By element)
	 {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(element));
	 }
}