package steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import helper.Browser;
import helper.CommonMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.WindowsTab_Page;

public class WindowsTab_StepDefinitions {

    WebDriver driver;
    WindowsTab_Page windowsTab_Page;
    CommonMethods commonMethods;
    
    public WindowsTab_StepDefinitions(Browser manageDriver)
    {
        driver = Browser.driver;
        windowsTab_Page = new WindowsTab_Page(driver);
        commonMethods = new CommonMethods();
    }
    
    @Given("User is on the Browser Windows page")
    public void GivenUserIsOnTheBrowserWindowsPage()
    {
    	commonMethods.visit("https://demoqa.com/browser-windows");
    }
    
    @When("user clicks on New Tab button")
    public void WhenUserClicksOnNewTabButton()
    {
    	windowsTab_Page.openNewTab();
    }
    
    @When("user navigates to the newly opened tab")
    public void WhenUserNavigatesToTheNewlyOpenedTab()
    {
    	Object[] windows = driver.getWindowHandles().toArray();
    	driver.switchTo().window(windows[1].toString());
    }
    
    @Then("newly opened tab is displayed with text {string}")
    public void ThenNewlyOpenedTabIsDisplayedWithText(String expectedText)
    {
       Assert.assertEquals("Text is incorrect", expectedText, windowsTab_Page.getNewTabText());
    }
    
    @When("user clicks on New Window button")
    public void WhenUserClicksOnNewWindowButton()
    {
       windowsTab_Page.openNewWindow();
    }
    
    @When("user navigates to the newly opened window")
    public void WhenUserNavigatesToTheNewlyOpenedWindow()
    {
    	Object[] windows = driver.getWindowHandles().toArray();
    	driver.switchTo().window(windows[1].toString());
    }
    
    @Then("newly opened window is displayed with text {string}")
    public void ThenNewlyOpenedWindowIsDisplayedWithText(String expectedText)
    {
        Assert.assertEquals("Text is incorrect", expectedText, windowsTab_Page.getNewWindowText());
    }
}