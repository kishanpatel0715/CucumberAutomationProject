package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class FormHelper {

	WebDriver driver;
	
	public FormHelper()
	{
		driver = Browser.driver;
	}
	
	public void enterFormFieldData(By element, String value)
	{
	    driver.findElement(element).sendKeys(value);
	}

	public void selectCheckboxOrRadioButton(By element)
	{
	    driver.findElement(element).click();
	}

	public void selectFromCustomDropDown(By selectElement, String selectOption)
	{
	    driver.findElement(selectElement).click();
	    driver.findElement(By.xpath("//div[text()='"+ selectOption + "']")).click();
	}

	public void selectFromStandardDropDown(By selectElement, String selectOption)
	{
	    Select select = new Select(driver.findElement(selectElement));
	    select.selectByVisibleText(selectOption);
	}
}