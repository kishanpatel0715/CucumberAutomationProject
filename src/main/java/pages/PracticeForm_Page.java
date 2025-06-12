package pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import helper.Browser;
import helper.FormHelper;
import helper.ScrollHelper;

public class PracticeForm_Page {

	WebDriver driver = Browser.getBrowserDriverInstance();
    FormHelper formHelper;
	
	public PracticeForm_Page()
	{
        formHelper = new FormHelper();
	}
	
    public By firstNameElement = By.id("firstName");
    public By lastNameElement = By.id("lastName");
    public By emailElement = By.id("userEmail");
    public By mobileElement = By.id("userNumber");
    public By subjectsElement = By.id("subjectsInput");
    public By pictureElement = By.id("uploadPicture");
    public By currentAddressElement = By.id("currentAddress");
    public By stateElement = By.id("state");
    public By cityElement = By.id("city");
    public By submitElement = By.id("submit");
	public By FormsMenuElement = By.xpath("//*[text()='Forms']");
	public By PracticeFormSubmenuElement = By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div/div[2]/div/ul/li/span");
	
	public void selectFormsFromMenu()
	{
		driver.findElement(FormsMenuElement).click();
	}
	
	public void selectPracticeFormFromSubMenu()
	{
		driver.findElement(PracticeFormSubmenuElement).click();
	}
	
    public void setFirstName(String firstName) {
        formHelper.enterFormFieldData(firstNameElement, firstName);
    }

    public void setLastName(String lastName)
    {
        formHelper.enterFormFieldData(lastNameElement, lastName);
    }

    public void setEmail(String email)
    {
        formHelper.enterFormFieldData(emailElement, email);
    }

    public void setGender(String gender)
    {
        formHelper.selectCheckboxOrRadioButton(By.xpath("//label[text()='" + gender + "']"));
    }

    public void setMobile(String mobile)
    {
        formHelper.enterFormFieldData(mobileElement, mobile);
    }

    public void setSubjects(String subjects)
    {
        new ScrollHelper().scrollToTheElement(subjectsElement);
        formHelper.enterFormFieldData(subjectsElement, subjects);       
    }

    public void setHobbies(String hobbies)
    {
       formHelper.selectCheckboxOrRadioButton(By.xpath("//label[text()='" + hobbies + "']"));
    }

    public void setPicture(String picture)
    {
        formHelper.enterFormFieldData(pictureElement, picture);
    }

    public void setCurrentAddress(String currentAddress)
    {
        formHelper.enterFormFieldData(currentAddressElement, currentAddress);
    }

    public void setState(String state)
    {
        formHelper.selectFromCustomDropDown(stateElement, state);
    }

    public void setCity(String city)
    {
        formHelper.selectFromCustomDropDown(cityElement, city);
    }

    public void enterPracticeFormData(Map<String, String>  model)
    {
        setFirstName (model.get("First Name"));
        setLastName(model.get("Last Name"));
        setEmail(model.get("Email"));
        setGender(model.get("Gender"));
        setMobile (model.get("Mobile"));
        setSubjects(model.get("Subjects"));
        setHobbies(model.get("Hobbies"));
        setPicture(model.get("Picture"));
        setCurrentAddress (model.get("Current Address"));
        setState (model.get("State"));
        setCity (model.get("City"));
    }

    public void submitForm()
    {
        driver.findElement(submitElement).click();
    }

    public Map<String, String> getSubmittedData()
    {
        WebElement table = driver.findElement(By.className("modal-body"));
        List<WebElement> columns = table.findElements(By.tagName("td"));
        Map<String,String> record = new HashMap<>();
        
        record.put("First Name", columns.get(1).getText());
        record.put("Email", columns.get(3).getText());
        record.put("Gender", columns.get(5).getText());
        record.put("Mobile", columns.get(7).getText());
        record.put("Hobbies", columns.get(13).getText());
        record.put("Picture", columns.get(15).getText());
        record.put("Current Address", columns.get(17).getText());
        record.put("State", columns.get(19).getText());
       
        return record;
    }
}