package steps;

import java.io.File;
import java.nio.file.Paths;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import helper.Browser;
import helper.CommonMethods;
import helper.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DownloadUpload_Page;

public class DownloadUpload_StepDefinitions {

	WebDriver driver;
	CommonMethods commonMethods;
	DownloadUpload_Page downloadUpload_Page;

	public DownloadUpload_StepDefinitions(Browser manageDriver)
	{
	    driver = Browser.driver;
	    commonMethods = new CommonMethods();
	    downloadUpload_Page = new DownloadUpload_Page(driver);
	}
	
	@Given("User is on the Download and Upload page")
	public void GivenUserIsOnTheDownloadAndUploadPage()
	{
	   commonMethods.visit("https://demoqa.com/upload-download");
	}
	
	@When("user downloads the file")
	public void WhenUserDownloadsTheFile() throws InterruptedException
	{
	   downloadUpload_Page.download();
	}
	
	@Then("file is downloaded successfully")
	public void ThenFileIsDownloadedSuccessfully()
	{
	  File partialDownloadPath = new File(ConfigReader.get("downloadPath"));	
	  File fullDownloadPath = new File(Paths.get(partialDownloadPath.getAbsolutePath(),"sampleFile.jpeg").toString());
	  boolean isFileExist = fullDownloadPath.exists();

	  Assert.assertTrue("File is not downloaded", isFileExist);
	}
	
	@When("user uploads the file")
	public void WhenUserUploadsTheFile()
	{
	  downloadUpload_Page.upload();
	}
	
	 @Then("file is uploaded successfully")
	 public void ThenFileIsUploadedSuccessfully()
	 {
		Assert.assertTrue("File is not uploaded", downloadUpload_Page.getUploadedFileName().contains("Kohli.png"));
	 }
}