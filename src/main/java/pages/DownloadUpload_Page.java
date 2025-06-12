package pages;

import java.io.File;
import java.nio.file.Paths;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import helper.Browser;
import helper.DownloadHelper;
import runner.TestRunner;

public class DownloadUpload_Page {

	WebDriver driver = Browser.getBrowserDriverInstance();
	
    By downloadElement = By.id("downloadButton");
    By uploadElement = By.id("uploadFile");
    By uploadedFileNameElement = By.id("uploadedFilePath");
    By ElementsMenuElement = By.xpath("//*[text()='Elements']");
	By DownloadUploadSubmenuElement = By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div/div[1]/div/ul/li[8]");
	
	public void selectElementsFromMenu()
	{
		driver.findElement(ElementsMenuElement).click();
	}
	
	public void selectDownloadAndUploadFromSubMenu()
	{
		driver.findElement(DownloadUploadSubmenuElement).click();
	}
	
    public void download() throws InterruptedException
    {
        driver.findElement(downloadElement).click();
        DownloadHelper.waitForDownload("sampleFile.jpeg");
    }

    public void upload()
    {
    	File partialUploadPath = new File(TestRunner.uploadPath);
        driver.findElement(uploadElement).sendKeys(Paths.get(partialUploadPath.getAbsolutePath().toString(), "Kohli.png").toString());
    }

    public String getUploadedFileName()
    {
        return driver.findElement(uploadedFileNameElement).getText();
    }
}