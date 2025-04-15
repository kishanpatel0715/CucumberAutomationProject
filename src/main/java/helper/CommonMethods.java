package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonMethods {
	
	WebDriver driver;
	
	public CommonMethods()
	{
		driver = Browser.driver;
	}

	public void visit(String url)
	{
	    driver.get(url);
	}

	public void click(By element)
	{
	    driver.findElement(element).click();
	}
}
