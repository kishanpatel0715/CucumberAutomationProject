package pages;

import java.io.File;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.ConfigReader;
import helper.DownloadHelper;

public class DownloadUpload_Page {

	WebDriver driver;
	
	public DownloadUpload_Page(WebDriver driver)
	{
		this.driver = driver;
	}
	
    By downloadElement = By.linkText("Download");
    By uploadElement = By.cssSelector("input[type=file]");
    By uploadedFileNameElement = By.id("uploadedFilePath");


    public void download() throws InterruptedException
    {
        driver.findElement(downloadElement).click();
        DownloadHelper.waitForDownload("sampleFile.jpeg");
    }

    public void upload()
    {
    	File partialUploadPath = new File(ConfigReader.get("uploadPath"));
        driver.findElement(uploadElement).sendKeys(Paths.get(partialUploadPath.getAbsolutePath().toString(), "Kohli.png").toString());
    }

    public String getUploadedFileName()
    {
        return driver.findElement(uploadedFileNameElement).getText();
    }
}