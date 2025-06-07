package pages;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import helper.Browser;

public class PracticeFormPractice_Page {

	WebDriver driver = Browser.getDriver();;
	
	public By firstNameLocator = By.cssSelector("input[id='firstName']");
	public By lastNameLocator = By.cssSelector("input[id='lastName']");
	public By emailLocator = By.id("userEmail");
	public By mobileLocator = By.xpath("//input[contains(@placeholder, 'Mobile')]");
	public By dateOfBirthLocator = By.xpath("//input[starts-with(@id,'dateOf')]");
//	public By subjectLocator = By.xpath("//*[@id='subjectsContainer']/div/div[2]");
	public By subjectLocator = By.id("subjectsContainer");
	public By pictureLocator = By.cssSelector("input[type='file']");
	public By addressLocator = By.cssSelector("#currentAddress.form-control");
	public By stateLocator = By.id("state");
	public By cityLocator = By.id("city");
	
	public void setFirstName(String text) 
	{
		driver.findElement(firstNameLocator).sendKeys(text);
	}
	
	public void setLastName(String text)
	{
		driver.findElement(lastNameLocator).sendKeys(text);
	}
	
	public void setEmail(String text)
	{
		driver.findElement(emailLocator).sendKeys(text);
	}
	
	public void setGender(String gender)
	{
		driver.findElement(By.xpath("//label[text()='" + gender + "']")).click();
	}
	
	public void setMobile(String mobile)
	{
		driver.findElement(mobileLocator).sendKeys(mobile);
	}
	
	public void setDOB(String dob)
	{
		driver.findElement(dateOfBirthLocator).clear();
		driver.findElement(dateOfBirthLocator).sendKeys(dob);
	}
	
	public void setSubjects(String subjects)
	{

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id("subjectsContainer")));	
		js.executeScript("arguments[0].click();", driver.findElement(By.id("subjectsContainer")));	
		js.executeScript("arguments[0].value = 'English';", driver.findElement(By.id("subjectsContainer")));
		js.executeScript(
			    "var e = new KeyboardEvent('keydown', {key: 'Enter', keyCode: 13, which: 13}); document.activeElement.dispatchEvent(e);"
			);
	}
	
	public void setHobbies(String hobbies)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement x = driver.findElement(By.xpath("//*[text()='" + hobbies + "']"));
		js.executeScript("arguments[0].scrollIntoView(true);", x );
		driver.findElement(By.xpath("//*[text()='" + hobbies + "']")).click();
	}
	
	public void setPicture(String picture)
	{
		driver.findElement(pictureLocator).sendKeys(picture);
	}
	
	public void setCurrentAddress(String address)
	{
		driver.findElement(addressLocator).sendKeys(address);
	}
	
	public void setState(String state)
	{
		driver.findElement(stateLocator).click();
		driver.findElement(By.xpath("//*[text()='Rajasthan']")).click();
	}
	
	public void setCity(String city)
	{
		driver.findElement(cityLocator).click();
		driver.findElement(By.xpath("//*[text()='Jaipur']")).click();
	}
	
	public void enterData(Map<String,String> model) 
	{
		  setFirstName(model.get("First Name"));
		  setLastName(model.get("Last Name"));
		  setEmail(model.get("Email"));
		  setGender(model.get("Gender"));
		  setMobile(model.get("Mobile"));
//		  setDOB(model.get("Date Of Birth"));
		  setSubjects(model.get("Subjects"));
		  setHobbies(model.get("Hobbies"));
		  setPicture(model.get("Picture"));
		  setCurrentAddress(model.get("Current Address"));
		  setState(model.get("State"));
		  setCity(model.get("City"));
	}
	
	public void submit()
	{
		driver.findElement(By.id("submit")).click();
	}
}
