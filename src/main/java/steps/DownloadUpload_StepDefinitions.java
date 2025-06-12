package steps;

import java.io.File;
import java.nio.file.Paths;
import helper.Browser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DownloadUpload_Page;
import runner.TestRunner;

import org.testng.Assert;

public class DownloadUpload_StepDefinitions {

	DownloadUpload_Page downloadUpload_Page;

	public DownloadUpload_StepDefinitions(Browser manageDriver)
	{
	    downloadUpload_Page = new DownloadUpload_Page();
	}
	
	@Given("user selects the Elements from menu")
	public void user_selects_the_elements_from_menu()
	{
		downloadUpload_Page.selectElementsFromMenu();
	}
	
	@Given("user selects Upload and Download from sub-menu")
	public void user_selects_upload_and_download_from_submenu()
	{
		downloadUpload_Page.selectDownloadAndUploadFromSubMenu();
	}
	
	@When("the user downloads the file")
	public void the_user_downloads_the_file() throws InterruptedException
	{
	   downloadUpload_Page.download();
	}
	
	@Then("the file is downloaded successfully")
	public void the_file_is_downloaded_successfully()
	{
	  File partialDownloadPath = new File(TestRunner.downloadPath);	
	  File fullDownloadPath = new File(Paths.get(partialDownloadPath.getAbsolutePath(),"sampleFile.jpeg").toString());
	  boolean isFileExist = fullDownloadPath.exists();

	  Assert.assertTrue(isFileExist, "File is not downloaded");
	}
	
	@When("the user uploads the file")
	public void the_user_uploads_the_file()
	{
	  downloadUpload_Page.upload();
	}
	
	@Then("the file is uploaded successfully")
	public void the_file_is_uploaded_successfully()
	{
	  Assert.assertTrue(downloadUpload_Page.getUploadedFileName().contains("Kohli.png"), "File is not uploaded");
	}
}