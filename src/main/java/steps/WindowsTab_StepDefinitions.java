package steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import helper.Browser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.WindowsTab_Page;

public class WindowsTab_StepDefinitions {

    WebDriver driver = Browser.getBrowserDriverInstance();
    WindowsTab_Page windowsTab_Page;
    
    public WindowsTab_StepDefinitions()
    {
        windowsTab_Page = new WindowsTab_Page();
    }
    
    @Given("the user selects Browser Windows from sub-menu")
    public void the_user_selects_browser_windows_from_submenu()
    {
    	windowsTab_Page.selectBrowserWindowsFromSubMenu();
    }
    
    @When("the user clicks the New Tab button")
    public void the_user_clicks_the_new_tab_button()
    {
    	windowsTab_Page.openNewTab();
    }
    
    @When("the user switches to the newly opened tab")
    public void the_user_switches_to_the_newly_opened_tab()
    {
    	Object[] windows = driver.getWindowHandles().toArray();
    	driver.switchTo().window(windows[1].toString());
    }
    
    @Then("the new tab is displayed with the text {string}")
    public void the_new_tab_is_displayed_with_the_text(String expectedText)
    {
       Assert.assertEquals(windowsTab_Page.getNewTabText(), expectedText, "Text is incorrect");
    }
    
    @When("the user clicks the New Window button")
    public void the_user_clicks_the_new_window_button()
    {
       windowsTab_Page.openNewWindow();
    }
    
    @When("the user switches to the newly opened window")
    public void user_switches_to_the_newly_opened_window()
    {
    	Object[] windows = driver.getWindowHandles().toArray();
    	driver.switchTo().window(windows[1].toString());
    }
    
    @Then("the new window is displayed with the text {string}")
    public void new_window_is_displayed_with_the_text(String expectedText)
    {
        Assert.assertEquals(windowsTab_Page.getNewWindowText(), expectedText, "Text is incorrect");
    }
}